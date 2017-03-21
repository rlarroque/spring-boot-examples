package rlarroque.model;

import java.util.UUID;

/**
 * @author Romain Larroque on 3/3/17.
 */
public class User {

  private UUID id;
  private String name;

  /**
   * Default constructor.
   */
  public User() {
  }

  /**
   * Constructor.
   *
   * @param id   user id
   * @param name user name
   */
  public User(UUID id, String name) {
    this.id = id;
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

    /* CHECKSTYLE_OFF: JAVADOC */

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    if (!id.equals(user.id)) return false;
    return name != null ? name.equals(user.name) : user.name == null;
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
