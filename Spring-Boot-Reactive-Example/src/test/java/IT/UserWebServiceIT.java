package IT;

import helper.UTHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import rlarroque.dao.UserDao;
import rlarroque.model.User;
import rlarroque.webservice.UserWebService;

import static org.mockito.BDDMockito.given;

/**
 * @author Romain Larroque on 3/21/17.
 */
@RunWith(SpringRunner.class)
@WebFluxTest(UserWebService.class)
@SpringBootConfiguration
public class UserWebServiceIT {

  @Autowired
  private WebTestClient webClient;

  @MockBean
  private UserDao userDao;

  @Test
  public void findById() {
    User expected = UTHelper.USER1;
    given(userDao.findOne(UTHelper.ID1)).willReturn(Mono.just(expected));
    // FIXME: Not finding content correctly
    this.webClient.get().uri("/user/{id}", UTHelper.ID1.toString())
        .exchange()
        .expectStatus().isOk()
        .expectBody(User.class).value().isEqualTo(expected);
  }

}
