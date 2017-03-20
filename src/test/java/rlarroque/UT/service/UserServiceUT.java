package rlarroque.UT.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import rlarroque.UT.helper.UTHelper;
import rlarroque.dao.UserDao;
import rlarroque.model.User;
import rlarroque.service.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;

/**
 * @author Romain Larroque on 3/16/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceUT {

  @InjectMocks
  private UserService userService;

  @Mock
  private UserDao userDao;

  @Before
  public void init() throws Exception {
    when(userDao.getAll()).thenReturn(Arrays.asList(UTHelper.USER1, UTHelper.USER2));
    when(userDao.get(Mockito.any())).thenReturn(null);
    when(userDao.get(Mockito.eq(UTHelper.ID1))).thenReturn(UTHelper.USER1);
    when(userDao.get(Mockito.eq(UTHelper.ID2))).thenReturn(UTHelper.USER2);
  }

  @Test
  public void testGetAllUsers() {
    List<User> users = userService.getAll();
    Assert.assertNotNull("Should not be null", users);
    Assert.assertTrue("Should contain 2 items", users.size() == 2);
  }

  @Test
  public void testGetUser1() {
    User user = userService.get(UTHelper.ID1);
    Assert.assertNotNull("Should not be null", user);
    Assert.assertEquals("Should be equal", UTHelper.USER1, user);
  }

  @Test
  public void testGetUnknownUser() {
    User user = userService.get(UUID.randomUUID());
    Assert.assertNull("Should be null", user);
  }
}
