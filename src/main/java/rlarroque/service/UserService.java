package rlarroque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rlarroque.dao.UserDao;
import rlarroque.model.User;

import java.util.UUID;

/**
 * @author Romain Larroque on 3/3/17.
 */
@Service
public class UserService {

  @Autowired
  private UserDao userDao;

  public UUID create(User user) {
    return userDao.create(user);
  }

  public User get(UUID id) {
   return userDao.get(id);
  }
}
