package veritas.script;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;

import common.SSLUtilities;

public class MongoServiceTest {
	
	

	public static String sendingGetRequest(String url) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		BufferedReader in = null;
		try {
			con.setRequestMethod("POST");
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			int responseCode = con.getResponseCode();
			System.out.println("Sending 'GET' request to: " + url);
			System.out.println("Response Code : " + responseCode);
			if (responseCode == 200) {
				return response.toString();
			} else {
				return "Some Exception";
			}
		} catch (FileNotFoundException fnfe) { 
			return "Some Exception";
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Exception" + "\n" + e.getMessage());
			return "Some Exception";
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception ex) {
				}
			}
			con.disconnect();
		}
	}

	public static void main(String[] args) {
		SSLUtilities.trustAllHostnames();
		SSLUtilities.trustAllHttpsCertificates();
		
		String ponumsasrr = "[\"10-21570-D\",\r\n"
				+ "\"67-00647-D\",\r\n"
				+ "\"14-30979-D\",\r\n"
				+ "\"70-TQ128-D\",\r\n"
				+ "\"67-01101-D\",\r\n"
				+ "\"10-DZ361-D\",\r\n"
				+ "\"89-00997-D\",\r\n"
				+ "\"10-01105-D\",\r\n"
				+ "\"41-42224-D\",\r\n"
				+ "\"20-QZZ33-D\",\r\n"
				+ "\"10-DZ076-D\",\r\n"
				+ "\"89-CUW01-D\",\r\n"
				+ "\"89-24305-D\",\r\n"
				+ "\"89-01019-D\",\r\n"
				+ "\"89-01060-D\",\r\n"
				+ "\"10-22501-D\",\r\n"
				+ "\"89-CUW35-D\",\r\n"
				+ "\"89-CUW34-D\",\r\n"
				+ "\"89-01251-D\",\r\n"
				+ "\"20-41541-D\",\r\n"
				+ "\"89-01303-D\",\r\n"
				+ "\"89-59995-D\",\r\n"
				+ "\"70-TPZ51-D\",\r\n"
				+ "\"89-CUR37-D\",\r\n"
				+ "\"20-22262-D\",\r\n"
				+ "\"10-22066-D\",\r\n"
				+ "\"10-22557-D\",\r\n"
				+ "\"60-HV199-D\"]";
		JSONArray ponumar = new JSONArray(ponumsasrr);
		
		final String endPoint = "https://veritasoracleservices.veritas.pcf.dell.com/fed-veritas/po/deactivate?poNumber=";
		

		for(int i=0;i<ponumar.length();i++) {
			try {
				MongoServiceTest.sendingGetRequest(endPoint + ponumar.getString(i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
