package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
/**
 * http://www.springboottutorial.com/spring-boot-profiles
 * @author isuru
 *
 */
@Configuration
public class AppConfiguration {

	@Profile("dev")
	@Bean
	public String devBean() {
		return "dev";
	}

	@Profile("qa")
	@Bean
	public String qaBean() {
		return "qa";
	}

	@Profile("prod")
	@Bean
	public String prodBean() {
		return "prod";
	} 
}
