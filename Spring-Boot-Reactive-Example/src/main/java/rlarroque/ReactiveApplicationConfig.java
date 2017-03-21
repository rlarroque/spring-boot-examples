package rlarroque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author Romain Larroque on 3/2/17.
 */
@SpringBootApplication
public class ReactiveApplicationConfig {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReactiveApplicationConfig.class);

  /**
   * Constructor.
   */
  public ReactiveApplicationConfig() {
    LOGGER.trace("Configuration: Spring boot starter");
  }

  /**
   * @param args for main program
   */
  public static void main(String[] args) {
    new SpringApplicationBuilder(ReactiveApplicationConfig.class)
        .profiles("app")
        .run(args);
  }
}
