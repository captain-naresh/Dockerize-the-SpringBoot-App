package com.example.dummyinvokedapi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.dummyinvokedapi.EchoBody;



@SpringBootApplication
@RestController
public class DummyinvokedapiApplication {	
	public static final Logger logger = LoggerFactory.getLogger(DummyinvokedapiApplication.class);	
	@RequestMapping("/hello")
	  public String home() {
	    return "Hello From dummyinvokedapi!";
	  }
	
	@RequestMapping(value = "/fullname/{förname}/{eftername}", method = RequestMethod.GET)
	  public String getnames(@PathVariable("förname") String fname,@PathVariable("eftername") String sname) {
		String result = fname.concat(" ").concat(sname);
		logger.info("Fetching names are {}", result);
		return result;
	  }
	

	@RequestMapping(value = "/echo-echo/", method = RequestMethod.POST)
	  public ResponseEntity<?> Echo(@RequestBody EchoBody req) {
        logger.info("Creating User : {}", req);
        return new ResponseEntity<EchoBody>(req, HttpStatus.OK);
    }


	public static void main(String[] args) {
		SpringApplication.run(DummyinvokedapiApplication.class, args);
	}

}
