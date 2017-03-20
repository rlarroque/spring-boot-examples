package rlarroque.dao;

import org.springframework.stereotype.Repository;
import rlarroque.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author Romain Larroque on 3/3/17.
 */
@Repository
public class UserDao {

  /**
   * Creates a user.
   *
   * @param user the user to create
   * @return the user id generated
   */
  public UUID create(User user) {
    return UUID.randomUUID();
  }

  /**
   * Retrieves a user based on its id.
   *
   * @param id the id
   * @return the user retrieved
   */
  public User get(UUID id) {
    return new User(id, "Some name");
  }

  /**
   * Retrieves all users available.
   *
   * @return the list of users retrieved
   */
  public List<User> getAll() {
    return Arrays.asList(new User(UUID.randomUUID(), "User 1"), new User(UUID.randomUUID(), "User 2"));
  }
}
