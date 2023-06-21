package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceCionsumerRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub'
		RestTemplate template =new RestTemplate();
		
		//define serevice url
		String serviceUrl="http://localhost:8080/SpringBootRestproj11-ProviderApp/actor/wish";
		
// generate http req with GEt Mode to consume the web service(API)
		ResponseEntity<String> response= template.getForEntity(serviceUrl,String.class);
		
		//display THE RECIEVED DETAILS  FROM THE RESPONCE
		System.out.println("response boy(output)"+response.getBody());
		System.out.println("response status code value "+response.getStatusCodeValue());
		System.out.println("response boy(output)"+response.getStatusCode().name());
	}

}
