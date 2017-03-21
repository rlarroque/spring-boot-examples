package rlarroque.UT.helper;

import rlarroque.model.User;

import java.util.UUID;

/**
 * @author Romain Larroque on 3/20/17.
 */
public class UTHelper {

  public static final UUID ID1 = UUID.fromString("04e5a104-dbe8-4e4b-8abd-09244e1220c9");
  public static final UUID ID2 = UUID.fromString("eba363e1-584b-4259-9d71-b885c657eb29");

  public static final User USER1 = new User(ID1, "User 1");
  public static final User USER2 = new User(ID2, "User 2");
}
