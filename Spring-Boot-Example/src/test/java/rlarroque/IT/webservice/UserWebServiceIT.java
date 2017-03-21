package rlarroque.IT.webservice;

import com.jayway.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import rlarroque.IT.client.UserWSClient;
import rlarroque.TestApplicationContext;
import rlarroque.model.User;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author Romain Larroque on 3/10/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {TestApplicationContext.class})
public class UserWebServiceIT {

  private static final String ENDPOINT = "/user";
  private static final Class<User> CLASSZ = User.class;

  @Value("${local.server.port}")
  private int port;

  private UserWSClient userWSClient = new UserWSClient(ENDPOINT, CLASSZ);

  /**
   * Setup.
   */
  @Before
  public void setUp() throws IOException {
    RestAssured.port = port;
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    userWSClient.clearPathVariable();
  }

  @Test
  public void testGetUser() {
    User expected = new User(UUID.randomUUID(), "Some name");
    userWSClient.setPathVariable(expected.getId().toString());
    User user = userWSClient.get();

    Assert.assertNotNull("Should not be null", user);
    Assert.assertEquals("Should be the same as expected user",expected, user);
  }

  @Test
  public void testGetAllUsers() {
    List<User> users = userWSClient.getAsList();

    Assert.assertNotNull("Should not be null", users);
    Assert.assertTrue("Should contain two users", users.size() == 2);
  }
}
