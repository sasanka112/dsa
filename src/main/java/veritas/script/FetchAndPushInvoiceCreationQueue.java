package veritas.script;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONArray;
import org.json.JSONObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.GetResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class FetchAndPushInvoiceCreationQueue {

	private static final String JKS_PASSCODE = "123456";
	private static final String filePath = new File(
			"C:\\Users\\Sasanka_Talukder\\OneDrive - Dell Technologies\\Documents\\GitHub\\dsa\\src\\main\\resources\\cert_02.jks")
			.getAbsolutePath();

	private static String RabbitMQ_username = "americas\\svc_prdvercce100";
	private static String RabbitMQ_password = "N~isxL5*Qt?Yu0dM97wVZPGA";
	private static String RabbitMQ_vHost = "VERITAS_PROD";
	private static String RabbitMQ_host = "paas-rmq-som18.us.dell.com";
	private static String RabbitMQ_port = "8071";
	private static JSONArray bq_data_array = new JSONArray();
	private static String invoice_create = "INVOICE_CREATE_AR_VERITAS_Q";
	private static String order_create = "ORDER_DETAILS_VERITAS_Q";

	public static void main(String[] args) {
		System.out.println("started");
		try {
			String queue_name = invoice_create;
//			retieveMsgMQ(false,bq_data_array);
			retieveMsgMQ(queue_name + "_BO",true);
//			retieveMsgMQ(true, bq_data_array, "PO_CREATE_VERITAS_Q_BO", 5);
			publishMsgMQ(queue_name, bq_data_array);
		} catch (Exception e) {
			System.out.println("execption for : " + bq_data_array);
		}
		System.out.println("ended" + bq_data_array);
		System.out.println("ended" + bq_data_array.length());

	}

	public static void publishMsgMQ(String queueNameTo, JSONArray bq_data_array) throws IOException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername(RabbitMQ_username);
		factory.setPassword(RabbitMQ_password);
		factory.setVirtualHost(RabbitMQ_vHost);
		factory.setHost(RabbitMQ_host);
		factory.setPort(Integer.parseInt(RabbitMQ_port));
		try {
			SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
			KeyManager[] clientKeyManagerList = null;
			try (FileInputStream clientCertificateInputStream = new FileInputStream(new File(filePath))) {
				KeyStore clientKeStore = KeyStore.getInstance("JKS"); // Create a clean KeyStore
				clientKeStore.load(clientCertificateInputStream, JKS_PASSCODE.toCharArray()); // Load the client's
				KeyManagerFactory clientSSLKeyManagerFactory = KeyManagerFactory.getInstance("SunX509");
				clientSSLKeyManagerFactory.init(clientKeStore, JKS_PASSCODE.toCharArray());
				clientKeyManagerList = clientSSLKeyManagerFactory.getKeyManagers(); // Get list of key managers (in
			}
			TrustManager[] clientTrustManagerList = { new X509TrustManager() {
				@Override
				public void checkClientTrusted(X509Certificate[] x509Certificates, String s)
						throws CertificateException {
				}

				@Override
				public void checkServerTrusted(X509Certificate[] x509Certificates, String s)
						throws CertificateException {
				}

				@Override
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			} };
			sslContext.init(clientKeyManagerList, clientTrustManagerList, null); // Initialize SSL context with the key
			factory.useSslProtocol(sslContext);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		Connection connection = null;
		Channel channel = null;
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();
			System.out.println("publishing messages to the Q");
			for (int i = 0; i < bq_data_array.length(); i++) {
				String one_bq_data = bq_data_array.getJSONObject(i).toString();
				try {
					channel.basicPublish("", queueNameTo, null, one_bq_data.getBytes());
					System.out.println(i + " -- inserted : " + one_bq_data);
				} catch (Exception e) {
					System.out.println("execption for : " + one_bq_data);
				}
			}

		} catch (Exception e1) {
			System.out.println("Error while publishing messages to the Q");
		} finally {
			if (channel != null)
				try {
					channel.close();
				} catch (Exception e) {
				}
			if (connection != null)
				connection.close();
		}
	}

	public static void retieveMsgMQ( String queu_name, boolean autoAck)
			throws IOException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername(RabbitMQ_username);
		factory.setPassword(RabbitMQ_password);
		factory.setVirtualHost(RabbitMQ_vHost);
		factory.setHost(RabbitMQ_host);
		factory.setPort(Integer.parseInt(RabbitMQ_port));
		try {
			SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
			KeyManager[] clientKeyManagerList = null;
			try (FileInputStream clientCertificateInputStream = new FileInputStream(new File(filePath))) {
				KeyStore clientKeStore = KeyStore.getInstance("JKS"); // Create a clean KeyStore
				clientKeStore.load(clientCertificateInputStream, JKS_PASSCODE.toCharArray()); // Load the client's
				KeyManagerFactory clientSSLKeyManagerFactory = KeyManagerFactory.getInstance("SunX509");
				clientSSLKeyManagerFactory.init(clientKeStore, JKS_PASSCODE.toCharArray());
				clientKeyManagerList = clientSSLKeyManagerFactory.getKeyManagers(); // Get list of key managers (in
			}
			TrustManager[] clientTrustManagerList = { new X509TrustManager() {
				@Override
				public void checkClientTrusted(X509Certificate[] x509Certificates, String s)
						throws CertificateException {
				}

				@Override
				public void checkServerTrusted(X509Certificate[] x509Certificates, String s)
						throws CertificateException {
				}

				@Override
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			} };
			sslContext.init(clientKeyManagerList, clientTrustManagerList, null); // Initialize SSL context with the key
			factory.useSslProtocol(sslContext);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		Connection connection = null;
		Channel channel = null;
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();

			GetResponse resp = channel.basicGet(queu_name, autoAck);
			while (resp != null) {
				String message = new String(resp.getBody(), "UTF-8");
				doWork(message);
				System.out.println(" [x] ------Received '" + message + "'");
				try {
					resp = channel.basicGet(queu_name, autoAck);
				} catch (Exception e) {
					resp = null;
				}
			}
			System.out.println("---------");
			System.out.println("before publishing messages to the Q" + bq_data_array);
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("Error while publishing messages to the Q" + e1.getMessage());
		} finally {
			if (channel != null)
				try {
					channel.close();
				} catch (Exception e) {
				}
			if (connection != null)
				connection.close();
		}
	}

	private static void doWork(String message) {
		JSONObject message_obj = new JSONObject(message);
		if (message_obj.has("retryCount")) {
			message_obj.put("retryCount", (Integer.parseInt(message_obj.getString("retryCount")) + 1) + "");
		} else {
			message_obj.put("retryCount", (1) + "");
		}
		System.out.println("message_obj.getString(\"retryCount\") :" + message_obj.getString("retryCount"));
		if (Integer.parseInt(message_obj.getString("retryCount")) > 2) {
			System.out.println("Skipped this message :" + message_obj);
		} else {
			bq_data_array.put(message_obj);
		}
		
	}

}
