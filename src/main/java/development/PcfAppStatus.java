package development;

import org.cloudfoundry.client.v3.applications.Application;
import org.cloudfoundry.client.v3.applications.ApplicationState;
import org.cloudfoundry.client.v3.applications.GetApplicationRequest;
import org.cloudfoundry.client.v3.applications.GetApplicationResponse;
import org.cloudfoundry.operations.DefaultCloudFoundryOperations;
import org.cloudfoundry.operations.applications.ApplicationSummary;
import org.cloudfoundry.operations.applications.Applications;
import org.cloudfoundry.operations.DefaultCloudFoundryOperations;
import org.cloudfoundry.reactor.DefaultConnectionContext;
import org.cloudfoundry.reactor.TokenProvider;
import org.cloudfoundry.reactor.client.ReactorCloudFoundryClient;
import org.cloudfoundry.reactor.tokenprovider.PasswordGrantTokenProvider;
//import org.cloudfoundry.reactor.tokenprovider.TokenProvider;
import org.cloudfoundry.uaa.tokens.Tokens;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PcfAppStatus {

    public static void main(String[] args) {
        // Set your PCF details
        String apiHost = "api.svnp2.pcf.dell.com";
        String username = "sasanka_talukder";
        String password = "corival@1234";
        String organization = "ARSelfServiceOrg";
        String space = "Veritas_SIT";
        String appName = "venrichsit";

        // Create a connection context
        DefaultConnectionContext connectionContext = DefaultConnectionContext.builder()
                .apiHost(apiHost)
                .build();

        // Create a token provider
        TokenProvider tokenProvider = PasswordGrantTokenProvider.builder()
                .password(password)
                .username(username)
                .build();

        // Create a Cloud Foundry client
        ReactorCloudFoundryClient cloudFoundryClient = ReactorCloudFoundryClient.builder()
                .connectionContext(connectionContext)
                .tokenProvider(tokenProvider)
                .build();

        // Create Cloud Foundry operations
        DefaultCloudFoundryOperations cloudFoundryOperations = DefaultCloudFoundryOperations.builder()
                .cloudFoundryClient(cloudFoundryClient)
                .organization(organization)
                .space(space)
                .build();

        Applications applications = cloudFoundryOperations.applications();
        System.out.println(applications);
        System.out.println(applications.list());
        System.out.println(applications.list());
        
//        // Get the application summary
//        Mono<ApplicationSummary> applicationSummaryMono = cloudFoundryOperations.applications()
//                .list()
//                .filter(application -> application.getName().equals(appName))
//                .single();
//
//        System.out.println(applicationSummaryMono);
//        // Retrieve and print the application state
//        applicationSummaryMono.subscribe(applicationSummary -> {
//            System.out.println("Application Name: " + applicationSummary.getName());
//            System.out.println("Application State: " + applicationSummary.getRequestedState());
//        }, error -> {
//            error.printStackTrace();
//        });
//
//        // Wait for the Mono to complete
//        applicationSummaryMono.block();
        
        
        
     // Get the application summaries
        Flux<ApplicationSummary> applicationSummaries = cloudFoundryOperations.applications().list();

        // Retrieve and print the application state for each application
        applicationSummaries.subscribe(applicationSummary -> {
            System.out.println("Application Name: " + applicationSummary.getName());
            System.out.println("Application State: " + applicationSummary.getRequestedState());
            System.out.println("------");
        }, error -> {
            error.printStackTrace();
        });

        // Block to wait for the Flux to complete (not recommended for production code)
        applicationSummaries.blockLast();
    }
}
