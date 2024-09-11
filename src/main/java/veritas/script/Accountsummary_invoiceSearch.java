package veritas.script;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import common.SSLUtilities;

public class Accountsummary_invoiceSearch {

	

	public String sendPostRequestv2(String url, String request) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
//		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", "application/json");
		OutputStream os = null;
		BufferedReader in = null;
		try {
			os = con.getOutputStream();
			os.write(request.getBytes()); 
			os.flush();
			InputStream isWeb = null;
			InputStreamReader isrWeb = null;
			isWeb = con.getInputStream();
			isrWeb = new InputStreamReader(isWeb);
			in = new BufferedReader(isrWeb);
			String output;
			StringBuffer response = new StringBuffer();
			while ((output = in.readLine()) != null) {
				response.append(output);
			}
			if (con.getResponseCode() == 200) {
				System.out.println("Response Code is 200");
			} else {
				System.out.println("Response Code is not 200");
			}
			return response.toString();
		} catch (Exception ex) {
			System.out.println("Error getting response code" + "\n" + ex.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
				}
			}
			con.disconnect();
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		SSLUtilities.trustAllHostnames();
		SSLUtilities.trustAllHttpsCertificates();
		Accountsummary_invoiceSearch asis = new Accountsummary_invoiceSearch();
		
		String request_payload_1 = "{\"metadata\":{},\"request_body\":{\"org_id\":\"289\",\"bill_to_customer_id\":[],\"bill_to_customer_number\":[\"US530004546971\"],\"bill_to_site_use_id\":[],\"bill_to_site_id\":[],\"order_number\":[],\"invoice_number\":[\"\"],\"bu_code\":[\"US\"],\"inv_status\":[\"OP\"],\"page_end\":300,\"page_start\":1,\"total_count\":1,\"trx_type\":[],\"currency\":[],\"indicator_flag\":[],\"invoice_row_details\":[],\"select_all\":false,\"sort_filter_included\":false,\"sortTrxDate\":null,\"sortLate\":null,\"sortRemainingAmt\":null,\"po_number\":\"\",\"pb_status\":[\"Rejected\",\"Touched\",\"Untouched\"],\"pb_unassign_inv_flag\":false,\"analyst\":[\"ROBINSON_THOMAS\",\"ROY_D\",\"RAGHAVENDRA_RAVINDRA\",\"RUI_GAAVT\",\"RUI_GAAEZ\",\"RUI_GACNL\",\"SHIVAM_SINGH5\",\"NILOFAR_KHATOON\",\"SHAIK_SAMEENA\",\"SRINIVAS_M1\",\"LIBEN_SAROJA_C_S\",\"RAHUL_KUMAR_J_N\",\"SYED_U\",\"ROHINI_SHINDE\",\"PIYUSH_BARMAN\",\"MANJULA_MURUGESH\",\"SAI_VANDANA_SHAW\",\"AGNELO_SONU\",\"LOKESH_N_SHAH\",\"RAGINI_G1\",\"RAIS6\",\"SK_NAZ\",\"SAMUEL_SUNIL_KUMAR\",\"AMER-RPA\"],\"region\":\"AMER\",\"nota_fiscal_number\":\"\",\"source\":\"summary\"},\"userName\":\"Sasanka_Talukder\"}";
		String request_payload_2 = "{\"metadata\":{},\"request_body\":{\"org_id\":\"289\",\"bill_to_customer_id\":[],\"bill_to_customer_number\":[\"US530017657581\"],\"bill_to_site_use_id\":[],\"bill_to_site_id\":[],\"order_number\":[],\"invoice_number\":[\"\"],\"bu_code\":[\"US\"],\"inv_status\":[\"OP\"],\"page_end\":300,\"page_start\":1,\"total_count\":1,\"trx_type\":[],\"currency\":[],\"indicator_flag\":[],\"invoice_row_details\":[],\"select_all\":false,\"sort_filter_included\":false,\"sortTrxDate\":null,\"sortLate\":null,\"sortRemainingAmt\":null,\"po_number\":\"\",\"pb_status\":[\"Rejected\",\"Touched\",\"Untouched\"],\"pb_unassign_inv_flag\":false,\"analyst\":[\"ROBINSON_THOMAS\",\"ROY_D\",\"RAGHAVENDRA_RAVINDRA\",\"RUI_GAAVT\",\"RUI_GAAEZ\",\"RUI_GACNL\",\"SHIVAM_SINGH5\",\"NILOFAR_KHATOON\",\"SHAIK_SAMEENA\",\"SRINIVAS_M1\",\"LIBEN_SAROJA_C_S\",\"RAHUL_KUMAR_J_N\",\"SYED_U\",\"ROHINI_SHINDE\",\"PIYUSH_BARMAN\",\"MANJULA_MURUGESH\",\"SAI_VANDANA_SHAW\",\"AGNELO_SONU\",\"LOKESH_N_SHAH\",\"RAGINI_G1\",\"RAIS6\",\"SK_NAZ\",\"SAMUEL_SUNIL_KUMAR\",\"AMER-RPA\"],\"region\":\"AMER\",\"nota_fiscal_number\":\"\",\"source\":\"summary\"},\"userName\":\"Sasanka_Talukder\"}" ;
		
//		String first_url = "https://portalbillinguiservices-prod.g1p.pcf.dell.com/accountsummary/invoiceSearch";
		String first_url = "https://arapigateway-prod.ausmpc.pcf.dell.com/portalbillinguiservices/accountsummary/invoiceSearch";
		
		for(int i=0;i<1000;i++) {
		try {
			String request_payload = "";
			if(i%2==0) {
				request_payload = request_payload_1;
			}
			else {
				request_payload = request_payload_2;
			}
			String resp_payload = asis.sendPostRequestv2(first_url, request_payload);
			System.out.println(resp_payload);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	
	
	
}
