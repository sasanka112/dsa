package veritas.script;

import org.json.JSONArray;
import org.json.JSONObject;

import common.RestUtil;
import common.SSLUtilities;


public class UpdateLineMapVeritas {
	
	private static String getInvoiceDataURL_prod = "https://veritasmongoservices.veritas.pcf.dell.com/api/service";
	
	private static RestUtil restutil = new RestUtil();
	public static void main(String[] args) {
		SSLUtilities.trustAllHostnames();
		SSLUtilities.trustAllHttpsCertificates();
		String dataPOnumberInvoicenum = "[[\"7002269351\",\"10756306013\"],\r\n"
				+ "[\"7002270372\",\"10756306478\"],\r\n"
				+ "[\"7002295016\",\"10756306005\"],\r\n"
				+ "[\"7002295269\",\"10756323568\"],\r\n"
				+ "[\"7002296641\",\"10756323605\"],\r\n"
				+ "[\"7002297440\",\"10756323699\"],\r\n"
				+ "[\"7002297870\",\"10756323728\"],\r\n"
				+ "[\"7002297882\",\"10756306187\"],\r\n"
				+ "[\"7002297899\",\"10756306216\"],\r\n"
				+ "[\"7002298514\",\"10756306064\"],\r\n"
				+ "[\"7002298837\",\"10756323840\"],\r\n"
				+ "[\"7002300634\",\"10756306523\"],\r\n"
				+ "[\"7002300806\",\"10756323998\"],\r\n"
				+ "[\"7002301553\",\"10756306347\"],\r\n"
				+ "[\"7002298746\",\"10756387298\"],\r\n"
				+ "[\"7002299623\",\"10756387327\"],\r\n"
				+ "[\"7002303694\",\"10756414860\"],\r\n"
				+ "[\"7002304265\",\"10756387511\"],\r\n"
				+ "[\"7002304387\",\"10756387423\"],\r\n"
				+ "[\"7002304403\",\"10756387458\"]]\r\n"
				+ "";
		
		JSONArray dataJson = new JSONArray(dataPOnumberInvoicenum);
		restutil.VERITAS_INTERNAL_AUTH_KEY = "D8D2AD87-3329-4D80-8EC7-84E112A48785";
		String lineMapReqBody = "{\r\n"
				+ "    \"POLines\":\"['1']\"\r\n"
				+ "}";
		for(int i=1;i<dataJson.length();i++) {
			String ponum = dataJson.getJSONArray(i).getString(0);
			String invnum = dataJson.getJSONArray(i).getString(1);
			
			try {
				JSONObject inv_data = new JSONObject(restutil.sendGetRequest(getInvoiceDataURL_prod + "/getPOARDataE?" + "PONumber="+ponum+"&INV_Number="+invnum));
				System.out.println(invnum + " -- " + inv_data.getString("Status") + " -=- " + inv_data.getString("ReasonCode"));
				String dpid = inv_data.getString("DPID");

				String resp_data = restutil.sendPostRequest(getInvoiceDataURL_prod + "/updateInvDataRuleEngine?invNumber="+invnum+"&dpid="+dpid,
						lineMapReqBody);
				System.out.println(resp_data);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
