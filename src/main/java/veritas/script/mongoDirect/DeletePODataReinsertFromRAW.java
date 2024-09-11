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
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import common.RestUtil;

public class DeletePODataReinsertFromRAW {
	static String prodMongoHost = "https://veritasintegration.veritas.pcf.dell.com/ciw_po_data";

	static List<String> poNumbers = Arrays.asList("10-21570-D");
	
	MongoDatabase database = null;

	public static void main(String[] args) {
		
		String poNums[] = {"67-00647-D", "14-30979-D", "70-TQ128-D", "67-01101-D", "10-DZ361-D", "89-00997-D", "10-01105-D", "41-42224-D", "20-QZZ33-D", "10-DZ076-D", "89-CUW01-D", "89-24305-D", "89-01019-D", "89-01060-D", "10-22501-D", "89-CUW35-D", "89-CUW34-D", "89-01251-D", "20-41541-D", "89-01303-D", "89-59995-D", "70-TPZ51-D", "89-CUR37-D", "20-22262-D", "10-22066-D", "10-22557-D", "60-HV199-D"};
		poNumbers = Arrays.asList(poNums);
		
		new DeletePODataReinsertFromRAW().processPOnos(poNumbers);
	}

	private void processPOnos(List<String> poNumbers2) {
		MongoDBConnection mongoUtil = new MongoDBConnection();
		MongoClient mongoClient = mongoUtil.getMongoClient(true);
		database = mongoClient.getDatabase(MongoDBConnection.databaseName);
		deleteOrderDataFromPO();
		getOrderDataFromOrderRaw();
		mongoUtil.closeMongoClient();
		
	}

	private void deleteOrderDataFromPO() {
		try {
			MongoCollection<Document> collection = database.getCollection("PO_STRUCT_DATA");
			Document filter = new Document("PONumber", new Document("$in", poNumbers));
			DeleteResult updateResult = collection.deleteMany(filter);
			System.out.println("PO Update operation completed. getMatchedCount : " + updateResult.getDeletedCount());
			System.out.println("PO Update operation completed. getModifiedCount : " + updateResult.wasAcknowledged());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void getOrderDataFromOrderRaw() {
		try {
			MongoCollection<Document> collection = database.getCollection("PO_STRUCT_RAW");
			for(String onepoNumbers : poNumbers) {
				Document query = new Document("PONumber", onepoNumbers).append("Type","CIW_PO");
				try (MongoCursor<Document> cursor = collection.find(query).iterator()) {
					while (cursor.hasNext()) {
						Document document = cursor.next();
						pushOrderDataIntoPOconverter(document.getString("cXML"));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void pushOrderDataIntoPOconverter(String payload) {
		RestUtil restUtil = new RestUtil();
		try {
			restUtil.VERITAS_INTERNAL_AUTH_KEY = "D8D2AD87-3329-4D80-8EC7-84E112A48785";
			String respString = restUtil.sendPostRequestXML(prodMongoHost, payload);
			System.out.println("response string : " + respString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
