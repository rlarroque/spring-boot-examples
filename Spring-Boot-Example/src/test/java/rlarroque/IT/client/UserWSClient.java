package rlarroque.IT.client;

import rlarroque.model.User;

/**
 * @author Romain Larroque on 3/10/17.
 */
public class UserWSClient extends WSClient<User> {

  public UserWSClient(String endpoint, Class<User> classz) {
    super(endpoint, classz);
  }
}
