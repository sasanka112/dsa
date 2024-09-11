package veritas.script;

//import org.apache.http.client.methods.HttpPut;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class ServiceNowTaskUpdater {

    public static void main(String[] args) {
        String instance = "your_instance";
        String taskTable = "change_task";
        String sysId = "your_task_sys_id";
        String username = "your_username";
        String password = "your_password";
        String openStateValue = "your_open_state_value";

        String url = "https://" + instance + ".service-now.com/api/now/table/" + taskTable + "/" + sysId;
//
//        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            HttpPut request = new HttpPut(url);
//            request.setHeader("Content-Type", "application/json");
//            request.setHeader("Accept", "application/json");
//            String auth = username + ":" + password;
//            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
//            request.setHeader("Authorization", "Basic " + encodedAuth);
//
//            JSONObject json = new JSONObject();
//            json.put("state", openStateValue);
//
//            StringEntity entity = new StringEntity(json.toString());
//            request.setEntity(entity);
//
//            HttpResponse response = httpClient.execute(request);
//            String responseString = EntityUtils.toString(response.getEntity());
//
//            if (response.getStatusLine().getStatusCode() == 200) {
//                System.out.println("Task re-opened successfully");
//            } else {
//                System.out.println("Failed to re-open task: " + response.getStatusLine().getStatusCode());
//                System.out.println(responseString);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
