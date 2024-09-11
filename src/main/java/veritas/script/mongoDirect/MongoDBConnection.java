package veritas.script.mongoDirect;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoDBConnection {
	
	MongoClient mongoClient = null;
	String uri = "mongodb://svc_npvermngrwsit:~wH%2BiEF_2kaT%2ar0zJmU%3FyxNb@vernlmdatsi11.amer.dell.com:27100/VERITAS_1000450_SIT?authMechanism=PLAIN&replicaSet=poar_ge4_rs&readPreference=primary&authSource=%24external&appname=MongoDB+Compass&ssl=false";
	public static String databaseName = "VERITAS_1000450_SIT";
    
	public MongoClient getMongoClient() {
		mongoClient = MongoClients.create(uri);
		return mongoClient;
	}
	
	public MongoClient getMongoClient(boolean isPROD) {
		if(isPROD) {
			System.out.println("setting prod db");
	    	databaseName = "veritasstore";
	    	uri = "mongodb://svc_prdvermngrw:uq7Z%2a5E0%2BvptRw3%3FfSK_2GLm@verplmdpprd11.us.dell.com:27100,verplmdsprd11.us.dell.com:27100,verpldrmmondb01.us.dell.com:27100/veritasstore?authMechanism=PLAIN&replicaSet=veritas_db_rs&readPreference=secondaryPreferred&authSource=%24external&appname=MongoDB+Compass&ssl=false";
	    
		}
		mongoClient = MongoClients.create(uri);
		return mongoClient;
	}
	
	public boolean closeMongoClient() {
		 if (mongoClient != null) {
             mongoClient.close();
             System.out.println("mongoClient Closed");
         }
		 return true;
	}
}
