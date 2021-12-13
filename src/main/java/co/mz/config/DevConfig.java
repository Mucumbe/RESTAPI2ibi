package co.mz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.expression.ParseException;

@Configuration
@Profile("dev")
public class DevConfig {

	@Bean
	public boolean instantiateDataBase() throws ParseException{
		return true;
	}
}
