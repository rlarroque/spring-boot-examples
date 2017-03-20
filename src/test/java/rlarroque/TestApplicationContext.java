package rlarroque;

import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * @author Louis Amoros on 07/02/17.
 */
@Import(ApplicationConfig.class)
public class TestApplicationContext extends SpringBootServletInitializer {

}