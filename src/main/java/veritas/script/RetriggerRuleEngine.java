package veritas.script;

import org.json.JSONArray;
import org.json.JSONObject;

import common.RestUtil;
import common.SSLUtilities;

public class RetriggerRuleEngine {

	private static String getInvoiceDataURL_prod = "https://veritasmongoservices.veritas.pcf.dell.com/api/service/getPOARDataE?";

	public static String RUN_RULE_URL = "https://veritaspy.veritas.pcf.dell.com/run_rule";

	static {
//		System.out.println("non-prod configured");
//		getInvoiceDataURL_prod = "https://veritasmongoservicessit.vnp2.pcf.dell.com/api/service/getPOARDataE?";
//		RUN_RULE_URL = "https://veritaspysit.vnp2.pcf.dell.com/run_rule";
	}

	private static RestUtil restutil = new RestUtil();

	public static void main(String[] args) {
		SSLUtilities.trustAllHostnames();
		SSLUtilities.trustAllHttpsCertificates();
		String dataPOnumberInvoicenum = "[[\"7002269351\",\"10756306013\"],\r\n"
				+ "[\"7002270372\",\"10756306478\"],\r\n" + "[\"7002295016\",\"10756306005\"],\r\n"
				+ "[\"7002295269\",\"10756323568\"],\r\n" + "[\"7002296641\",\"10756323605\"],\r\n"
				+ "[\"7002297440\",\"10756323699\"],\r\n" + "[\"7002297870\",\"10756323728\"],\r\n"
				+ "[\"7002297882\",\"10756306187\"],\r\n" + "[\"7002297899\",\"10756306216\"],\r\n"
				+ "[\"7002298514\",\"10756306064\"],\r\n" + "[\"7002298837\",\"10756323840\"],\r\n"
				+ "[\"7002300634\",\"10756306523\"],\r\n" + "[\"7002300806\",\"10756323998\"],\r\n"
				+ "[\"7002301553\",\"10756306347\"],\r\n" + "[\"7002298746\",\"10756387298\"],\r\n"
				+ "[\"7002299623\",\"10756387327\"],\r\n" + "[\"7002303694\",\"10756414860\"],\r\n"
				+ "[\"7002304265\",\"10756387511\"],\r\n" + "[\"7002304387\",\"10756387423\"],\r\n"
				+ "[\"7002304403\",\"10756387458\"]]\r\n" + "";

		dataPOnumberInvoicenum = "[[ \"W85217\", \"10766398012\" ],[ \"W79230\", \"10766407090\" ],[ \"W84009\", \"10766409160\" ],[ \"W84263\", \"10766409216\" ],[ \"W84303\", \"10766409232\" ],[ \"W84004\", \"10766411415\" ],[ \"W84048\", \"10766411423\" ],[ \"W84224\", \"10766523397\" ],[ \"W84265\", \"10766563873\" ],[ \"W83647\", \"10766566615\" ],[ \"W84020\", \"10766566631\" ],[ \"W83882\", \"10766567468\" ],[ \"W83914\", \"10766567484\" ],[ \"W83944\", \"10766567492\" ],[ \"W83988\", \"10766593417\" ],[ \"W83232\", \"10766634547\" ]]";

		JSONArray dataJson = new JSONArray(dataPOnumberInvoicenum);
		new RetriggerRuleEngine().retriggerRuleEngine(dataJson, "PM");
	}

	public void retriggerRuleEngine(JSONArray dataJson, String ruleTypeIn) {
		restutil.VERITAS_INTERNAL_AUTH_KEY = "D8D2AD87-3329-4D80-8EC7-84E112A48785";
		for (int i = 0; i < dataJson.length(); i++) {
			String ponum = dataJson.getJSONArray(i).getString(0);
			String invnum = dataJson.getJSONArray(i).getString(1);

			try {
				JSONObject inv_data = new JSONObject(restutil
						.sendGetRequest(getInvoiceDataURL_prod + "PONumber=" + ponum + "&INV_Number=" + invnum));
				String dpid = inv_data.getString("DPID");
				System.out.println(dpid);

				String rule = "PartialMatchAmount_001";
				String ruleType = "PM";

				if (ruleTypeIn.contentEquals("TM")) {
					rule = "TotalMatchAmount_001";
					ruleType = "TM";
				}

				String partner = inv_data.getString("PartnerID");

//				try {
//					if(need_to_check_cce_shipped_quantity) {
//					String cce_shipped_quantity_edited = inv_data.getJSONObject("InvoiceData")
//					.getJSONArray("Data").getJSONObject(0)
//					.getJSONObject("invoice_hdr").getString("cce_shipped_quantity_edited");
//					if(cce_shipped_quantity_edited.contentEquals("True")) {
//						System.out.println("cce_shipped_quantity_edited : " + cce_shipped_quantity_edited);
//						cce_shipped_quantity_edited_arr.put(invnum);
//					}
//					}
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}

				String url_string = RUN_RULE_URL + "?" + "dpid=" + dpid + "&poNumber=" + ponum + "&rule=" + rule
						+ "&inv=" + invnum + "&partner=" + partner + "&ruleType=" + ruleType + "" + "&lowerLimit=" + 0
						+ "&upperLimit=" + 0;
				;

				String respDelcce = restutil.sendGetRequest(url_string);
				System.out.println(i + "----" + invnum + " -->  " + respDelcce);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
