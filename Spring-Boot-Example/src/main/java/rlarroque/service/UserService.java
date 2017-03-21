package rlarroque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rlarroque.dao.UserDao;
import rlarroque.model.User;

import java.util.List;
import java.util.UUID;

/**
 * @author Romain Larroque on 3/3/17.
 */
@Service
public class UserService {

  @Autowired
  private UserDao userDao;

  /**
   * Creates a user.
   *
   * @param user the user to create
   * @return the user id
   */
  public UUID create(User user) {
    return userDao.create(user);
  }

  /**
   * Retrieves a user based on its id.
   *
   * @param id the id
   * @return the user retrieved
   */
  public User get(UUID id) {
    return userDao.get(id);
  }

  /**
   * Retrieves all users available.
   *
   * @return the list of users retrieved
   */
  public List<User> getAll() {
    return userDao.getAll();
  }
}
