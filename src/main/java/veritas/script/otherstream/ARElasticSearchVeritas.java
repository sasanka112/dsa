package veritas.script.otherstream;




import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import common.RestUtil;


public class ARElasticSearchVeritas {
	
	private RestUtil restutil = new RestUtil();
	private final static String PROD_ES_REST = "https://argflescl01.amer.dell.com:9205/ar_gateway_event/_search";
	private final static String PROD_AR_REST ="https://arapigateway-prod.argw.pcf.dell.com/giss/getInvoiceData?customer_trx_id=";
//	public JSONArray custtrxIDs = new JSONArray();
//	public JSONArray checkerSuccess = new JSONArray();
	public JSONObject respData = new JSONObject("{\r\n" + 
			"    \"custtrxIDs\": [\r\n" + 
			"    ],\r\n" + 
			"    \"checkerSuccess\": [\r\n" + 
			"    ],\r\n" + 
			"    \"retrigger\": [\r\n" + 
			"    ]\r\n" + 
			"}");
	
	private static String getInvoiceDataURL_prod = "https://veritasmongoservices.veritas.pcf.dell.com/api/service/getPOARDataE?";
	
	private static String gars_checker_Service = "https://veritaschecker.veritas.pcf.dell.com/gars_checker";
	
	private static String retrigger_url = "https://veritasintegration.veritas.pcf.dell.com/invoice_data_ar";
	
	private static String checkOCN_Oracle_prod = "https://veritasoracleservices.veritas.pcf.dell.com/profile-management/customer?omegacustomernumber=";
	


	public static void main(String[] args) {
		
		String gt = "now-1h";
		String lt = "now-0h";
		
		long l1 = System.currentTimeMillis();
		

		System.out.println("aresVeritas.checkerSuccess : " + new ARElasticSearchVeritas().getResponseData(gt, lt));
		System.out.println("Time taken : " + (System.currentTimeMillis() - l1));
	}
	
	
	

	public JSONObject getResponseData(String gt, String lt) {
		ARElasticSearchVeritas aresVeritas = new ARElasticSearchVeritas();
		System.out.println("aresVeritas.checkerSuccess : " + aresVeritas.respData);
		System.out.println("aresVeritas.custtrxIDs.length() : " + aresVeritas.respData.getJSONArray("custtrxIDs").length());
		
		boolean retrigger_flag = true;
		retrigger_flag = false;
		String str = aresVeritas.getDataFromESAR(gt,lt);
		System.out.println("aresVeritas.custtrxIDs.length() : " + aresVeritas.respData.getJSONArray("custtrxIDs").length());
		System.out.println(aresVeritas.respData.getJSONArray("custtrxIDs"));
		
		JSONArray custtrxIDss = aresVeritas.filterVeritasNeededInvoices(aresVeritas.respData.getJSONArray("custtrxIDs"), retrigger_flag);
		
		return aresVeritas.respData;
		
	}




