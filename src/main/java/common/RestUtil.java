
package common;

/**
 * @author Sasanka_Talukder
 * st: 2.09.2021
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;


import org.json.JSONObject;


public final class RestUtil {
	private static String LOG_API = "https://veritaslogmanagerdev.ausvdc02.pcf.dell.com/api/service/log/add";
	private static String INV_STATUS_API = "";

	private final static String USER_AGENT = "Mozilla/5.0";
	final private static String Component = "EnrichmentService";
	private static String Environment = "DEV";
	final public static String ERROR = "error";
	final public static String INFO = "info";
	public static String VERITAS_INTERNAL_AUTH_KEY = "E2503983-8A6F-4680-997E-88752B8FF3CA";
	
	/*
	 * addLog - ST:- 24.04.2020 this is to call logging api
	 * 
	 * @param loglevel - type of the log -- log/error
	 * 
	 * @param message - message to log -- ""
	 * 
	 * @param metadata - additional information --
	 * "ponumber:3545345,dpid:245452524,invoiceNumber:fdfdf"
	 */
	public void addLog(String loglevel, String message, String metadata) {
		try {
			JSONObject logObject = new JSONObject();
			if (loglevel.toLowerCase().contentEquals("error")) {
				logObject.put("type", "error");
			} else {
				logObject.put("type", "log");
			}
			StackTraceElement[] getStackTraceList = Thread.currentThread().getStackTrace();
			if (getStackTraceList.length > 3) {
				logObject.put("CallingMethod",
						getStackTraceList[3].getClassName() + "." + getStackTraceList[3].getMethodName());
				logObject.put("CallingObject",
						getStackTraceList[2].getClassName() + "." + getStackTraceList[2].getMethodName());
			} else {
				logObject.put("CallingMethod", "");
				logObject.put("CallingObject", "");
			}
			logObject.put("DateTimeStamp", getCurrentDateTime());
			logObject.put("LogLevel", loglevel);
			logObject.put("Message", message);
			logObject.put("Component", Component);
			logObject.put("Environment", Environment);
			if (metadata.length() > 2) {
				String splittedMetdata[] = metadata.split(",");
				for (String one_m_data : splittedMetdata) {
					String splittedOneMetdata[] = one_m_data.split(":");
					if (splittedOneMetdata[0].trim().length() > 1) {
						logObject.put(splittedOneMetdata[0].trim().toUpperCase(), splittedOneMetdata[1].trim());
					}
				}
			}
			System.out.println("message ~~ " + message);
//			sendPostRequest(LOG_API, logObject.toString());
		} catch (Exception e) {
			System.out.println("addLog -- Error adding log");
		}
	}

	public String sendPostRequest(String url, String request) throws Exception {
		url = url.replaceAll(" ", "%20");
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("VeritasInternalAuthKey", VERITAS_INTERNAL_AUTH_KEY);
		con.setRequestProperty("Authorization", VERITAS_INTERNAL_AUTH_KEY);
		con.setRequestProperty("SubscriberId", VERITAS_INTERNAL_AUTH_KEY);
		con.setRequestProperty("AuthToken", VERITAS_INTERNAL_AUTH_KEY);
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
			System.out.println("sendPostRequest -- Response Code: " + con.getResponseCode());
			return response.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("sendPostRequest -- Error getting response code");
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
	
	
	public String sendPostRequestXML(String url, String request) throws Exception {
		url = url.replaceAll(" ", "%20");
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", "text/xml");
		System.out.println("VERITAS_INTERNAL_AUTH_KEY : " + VERITAS_INTERNAL_AUTH_KEY);
		con.setRequestProperty("VeritasInternalAuthKey", VERITAS_INTERNAL_AUTH_KEY);
		con.setRequestProperty("Authorization", VERITAS_INTERNAL_AUTH_KEY);
		con.setRequestProperty("SubscriberId", VERITAS_INTERNAL_AUTH_KEY);
		con.setRequestProperty("AuthToken", VERITAS_INTERNAL_AUTH_KEY);
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
			System.out.println("sendPostRequest -- Response Code: " + con.getResponseCode());
			return response.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("sendPostRequest -- Error getting response code");
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
	
	public String sendPutRequest(String url, String request) throws Exception {
		url = url.replaceAll(" ", "%20");
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("PUT");
		con.setDoOutput(true);
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("VeritasInternalAuthKey", VERITAS_INTERNAL_AUTH_KEY);
		con.setRequestProperty("Authorization", VERITAS_INTERNAL_AUTH_KEY);
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
			System.out.println("sendPostRequest -- Response Code: " + con.getResponseCode());
			return response.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("sendPostRequest -- Error getting response code");
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

	private String getCurrentDateTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = sdf.format(date);
		return strDate;
	}
	
	
	public String sendGetRequest(String url) throws Exception {
		url = url.replaceAll(" ", "%20");
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		BufferedReader in = null;

		try {
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("VeritasInternalAuthKey", VERITAS_INTERNAL_AUTH_KEY);
//			con.setRequestProperty("Authorization", VERITAS_INTERNAL_AUTH_KEY);
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			int responseCode = con.getResponseCode();
//			new RestUtil().addLog(RestUtil.INFO, "Sending 'GET' request to: " + url , "");
//			new RestUtil().addLog(RestUtil.INFO, "Response Code : " + responseCode , "");
			
//			System.out.println("Sending 'GET' request to: " + url + ", Response Code : " + responseCode );
			
			new RestUtil().addLog(RestUtil.INFO, "Sending 'GET' request to: " + url , "");
//			new RestUtil().addLog(RestUtil.INFO, "Response Code : " + responseCode , "");
			if (responseCode == 200) {
				return response.toString();
			} else {
				return "Some Exception";
			}
		} catch (Exception e) {
			e.printStackTrace();
			new RestUtil().addLog(RestUtil.ERROR, "Error Exception"  + "\n" + e.getMessage(), "");
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
	
	public String updateInvoiceStatus(String invNum, String invStatus, String invReasonCode) {
		try {
			JSONObject logObject = new JSONObject();
			logObject.put("invoiceNumber", invNum);
			logObject.put("status", invStatus);
			logObject.put("invoiceReasonCode", invReasonCode);
			return sendPostRequest(INV_STATUS_API,
					logObject.toString());
		} catch (Exception e) {
			System.out.println("updateInvoiceStatus -- Error adding ");
		}
		return null;
	}
	

	public String sendPostRequest(String url, String request, boolean basicAuth) throws Exception {
		url = url.replaceAll(" ", "%20");
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("VeritasInternalAuthKey", VERITAS_INTERNAL_AUTH_KEY);
		con.setRequestProperty("Authorization", VERITAS_INTERNAL_AUTH_KEY);
		if(basicAuth) {
			String encoded = Base64.getEncoder().encodeToString(("xxread"+":"+"xxread").getBytes(StandardCharsets.UTF_8));  //Java 8
			con.setRequestProperty("Authorization", "Basic "+encoded);
		}
		else {
			con.setRequestProperty("SubscriberId", VERITAS_INTERNAL_AUTH_KEY);
			con.setRequestProperty("AuthToken", VERITAS_INTERNAL_AUTH_KEY);
		}
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
//			System.out.println("sendPostRequest -- Response Code: " + con.getResponseCode());
			return response.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("sendPostRequest -- Error getting response code");
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
	
	

	public String sendPostRequest(String url, String request, boolean basicAuth, String username, String password) throws Exception {
		url = url.replaceAll(" ", "%20");
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("VeritasInternalAuthKey", VERITAS_INTERNAL_AUTH_KEY);
		con.setRequestProperty("Authorization", VERITAS_INTERNAL_AUTH_KEY);
		if(basicAuth) {
			String encoded = Base64.getEncoder().encodeToString((username +":"+ password).getBytes(StandardCharsets.UTF_8));  //Java 8
			con.setRequestProperty("Authorization", "Basic "+encoded);
		}
		else {
			con.setRequestProperty("SubscriberId", VERITAS_INTERNAL_AUTH_KEY);
			con.setRequestProperty("AuthToken", VERITAS_INTERNAL_AUTH_KEY);
		}
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
//			System.out.println("sendPostRequest -- Response Code: " + con.getResponseCode());
			return response.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("sendPostRequest -- Error getting response code");
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
	
	
	public String sendPostRequestMetadata(String url, String request) throws Exception {
		url = url.replaceAll(" ", "%20");
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("VeritasInternalAuthKey", VERITAS_INTERNAL_AUTH_KEY);
		con.setRequestProperty("Authorization", VERITAS_INTERNAL_AUTH_KEY);
		con.setRequestProperty("SubscriberId", VERITAS_INTERNAL_AUTH_KEY);
		con.setRequestProperty("AuthToken", VERITAS_INTERNAL_AUTH_KEY);
		con.setRequestProperty("metadata", "eyJlbWFpbF9hZGRyZXNzIjoiU2FzYW5rYV9UYWx1a2RlckBEZWxsLmNvbSIsImFkX3VzZXJuYW1lIjoiU2FzYW5rYV9UYWx1a2RlciIsImZlZF9ub25fZmVkIjoiZmVkX3VzZXIifQ==");
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
			System.out.println("sendPostRequest -- Response Code: " + con.getResponseCode());
			return response.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("sendPostRequest -- Error getting response code");
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
	
	


}
