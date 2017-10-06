package neues_leben.codewasher;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({ "neues_leben.codewasher.services", "neues_leben.codewasher.controllers" })
@EnableWebMvc
public class CWDispatcherConfig {

}
