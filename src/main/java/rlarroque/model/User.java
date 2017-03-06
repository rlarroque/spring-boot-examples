package rlarroque.model;

import java.util.UUID;

/**
 * @author Romain Larroque on 3/3/17.
 */
public class User {

  private UUID id;
  private String name;

  public User() {
  }

  public User(String name) {
    this.name = name;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
