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

public class RetrievePODataFromPOSTRUCT {
	public static void main(String[] args) {
		System.out.println("started");

		SSLUtilities.trustAllHostnames();
		SSLUtilities.trustAllHttpsCertificates();
		RestUtil restUtil = new RestUtil();
		
		String prodMongoHost = "https://veritasmongoservices.veritas.pcf.dell.com/api/service/getPOStructData";
		String payload = "{\"po_id\":[\"%%\"]}";
		payload = "{\"po_id\":[\"%-60225-D%\"]}";
		
		String respString;
		try {
			respString = restUtil.sendPostRequestMetadata(prodMongoHost, payload);
			JSONArray respArray = new JSONArray(respString);
			System.out.println(respArray);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		System.out.println("ended");
	}
	

}
