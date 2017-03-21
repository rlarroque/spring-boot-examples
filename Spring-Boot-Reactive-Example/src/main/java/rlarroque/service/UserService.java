package rlarroque.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import rlarroque.dao.UserDao;
import rlarroque.model.User;

import java.util.UUID;

/**
 * @author Romain Larroque on 3/3/17.
 */
@Service
public class UserService {

  private final UserDao userDao;

  /**
   * Default constructor.
   *
   * @param userDao default repository to autowire
   */
  public UserService(UserDao userDao) {
    this.userDao = userDao;
  }

  /**
   * Retrieves a user based on its id.
   *
   * @param id the id
   * @return the user retrieved
   */
  public Mono<User> get(UUID id) {
    return userDao.findOne(id);
  }

  /**
   * Retrieves all users available.
   *
   * @return the list of users retrieved
   */
  public Flux<User> getAll() {
    return userDao.findAll();
  }

  /**
   * Creates a new user.
   *
   * @param user the user to create
   * @return a mono void
   */
  public Mono<Void> create(Mono<User> user) {
    return userDao.save(user).then();
  }
}
