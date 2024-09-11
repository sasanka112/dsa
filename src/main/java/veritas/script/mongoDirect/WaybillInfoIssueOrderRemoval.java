package veritas.script.mongoDirect;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;

import common.RestUtil;

public class WaybillInfoIssueOrderRemoval {
	static String prodMongoHost = "https://veritasintegrationsit.vnp2.pcf.dell.com/order_data";

	static List<String> poNumbers = Arrays.asList("35486619");
	
	static String dpidNos = null;

	public static void main(String[] args) {
		deleteOrderDataFromAR_PO();
		deleteUnmergedFromPO();
		getOrderDataFromOrderRaw();
	}

	private static void deleteOrderDataFromAR_PO() {
		MongoDBConnection mongoUtil = new MongoDBConnection();
		try {
			MongoClient mongoClient = mongoUtil.getMongoClient();
			MongoDatabase database = mongoClient.getDatabase("VERITAS_1000450_SIT");
			MongoCollection<Document> collection = database.getCollection("PO_STRUCT_DATA");
			Document filter = new Document("PONumber", new Document("$in", poNumbers));
			Document update = new Document("$unset", new Document("OrderData", 1));
			UpdateResult updateResult = collection.updateMany(filter, update);
			System.out.println("PO Update operation completed. getMatchedCount : " + updateResult.getMatchedCount());
			System.out.println("PO Update operation completed. getModifiedCount : " + updateResult.getModifiedCount());
			
			update = new Document("$unset", new Document("OrderData", 1)
                    .append("WayBillNumbers", 1));
			collection = database.getCollection("AR_STRUCT_DATA");
			updateResult = collection.updateMany(filter, update);
			System.out.println("Inv Update operation completed. getMatchedCount : " + updateResult.getMatchedCount());
			System.out.println("Inv Update operation completed. getModifiedCount : " + updateResult.getModifiedCount());
			mongoUtil.closeMongoClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteUnmergedFromPO() {
		MongoDBConnection mongoUtil = new MongoDBConnection();
		try {
			MongoClient mongoClient = mongoUtil.getMongoClient();
			MongoDatabase database = mongoClient.getDatabase("VERITAS_1000450_SIT");
			MongoCollection<Document> collection = database.getCollection("PO_STRUCT_DATA");
			
			 // Define the filter
            Bson filter = Filters.and(
                Filters.exists("POData.OT_CXML_PO_DATA.cXML.SubTotal", false),
                Filters.in("PONumber", poNumbers)
            );

            // Retrieve the PONumber values of the documents to be deleted
            List<String> deletedPONumbers = new ArrayList<>();
            try (MongoCursor<Document> cursor = collection.find(filter).iterator()) {
                while (cursor.hasNext()) {
                    Document document = cursor.next();
                    String poNumber = document.getString("PONumber");
                    if (poNumber != null) {
                        deletedPONumbers.add(poNumber);
                    }
                }
            }

            // Perform the delete operation
            collection.deleteMany(filter);

            // Print the PONumber values of the deleted documents
            System.out.println("Deleted PONumbers: " + deletedPONumbers);
            mongoUtil.closeMongoClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	private static void getOrderDataFromOrderRaw() {
		MongoDBConnection mongoUtil = new MongoDBConnection();
		try {
			MongoClient mongoClient = mongoUtil.getMongoClient();
			MongoDatabase database = mongoClient.getDatabase("VERITAS_1000450_SIT");
			MongoCollection<Document> collection = database.getCollection("ORDER_STRUCT_RAW");
			Document filter = new Document("PONumber", new Document("$in", poNumbers));
			
			
			
			
			
			try (MongoCursor<Document> cursor = mongoUtil.getMongoClient().getDatabase("VERITAS_1000450_SIT").getCollection("PO_STRUCT_DATA")
					.find(filter).iterator()) {
				while (cursor.hasNext()) {
					Document document = cursor.next();
					String DPIDNumber = document.getString("DPID");
					System.out.println("PO DPIDNumber : " + DPIDNumber);
					dpidNos = DPIDNumber;
				}
			}
			
			Map<String, Document> latestOrderData = new HashMap<>();

			try (MongoCursor<Document> cursor = collection.find(filter).iterator()) {
				while (cursor.hasNext()) {
					Document document = cursor.next();
					System.out.println(document.toJson());

					String orderNumber = document.getString("OrderNumber");
					int version = Integer.parseInt(document.getString("Version"));
					document.replace("Version", version);
					
					((Document) document.get("orderdetails")).put("dpid", dpidNos);

					latestOrderData.merge(orderNumber, document,
							(existing, newDoc) -> newDoc.getInteger("Version") > existing.getInteger("Version") ? newDoc
									: existing);
				}
			}

			System.out.println("Print the latest version of each OrderNumber");
			// Print the latest version of each OrderNumber
			latestOrderData.values().forEach(doc -> {
				System.out.println(doc.toJson());
				pushOrderDataIntoPOconverter(doc.toJson());
			});

			mongoUtil.closeMongoClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void pushOrderDataIntoPOconverter(String payload) {
		RestUtil restUtil = new RestUtil();
		try {
			String respString = restUtil.sendPostRequest(prodMongoHost, payload);
			System.out.println("response string : " + respString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
