package rlarroque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Romain Larroque on 3/2/17.
 */
@SpringBootApplication
public class ApplicationConfig {

  private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);

  /**
   * Constructor.
   */
  public ApplicationConfig() {
    LOGGER.trace("Configuration: Spring boot starter");
  }

  /**
   * @param args for main program
   */
  public static void main(String[] args) {
    SpringApplication.run(ApplicationConfig.class, args);
  }
}
