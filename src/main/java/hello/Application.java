package hello;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 8080:8080 -t springio/gs-spring-boot-docker
 * @author isuru
 *
 */
@SpringBootApplication
@RestController
public class Application {
	
	 @Autowired
	    private BasicConfiguration configuration;

//http://www.springboottutorial.com/spring-boot-profiles
//https://spring.io/guides/gs/spring-boot-docker/
	@RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }
    
    @Value("${welcome.message}")
	private String welcomeMessage;

    @GetMapping("/welcome")
	public String retrieveWelcomeMessage() {
		// Complex Method
		return welcomeMessage;
	}
   
    @RequestMapping("/dynamic-configuration")
    public Map dynamicConfiguration() {
        // Not the best practice to use a map to store differnt types!
        Map map = new HashMap();
        map.put("message", configuration.getMessage());
        map.put("number", configuration.getNumber());
        map.put("key", configuration.isValue());
        return map;
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
