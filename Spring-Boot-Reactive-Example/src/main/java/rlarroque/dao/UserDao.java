package rlarroque.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import rlarroque.model.User;

import java.util.UUID;

/**
 * @author Romain Larroque on 3/3/17.
 */
public interface UserDao extends ReactiveCrudRepository<User, UUID> {

}
