package veritas.script;

import org.json.JSONArray;

import common.RestUtil;
import common.SSLUtilities;

public class StuckInvoiceReprocess {
	public static void main(String[] args) {
		System.out.println("started");

		SSLUtilities.trustAllHostnames();
		SSLUtilities.trustAllHttpsCertificates();
		RestUtil restUtil = new RestUtil();
		
		String prodMongoHost = "https://veritasoracleservices.veritas.pcf.dell.com/aging-report/csvData";
		String payload = "{\"profileIds\":[\"Ascension_Health_GHX\"],\"status\":[\"Match Success\"]"
				+ ",\"range\":[\"DAYS_0\",\"DAYS_1__7\",\"DAYS_8__14\",\"DAYS_15__21\",\"DAYS_22__30\",\"DAYS_31\"]}";
		
		String respString;
		try {
			respString = restUtil.sendPostRequest(prodMongoHost, payload);
			JSONArray respArray = new JSONArray(respString);
			System.out.println("respArray.length() :: " + respArray.length());
			
			JSONArray dataJson = new JSONArray();
			for(int i=0;i<respArray.length();i++) {
				JSONArray oneElement = new JSONArray();
				oneElement.put(respArray.getJSONObject(i).getString("poNumber"));
				oneElement.put(respArray.getJSONObject(i).getString("invoiceNumber"));
				dataJson.put(oneElement);
			}
			new RetriggerRuleEngine().retriggerRuleEngine(dataJson, "TM");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		System.out.println("ended");
	}
}