	public JSONArray filterVeritasNeededInvoices(JSONArray custtrxIDs2,boolean retrigger_flag) {
		// TODO Auto-generated method stub
		for(int i=0;i<custtrxIDs2.length();i++) {
			try {
				String arResponseData = restutil.sendGetRequest(PROD_AR_REST + custtrxIDs2.getString(i));
				JSONObject jsonObj = new JSONObject(arResponseData);
				String invNumber = jsonObj.getJSONObject("invoice_data").getJSONObject("invoice_hdr")
						.getString("trx_number");
				
				String cust_num = jsonObj.getJSONObject("invoice_data").getJSONObject("invoice_customer")
						.getString("cust_num");
				
				String purchase_order = null;
				
				if(jsonObj.getJSONObject("invoice_data").getJSONObject("invoice_hdr").has("purchase_order")) {
					purchase_order = jsonObj.getJSONObject("invoice_data").getJSONObject("invoice_hdr")
							.getString("purchase_order");
				}
				else {
					System.out.println("purchase order num is not present");
				}
				
				
				System.out.println(i + "--> " + invNumber + " " + cust_num + " " + purchase_order);
				
				if(purchase_order != null) {
					
					String checkerResponse = "";
					
//					String request = "{\r\n" + 
//							"    \"CustomerNumber\": \""+cust_num+"\",\r\n" + 
//							"    \"OrderNumber\": \"713114999500\",\r\n" + 
//							"    \"InvoiceType\": \"INV\",\r\n" + 
//							"    \"TrxContext\": \"ORDER ENTRY\",\r\n" + 
//							"    \"BuId\": \"4075\",\r\n" + 
//							"    \"PONumber\": \"77777777777777\"\r\n" + 
//							"}";
//					
//					String checkerResponse  = restutil.sendPostRequest(gars_checker_Service, request,false);
//					
//					System.out.println(checkerResponse);
					
					String oracle_data_str = restutil.sendGetRequest(
							checkOCN_Oracle_prod + cust_num);
					System.out.println(oracle_data_str);
					if(oracle_data_str.length() > 4) {
						checkerResponse = "success";
					}
					
					
					if(checkerResponse.contains("success")) {
						String inv_data_str = restutil.sendGetRequest(
								getInvoiceDataURL_prod + "PONumber=" + purchase_order + "&INV_Number=" + invNumber);
//						System.out.println(inv_data_str);
//						if (inv_data_str.length() > 20) {
//							System.out.println(inv_data_str);
							try {
								JSONObject inv_data = new JSONObject(inv_data_str);
								String dpid = inv_data.getString("DPID");
								System.out.println("dpid : " + dpid);
							} catch (Exception e) {
								respData.getJSONArray("checkerSuccess").put(invNumber);
								if(retrigger_flag) {
									String request_repush = "{\"ABACUS_MESSAGE_EVENT\":{\"MSG_BODY\":\"\",\"ROUTING_PARAMETERS\":{\"EINVOICE_STATUS\":\"NOTAPPLICABLE\",\"PARENT_CHANNEL\":\"CMR\",\"BUID\":\"11\",\"REASON_CODE\":\"\",\"TRX_CREATION_DATE\":\"06-03-2023\",\"SUB_CHANNEL\":\"LRB\",\"ORIG_SYSTEM\":\"N\",\"SETT_DOA_FLAG\":\"\",\"EVENT_NAME\":\"dell.apps.xxg.arstore.transaction.complete\",\r\n" + 
											"\"INTERFACE_HEADER_CONTEXT\":\"CREDIT AND REBILL\",\"CRI_FLAG\":\"Y\",\"SABRIX_FLAG\":\"Y\",\"TERM_TRX_FLAG\":\"Y\",\"TERM_NAME\":\"\",\"TOTAL_LINE_NUMBER\":\"5500\",\"SETTLEMENT_FLAG\":\"N\",\"MAX_LINE_NUMBER\":\"5500\",\"RETURN_ORDER_SOURCE\":\"\",\"DELL_ACCT_FLAG\":\"N\",\"INT_HDR_ATTRIBUTE15\":\"C609986755\",\"IMPORTED_TRX\":\"N\",\r\n" + 
											"\"SALES_CHANNEL_CODE\":\"US_18\",\"GOVT_APPR_FLAG\":\"N\",\"DFS_FLAG\":\"N\",\"CREATED_FROM\":\"AR_INVOICE_API\",\"DOC_SEQUENCE_VALUE\":\"1065665439\",\"WTM_FLAG\":\"N\",\"TRX_TYPE\":\"INV\",\"CT_REFERENCE\":\"609986755\",\"TRX_NUM\":\"10656654391\",\"GATEWAY_SBX_INV_NUM\":\"318723700\",\"MsgTimestamp\":\"2023-03-07 01:16:34\",\"PREV_PMT_TERM\":\"\",\"TRX_SOURCE\":\"ORDER ENTRY\",\r\n" + 
											"\"ORD_CLASS_CODE\":\"\",\"BATCH_ID\":\"36337826\",\"NOVORA_FLAG\":\"N\",\"CHECK_NUMBER_FLAG\":\"N\",\"STEALTH_FLAG\":\"N\",\"INTERFACE_HEADER_ATTRIBUTE1\":\"609986755\"},\"MSG_HEADER\":{\"BUSINESS_OBJ_TYPE\":\"ARInvoice\",\"SRC_MSG_ID\":\"254ea5ec-0ffc-49ef-a902-f51b818a71a2\",\"IDENTIFIER10\":\"F63C56B90FD76081E053640DBF0A7488\",\"IDENTIFIER1\":\"609986755\",\"MSG_TIMESTAMP\":\"2023-03-07 01:16:34\",\r\n" + 
											"\"IDENTIFIER2\":\"11\",\"IMPL_NAME\":\"AR_GATEWAY\",\r\n" + 
											"\"IDENTIFIER3\":\""+custtrxIDs2.getString(i)+"\",\"IDENTIFIER4\":\"INV\",\"ORIGINATOR_SYSTEM\":\"OMAR\",\"IDENTIFIER5\":\"10656654391\",\"DESTINATION_SYSTEM\":\"VERITAS\",\"IDENTIFIER6\":\"INV\",\"MSG_FLOW_TYPE\":\"ASYNC\",\"IDENTIFIER7\":\"\",\"IDENTIFIER8\":\"AR-STORE\",\"PARENT_MSG_ID\":\"7a0bc47c-cd84-48c6-906d-ec4d1a3dfa5e\",\"IDENTIFIER9\":\"\",\r\n" + 
											"\"MSG_TYPE\":\"CreditDebitMemoOrderType\",\"DERIVED_MSG_ID\":\"254ea5ec-0ffc-49ef-a902-f51b818a71a2_VERITAS\",\"IMPL_VERSION\":\"1.0\",\"OPERATION\":\"SendToVeritas\"},\"DESTINATION\":{\"NAME\":\"VERITAS\",\"CONFIGURATION\":[{\"ID\":\"1\",\"ActorName\":\"RoutingActor\",\"Version\":\"1.0\",\"Groups\":[\"orders\"],\r\n" + 
											"\"NodePath\":\"/user/RoutingActor\"},{\"ID\":\"2\",\"ActorName\":\"AREnrichmentActor\",\"Version\":\"1.0\",\"Groups\":[\"orders\"],\"NodePath\":\"/user/AREnrichmentActor\"},{\"ID\":\"3\",\"ActorName\":\"VeritasValidationActor\",\"Version\":\"1.0\",\"Groups\":[\"orders\"],\"NodePath\":\"/user/VeritasValidationActor\"},{\"ID\":\"4\",\"ActorName\":\"RabbitMQPublishActor\",\r\n" + 
											"\"Version\":\"1.0\",\"Groups\":[\"orders\"],\"NodePath\":\"/user/RabbitMQPublishActor\"},{\"ID\":\"5\",\"ActorName\":\"STOP\",\"Version\":\"1.0\",\"Groups\":[\"orders\"],\"NodePath\":\"/user/StopActor\"}]}},\"SRC_ID\":\"254ea5ec-0ffc-49ef-a902-f51b818a71a2_VERITAS\",\"ABACUS_VERSION\":\"PROD\",\"ABACUS_IMPLEMENTATION\":\"AR_INVOICE\",\"RETRY_COUNT\":1,\"SOURCE\":\"RABBIT_MQ: ARGW_PROD||Q.ARGW_VERITAS_DOWNSTREAM.ARGW||argateway-rmq.us.dell.com||8071\"}\r\n" + 
											"";
									restutil.sendPostRequest(retrigger_url, request_repush);
									respData.getJSONArray("retrigger").put(invNumber + " -- " + custtrxIDs2.getString(i));
								}
							}
//						}
					}
					
					
				}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public String getDataFromESAR(String gt,String lt) {
		// TODO Auto-generated method stub
		String request = "{\r\n" + 
				"    \"query\": {\r\n" + 
				"        \"bool\": {\r\n" + 
				"            \"must\": [\r\n" + 
				"                {\r\n" + 
				"                    \"term\": {\r\n" + 
				"                        \"MSG_HEADER.DESTINATION_SYSTEM\": \"VERITAS\"\r\n" + 
				"                    }\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"range\": {\r\n" + 
				"                        \"@timestamp\": {\r\n" + 
				"                            \"gt\": \""+gt+"\",\r\n" + 
				"                            \"lt\": \""+lt+"\"\r\n" + 
				"                        }\r\n" + 
				"                    }\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"must_not\": [],\r\n" + 
				"            \"should\": []\r\n" + 
				"        }\r\n" + 
				"    },\r\n" + 
				"    \"_source\": [\"MSG_HEADER.IDENTIFIER3.VALUE\",\"@timestamp\"],\r\n" + 
				"    \"from\": 0,\r\n" + 
				"    \"size\": 1,\r\n" + 
				"    \"sort\": [\r\n" + 
				"        {\"@timestamp\": \"asc\"}\r\n" + 
				"    ],\r\n" + 
				"    \"aggs\": {}\r\n" + 
				"}";
		try {
			String respARElasticSearch = restutil.sendPostRequest(PROD_ES_REST, request,true);
			System.out.println(respARElasticSearch);
			JSONObject respData = new JSONObject(respARElasticSearch);
			Object sortElem = respData.getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONArray("sort").get(0);
			System.out.println(sortElem);
			
			String custTrxID = respData.getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source")
					.getJSONObject("MSG_HEADER")
					.getJSONObject("IDENTIFIER3")
					.getString("VALUE");
			
			this.respData.getJSONArray("custtrxIDs").put(custTrxID);
			
			String nextData = getNextDataFromESAR(sortElem,gt,lt);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private String getNextDataFromESAR(Object sortElem,String gt,String lt) {
		String request = "{\r\n" + 
				"    \"query\": {\r\n" + 
				"        \"bool\": {\r\n" + 
				"            \"must\": [\r\n" + 
				"                {\r\n" + 
				"                    \"term\": {\r\n" + 
				"                        \"MSG_HEADER.DESTINATION_SYSTEM\": \"VERITAS\"\r\n" + 
				"                    }\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"range\": {\r\n" + 
				"                        \"@timestamp\": {\r\n" + 
				"                            \"gt\": \""+gt+"\",\r\n" + 
				"                            \"lt\": \""+lt+"\"\r\n" + 
				"                        }\r\n" + 
				"                    }\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"must_not\": [],\r\n" + 
				"            \"should\": []\r\n" + 
				"        }\r\n" + 
				"    },\r\n" + 
				"    \"_source\": [\"MSG_HEADER.IDENTIFIER3.VALUE\",\"@timestamp\"],\r\n" + 
				"    \"from\": 0,\r\n" + 
				"    \"size\": 5000,\r\n" + 
				"    \"sort\": [\r\n" + 
				"        {\"@timestamp\": \"asc\"}\r\n" + 
				"    ],\r\n" + 
				"    \"aggs\": {},\r\n" + 
				"    \"search_after\": ["+sortElem+"]\r\n" + 
				"}";
		String respARElasticSearch;
		try {
			respARElasticSearch = restutil.sendPostRequest(PROD_ES_REST, request,true);
		
//		System.out.println(respARElasticSearch);
		JSONObject respData = new JSONObject(respARElasticSearch);
		JSONArray hitsArray = respData.getJSONObject("hits").getJSONArray("hits");
		System.out.println("hitsArray.length() : " + hitsArray.length());
		if(hitsArray.length() > 0) {
			Object sortElem_2 = hitsArray.getJSONObject(hitsArray.length()-1).getJSONArray("sort").get(0);
			
			for(int i=0;i<hitsArray.length();i++) {
				String custTrxID = hitsArray.getJSONObject(i).getJSONObject("_source")
						.getJSONObject("MSG_HEADER")
						.getJSONObject("IDENTIFIER3")
						.getString("VALUE");
				this.respData.getJSONArray("custtrxIDs").put(custTrxID);
			}
			
			
			String nextData = getNextDataFromESAR(sortElem_2, gt,lt);
		}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
