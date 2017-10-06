package neues_leben.codewasher;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "neues_leben.codewasher.jdbc")
@ImportResource("classpath:nl_codewasher_context.xml")
public class CWAppConfig {
}
