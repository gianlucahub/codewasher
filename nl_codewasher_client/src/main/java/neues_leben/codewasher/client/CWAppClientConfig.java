package neues_leben.codewasher.client;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ neues_leben.codewasher.CWAppConfig.class })
// @ImportResource({ "classpath:/nl_codewasher_context.xml"})
public class CWAppClientConfig {

}
