package bookingAPI.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * Configuration
 */
@Configuration
@EnableWebMvc
@ComponentScan("bookingAPI")
public class BookingConfig {

}
