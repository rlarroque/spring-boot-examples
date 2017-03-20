package rlarroque.IT.client;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

/**
 * @author Romain Larroque on 1/31/17.
 */
public abstract class WSClient<T> {

  protected final String endpoint;
  private final Class<T> classz;

  private String pathVariable;

  public WSClient(String endpoint, Class<T> classz) {
    this.endpoint = endpoint;
    this.classz = classz;
  }

  public void setPathVariable(String pathVariable) {
    this.pathVariable = pathVariable;
  }

  public void clearPathVariable() {
    this.pathVariable = "";
  }

  public T get(Map<String, ?> params, int statusCode) {
    RequestSpecification req = given()
        .contentType(ContentType.JSON);

    params.forEach((k, v) -> {
      if (v instanceof Collection<?>) {
        req.param(k, (Collection<?>) v);
      } else {
        req.param(k, v);
      }
    });

    if (statusCode == 200) {
      return mapToDto(req);
    }

    req.when()
        .get(endpoint + "/" + pathVariable)
        .then()
        .statusCode(statusCode);
    return null;
  }

  public T get() {
    return get(new HashMap<>(), 200);
  }

  public T get(Map<String, ?> params) {
    return get(params, 200);
  }

  public List<T> getAsList(Map<String, ?> params, int statusCode) {
    RequestSpecification req = given()
        .contentType(ContentType.JSON);

    params.forEach((k, v) -> {
      if (v instanceof Collection<?>) {
        req.param(k, (Collection<?>) v);
      } else {
        req.param(k, v);
      }
    });

    if (statusCode == 200) {
      return extractAsList(req.when()
          .get(endpoint + "/" + pathVariable)
          .then()
          .statusCode(statusCode)
          .extract()
          .asInputStream());
    }

    req.when()
        .get(endpoint + "/" + pathVariable)
        .then()
        .statusCode(statusCode);
    return null;
  }

  public List<T> getAsList() {
    return getAsList(new HashMap<>(), 200);
  }

  public List<T> getAsList(Map<String, ?> params) {
    return getAsList(params, 200);
  }

  private T mapToDto(RequestSpecification req) {
    return req.when()
        .get(endpoint + "/" + pathVariable)
        .then()
        .statusCode(200)
        .extract()
        .as(classz);
  }

  private List<T> extractAsList(InputStream is) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      JavaType type = mapper.getTypeFactory().constructParametrizedType(List.class, List.class, classz);
      return mapper.readValue(is, type);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

}
