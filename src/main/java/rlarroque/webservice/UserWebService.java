package rlarroque.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import rlarroque.model.User;
import rlarroque.service.UserService;

import java.util.UUID;

/**
 * @author Romain Larroque on 3/3/17.
 */
@RestController
@RequestMapping("/user")
public class UserWebService {


  @Autowired
  private UserService userService;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<User> get(@RequestParam("id") UUID id) {
    return ResponseEntity.ok(userService.get(id));
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<UUID> create(@RequestBody User user) {
    return ResponseEntity.ok(userService.create(user));
  }
}
