package rlarroque;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import reactor.core.publisher.Mono;
import rlarroque.dao.UserDao;
import rlarroque.model.User;

import java.util.UUID;

/**
 * @author Romain Larroque on 3/21/17.
 */
@Configuration
@Profile("app")
public class MongoDbConfig {

  @Bean
  ApplicationRunner databaseInitialization(UserDao userDao) {
    return a -> userDao.count()
        .then(n -> n == 0 ? userDao.save(new User(UUID.randomUUID(), "Rlarroque")) : Mono.empty())
        .block();
  }

}