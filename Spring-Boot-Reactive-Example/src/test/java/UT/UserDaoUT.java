package UT;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import rlarroque.dao.UserDao;

/**
 * @author Romain Larroque on 3/21/17.
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class UserDaoUT {

  @Autowired
  private UserDao userDao;

  @Test
  public void findByFirstName() {
    // TODO
  }
}
