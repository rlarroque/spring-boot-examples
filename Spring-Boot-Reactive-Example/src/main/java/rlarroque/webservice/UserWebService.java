package rlarroque.webservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import rlarroque.model.User;
import rlarroque.service.UserService;

import java.util.UUID;

/**
 * @author Romain Larroque on 3/3/17.
 */
@RestController
@RequestMapping("/user")
public class UserWebService {

  private final UserService userService;

  /**
   * Default constructor.
   *
   * @param userService default service bean to autowire.
   */
  public UserWebService(UserService userService) {
    this.userService = userService;
  }

  /**
   * Gets a user by id.
   *
   * @param id the id
   * @return the user
   */
  @GetMapping("/{id}")
  public Mono<User> get(@PathVariable("id") UUID id) {
    return userService.get(id).otherwiseIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")));
  }

  /**
   * Gets all users.
   *
   * @return all users
   */
  @GetMapping
  public Flux<User> getAll() {
    return userService.getAll();
  }

  /**
   * Creates a user.
   *
   * @param user the user to create
   * @return the validation of creation
   */
  @PostMapping
  public Mono<Void> create(@RequestBody Mono<User> user) {
    return userService.create(user);
  }
}
