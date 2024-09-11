package development;

import org.cloudfoundry.operations.DefaultCloudFoundryOperations;
import org.cloudfoundry.operations.applications.ApplicationDetail;
import org.cloudfoundry.operations.applications.ApplicationSummary;
import org.cloudfoundry.operations.applications.InstanceDetail;
import org.cloudfoundry.reactor.DefaultConnectionContext;
import org.cloudfoundry.reactor.TokenProvider;
import org.cloudfoundry.reactor.client.ReactorCloudFoundryClient;
import org.cloudfoundry.reactor.tokenprovider.PasswordGrantTokenProvider;
import org.json.JSONArray;
import org.json.JSONObject;
import org.cloudfoundry.operations.applications.GetApplicationRequest;
//import org.cloudfoundry.reactor.tokenprovider.TokenProvider;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PCFMEmoryDetailApp {

	public static void main(String[] args) {
		// Set your PCF details

		// host::username:password::org::space
		String pcfDetail = "api.svnp2.pcf.dell.com::sasanka_talukder::corival@1234::ARSelfServiceOrg::Veritas_SIT";

		//atlanta detail
		pcfDetail = "api.sa2.pcf.dell.com::sasanka_talukder::corival@1234::ARSelfServiceOrg::VERITAS";
		
		//vegas detail
//		pcfDetail = "api.sv1.pcf.dell.com::sasanka_talukder::corival@1234::ARSelfServiceOrg::VERITAS";
		
		JSONArray appsDetail =  new PCFMEmoryDetailApp().getAllApplicationDetail(pcfDetail);
		
		System.out.println(appsDetail);
		System.out.println("ended");
		}

	private JSONArray getAllApplicationDetail(String pcfDetail) {
		JSONArray appsDetail = new JSONArray();
		String pcfDetails[] = pcfDetail.split("::");

		String apiHost = pcfDetails[0];
		String username = pcfDetails[1];
		String password = pcfDetails[2];
		String organization = pcfDetails[3];
		String space = pcfDetails[4];

		// Create a connection context
		DefaultConnectionContext connectionContext = DefaultConnectionContext.builder().apiHost(apiHost).build();

		// Create a token provider
		TokenProvider tokenProvider = PasswordGrantTokenProvider.builder().password(password).username(username)
				.build();

		// Create a Cloud Foundry client
		ReactorCloudFoundryClient cloudFoundryClient = ReactorCloudFoundryClient.builder()
				.connectionContext(connectionContext).tokenProvider(tokenProvider).build();

		// Create Cloud Foundry operations
		DefaultCloudFoundryOperations cloudFoundryOperations = DefaultCloudFoundryOperations.builder()
				.cloudFoundryClient(cloudFoundryClient).organization(organization).space(space).build();

		// Get the application summaries
		Flux<ApplicationSummary> applicationSummaries = cloudFoundryOperations.applications().list();

		// Retrieve and print detailed application information
		applicationSummaries
        .flatMap(applicationSummary -> {
            Mono<ApplicationDetail> appDetailMono = cloudFoundryOperations.applications().get(GetApplicationRequest.builder()
                    .name(applicationSummary.getName())
                    .build());
            return appDetailMono.flatMapMany(applicationDetail -> {
                Flux<InstanceDetail> instanceDetailsFlux = Flux.fromIterable(applicationDetail.getInstanceDetails());
                return instanceDetailsFlux.map(instanceDetail -> new ApplicationInstanceInfo(applicationDetail, instanceDetail));
            }).defaultIfEmpty(new ApplicationInstanceInfo(applicationSummary.getName(), "STOPPED"));
        }).doOnNext(applicationInstanceInfo -> {
			if (applicationInstanceInfo.getApplicationDetail() != null) {
			ApplicationDetail applicationDetail = applicationInstanceInfo.getApplicationDetail();
//			System.out.println(" applicationDetail.getName()" +  applicationDetail.getName());
			InstanceDetail instanceDetail = applicationInstanceInfo.getInstanceDetail();
			
			JSONObject appDetail = new JSONObject();
			appDetail.put("Name", applicationDetail.getName() + "_" + instanceDetail.getIndex());
			appDetail.put("State", applicationDetail.getRequestedState());
			appDetail.put("CPU", instanceDetail.getCpu());
			appDetail.put("MemoryUsage", instanceDetail.getMemoryUsage());
			appDetail.put("MemoryQuota", instanceDetail.getMemoryQuota());
			appDetail.put("DiskUsage", instanceDetail.getDiskUsage());
			appDetail.put("DiskQuota", instanceDetail.getDiskQuota());
			appsDetail.put(appDetail);
			
//			System.out.println("Application Name: " + applicationDetail.getName());
//			System.out.println("Application State: " + applicationDetail.getRequestedState());
//			System.out.println("Instance ID: " + instanceDetail.getIndex());
//			System.out.println("CPU Usage: " + instanceDetail.getCpu());
//			System.out.println(
//					"Memory Usage: " + instanceDetail.getMemoryUsage() + " / " + instanceDetail.getMemoryQuota());
//			System.out.println("Disk Usage: " + instanceDetail.getDiskUsage() + " / " + instanceDetail.getDiskQuota());
//			System.out.println("------");
			} else {
//                System.out.println("Application Name: " + applicationInstanceInfo.getApplicationName());
//                System.out.println("Application State: " + applicationInstanceInfo.getApplicationState());
//                System.out.println("------");
                
                JSONObject appDetail = new JSONObject();
    			appDetail.put("Name", applicationInstanceInfo.getApplicationName());
    			appDetail.put("State", applicationInstanceInfo.getApplicationState());
    			appDetail.put("CPU", 0);
    			appDetail.put("MemoryUsage", 0);
    			appDetail.put("MemoryQuota", 100);
    			appDetail.put("DiskUsage", 0);
    			appDetail.put("DiskQuota", 100);
    			appsDetail.put(appDetail);
            }
			
		}).blockLast(); // Block to wait for the Flux to complete (not recommended for production code)
	
		return appsDetail;
	}


    private static class ApplicationInstanceInfo {
        private final ApplicationDetail applicationDetail;
        private final InstanceDetail instanceDetail;
        private final String applicationName;
        private final String applicationState;

        public ApplicationInstanceInfo(ApplicationDetail applicationDetail, InstanceDetail instanceDetail) {
            this.applicationDetail = applicationDetail;
            this.instanceDetail = instanceDetail;
            this.applicationName = null;
            this.applicationState = null;
        }

        public ApplicationInstanceInfo(String applicationName, String applicationState) {
            this.applicationDetail = null;
            this.instanceDetail = null;
            this.applicationName = applicationName;
            this.applicationState = applicationState;
        }

        public ApplicationDetail getApplicationDetail() {
            return applicationDetail;
        }

        public InstanceDetail getInstanceDetail() {
            return instanceDetail;
        }

        public String getApplicationName() {
            return applicationName;
        }

        public String getApplicationState() {
            return applicationState;
        }
    }
}
