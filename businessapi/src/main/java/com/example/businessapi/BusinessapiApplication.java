package com.example.businessapi;
import org.springframework.beans.factory.annotation.Value;
import com.example.businessapi.EchoBodyParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;


@SpringBootApplication
@RestController
public class BusinessapiApplication {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${operations.restURL}")
	String serviceURL;
	
	
	@RequestMapping("/hello")
	  public String home() {
	    return "Hello World!";
	  }
	

	@RequestMapping(value = "/echo-echo/", method = RequestMethod.POST, produces = "application/json")
	  public String echo(@RequestBody EchoBodyParent echoRequest) {		
		System.out.println(serviceURL);
		ResponseEntity<String> response = restTemplate.postForEntity(serviceURL, echoRequest,
				String.class);
		return response.getBody();
	}

	
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
		
	}

	public static void main(String[] args) {
		SpringApplication.run(BusinessapiApplication.class, args);
	}

}
