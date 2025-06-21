package pfe.emsi.covoiturage.voyage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class VoyageApplication {

    public static void main(String[] args) throws Exception {
        
        SpringApplication.run(VoyageApplication.class, args);
    }

}
