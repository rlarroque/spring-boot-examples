package rlarroque.dao;

import org.springframework.stereotype.Repository;
import rlarroque.model.User;

import java.util.UUID;

/**
 * @author Romain Larroque on 3/3/17.
 */
@Repository
public class UserDao {

  public UUID create(User user) {
    return UUID.randomUUID();
  }

  public User get (UUID id) {
    return new User("Some name");
  }
}
