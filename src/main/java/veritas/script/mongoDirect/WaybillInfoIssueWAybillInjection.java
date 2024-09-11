package veritas.script.mongoDirect;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import com.mongodb.client.result.UpdateResult;

public class WaybillInfoIssueWAybillInjection {
	static List<String> poNumbers = Arrays.asList("W79230", "W83232",
			  "W83647", "W83882",
			  "W83914", "W83944",
			  "W83988", "W84004",
			  "W84009", "W84020",
			  "W84048", "W84224",
			  "W84263", "W84265",
			  "W84303", "W85217");
	MongoClient mongoClient = null;
	
	public static void main(String[] args) {
		new WaybillInfoIssueWAybillInjection().executeTheProcess();
	}
	
	public void executeTheProcess() {
		MongoDBConnection mongoUtil = new MongoDBConnection();
		mongoClient = mongoUtil.getMongoClient();
		deleteOrderDataFromAR_PO();
		getOrderDataFromOrderRaw();
		mongoUtil.closeMongoClient();
	}

	private void deleteOrderDataFromAR_PO() {
		try {
			MongoDatabase database = mongoClient.getDatabase(MongoDBConnection.databaseName);
			MongoCollection<Document> collection = database.getCollection("AR_STRUCT_DATA");
			Document filter = new Document("PONumber", new Document("$in", poNumbers));
			Document update = new Document("$unset", new Document("WayBillNumbers", 1));
			UpdateResult updateResult = collection.updateMany(filter, update);
			System.out.println("Inv Update operation completed. getMatchedCount : " + updateResult.getMatchedCount());
			System.out.println("Inv Update operation completed. getModifiedCount : " + updateResult.getModifiedCount());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getOrderDataFromOrderRaw() {
		try {
			MongoDatabase database = mongoClient.getDatabase(MongoDBConnection.databaseName);

			MongoCollection<Document> collection = database.getCollection("ORDER_STRUCT_RAW");
			Document filter = new Document("PONumber", new Document("$in", poNumbers));

			Map<String, Document> latestOrderData = new HashMap<>();

			try (MongoCursor<Document> cursor = collection.find(filter).iterator()) {
				while (cursor.hasNext()) {
					Document document = cursor.next();
//					System.out.println(document.toJson());

					String orderNumber = document.getString("OrderNumber");
					System.out.println("orderNumber : " + orderNumber);
					int version = Integer.parseInt(document.getString("Version"));
					document.replace("Version", version);
					latestOrderData.merge(orderNumber, document,
							(existing, newDoc) -> newDoc.getInteger("Version") > existing.getInteger("Version") ? newDoc
									: existing);
				}
			}

			System.out.println("Print the latest version of each OrderNumber");
			// Print the latest version of each OrderNumber
			latestOrderData.values().forEach(doc -> {
//				System.out.println(doc.toJson());
//				pushOrderDataIntoPOconverter(doc.toJson());
				updateARdocuments(database,doc);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateARdocuments(MongoDatabase database ,Document orderData) {

		Document orderdetails = (Document) orderData.get("orderdetails");
		String orderNumber = orderData.getString("OrderNumber");
		
		String PONumber = orderData.getString("PONumber");

		List<Document> shippingInfo = (List<Document>) orderdetails.get("shippingInfo");
		List<Document> myArrayList = new ArrayList<>();

		for (Document oneshippingInfo : shippingInfo) {
			if (oneshippingInfo.containsKey("wayBillNumber")) {

				Document wayBillMap = new Document("wayBillNumber", oneshippingInfo.get("wayBillNumber"))
						.append("carrierName", oneshippingInfo.get("carrierName")).append("order_number", orderNumber)
						.append("carrierCode", oneshippingInfo.get("carrierCode"));

				Document wayBillEntry = new Document("map", wayBillMap).append("_class", "org.json.JSONObject");

				myArrayList.add(wayBillEntry);
			}
		}
		// Create the final WayBillNumbers document
		Document wayBillNumbersDoc = new Document("myArrayList", myArrayList).append("_class", "org.json.JSONArray");

		// Create the update document
		Document update = new Document("$set", new Document("WayBillNumbers", wayBillNumbersDoc));

		// Define the criteria
		List<String> orderNumbers = Arrays.asList(orderNumber);

		// Create the query
		Document query = new Document("PONumber", PONumber).append("OrderNumbers",
				new Document("$in", orderNumbers));

		// Update the document in the collection
		UpdateResult updateResult = database.getCollection("AR_STRUCT_DATA").updateMany(query, update);
		System.out.println("Inv Update operation completed. getMatchedCount : " + updateResult.getMatchedCount());
		System.out.println("Inv Update operation completed. getModifiedCount : " + updateResult.getModifiedCount());
		System.out.println("orderNumber : " + query);
	}

}
