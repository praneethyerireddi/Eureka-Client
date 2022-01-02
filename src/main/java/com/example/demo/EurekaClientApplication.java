package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication {
	
//	@Autowired
//	private EurekaClient client;
	
//	private RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
	
//	@GetMapping("/ClientGreeting")
//	public String getClientMessage() {
//		
//		InstanceInfo instance = client.getNextServerFromEureka("eureka-service-instance", false);
//		
//		
//		ResponseEntity<String> responseEntity = 
//				restTemplate.getForEntity(instance.getHomePageUrl()+ "/greeting", String.class);
//		
//		
//		return "Client Message " + responseEntity.getBody();
//
//	}
	
	@GetMapping("/ClientGreeting")
	public String getClientMessage() {
		
		
		
		ResponseEntity<String> responseEntity = 
				restTemplate().getForEntity("http://eureka-service-instance/greeting", String.class);
		
		
		return "Client Message " + responseEntity.getBody();

	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
