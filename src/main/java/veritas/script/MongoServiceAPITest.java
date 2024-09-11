package veritas.script;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import com.google.gson.Gson;

import common.ExcelOperation;
import common.RestUtil;
import common.SSLUtilities;

public class MongoServiceAPITest {
	public static void main(String[] args) {
		System.out.println("started");

		SSLUtilities.trustAllHostnames();
		SSLUtilities.trustAllHttpsCertificates();
		RestUtil restUtil = new RestUtil();
		
		String firstHost = "https://veritasmongoservicessit.vnp2.pcf.dell.com/api/service/";
		String secondHost = "https://veritasmongoservicessit.vnp2.pcf.dell.com/api/service/";
		secondHost = "http://localhost:8080/api/service/";
		secondHost = "https://veritasmongoservicesdev.vnp2.pcf.dell.com/api/service/";
		
		String sheetName = "PORevisionController";
//		sheetName = "POController";
		
		JSONObject dataR = ExcelOperation.getExcelDataAsJsonObject("C:\\Users\\sasanka_talukder\\OneDrive - Dell Technologies\\Documents\\GitHub\\Veritas\\story related\\mongo db upgrade/mongodb service api.xlsx");
		JSONArray Sheet2 = dataR.getJSONArray(sheetName);
		int totalCount = Sheet2.length();
		int succCount = 0;
		int failCount = 0;
		for(int i=0;i<totalCount;i++) {
			System.out.println("--------------------> "+i);
			String method = Sheet2.getJSONObject(i).getString("Method");
//			String first_response = Sheet2.getJSONObject(i).get("RESPONSE PAYLOAD") + "";
//			System.out.println(Sheet2.getJSONObject(i).get("REQUEST PAYLOAD"));	
//			System.out.println(Sheet2.getJSONObject(i).get("Method"));
//			System.out.println(Sheet2.getJSONObject(i).get("Test Type"));
			String URI = Sheet2.getJSONObject(i).getString("URI");
			System.out.println(URI);
			try {
				if(method.contentEquals("GET")) {
						String respGet = restUtil.sendGetRequest(firstHost + URI).replaceAll("\\s+","");
						String respGet_2 = restUtil.sendGetRequest(secondHost + URI).replaceAll("\\s+","");
	//					System.out.println(respGet);
	//					System.out.println(Sheet2.getJSONObject(i).getString("RESPONSE PAYLOAD"));
	//					System.out.println(respGet);
	//					
	//					System.out.println(Sheet2.getJSONObject(i).getString("RESPONSE PAYLOAD").replaceAll("[^a-zA-Z]+", ""));
	//					System.out.println(respGet.replaceAll("[^a-zA-Z]+", ""));
						boolean compareResp = respGet.contentEquals(respGet_2);
						if(compareResp) { 
							succCount++;
						} else {
							failCount++;
						}
						System.out.println("-------------------------------------------------------------------------" + compareResp);
						System.out.println(respGet);
						System.out.println(respGet_2);
				}
				else if(method.contentEquals("POST")) {
						System.out.println("REQUEST PAYLOAD :: " + Sheet2.getJSONObject(i).getString("REQUEST PAYLOAD"));
						String respGet = restUtil.sendPostRequest(firstHost + URI, Sheet2.getJSONObject(i).getString("REQUEST PAYLOAD")).replaceAll("\\s+","");
						String respGet_2 = restUtil.sendPostRequest(secondHost + URI, Sheet2.getJSONObject(i).getString("REQUEST PAYLOAD")).replaceAll("\\s+","");
						
	//					String respGet = restUtil.sendPostRequest(Sheet2.getJSONObject(i).getString("URI"), Sheet2.getJSONObject(i).getString("REQUEST PAYLOAD")) ;
	//					System.out.println("-------------------------------------------------------------------------" + first_response.replaceAll("[^a-zA-Z]+", "").contentEquals(respGet.replaceAll("[^a-zA-Z]+", "")));
//						System.out.println("-------------------------------------------------------------------------" + respGet.contentEquals(respGet_2));
						
						boolean compareResp = respGet.contentEquals(respGet_2);
						if(compareResp) { 
							succCount++;
						} else {
							failCount++;
						}
						System.out.println("-------------------------------------------------------------------------" + compareResp);
						System.out.println(respGet);
						System.out.println(respGet_2);
				}
			} catch (Exception e) {
				System.out.println("-------------------------------------------------------------------------" + false);
				failCount++;
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("sheetName : " + sheetName + ",totalCount : " + totalCount + ",failCount : " + failCount + ",succCount : " + succCount);
		System.out.println(dataR);
		System.out.println("ended");
	}
	
	private static final Gson gson = new Gson();
	public static boolean isJSONValid(String jsonInString) {
	      try {
	          gson.fromJson(jsonInString, Object.class);
	          return true;
	      } catch(com.google.gson.JsonSyntaxException ex) { 
	          return false;
	      }
	  }
	
	public static boolean isJSONEqual(String expectedJson,String actualJson) {
	      try {
	    	  JSONAssert.assertEquals(expectedJson, actualJson, JSONCompareMode.STRICT);
	          return true;
	      } catch(com.google.gson.JsonSyntaxException ex) { 
	          return false;
	      }
	  }
}
