package edu.lemon.demointernetstore.view.web.controller;

import edu.lemon.demointernetstore.view.web.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/internet-store")
public class RestApiController {

  @GetMapping({"/", "/{name}"})
  public String greet(
      @PathVariable(name = "name", required = false) String name) {
    return isBlankString(name)
        ? "Hello stranger!"
        : "Hello, " + name;
  }


  @GetMapping("/greet")
  public ResponseEntity<User> greetUser(
      @RequestParam(name = "name", required = false) String name,
      @RequestParam(name = "greet", required = false) String greet) {
    return isBlankString(name) && isNotBlankString(greet)
        ? ResponseEntity.ok(new User("Ihor", greet))
        : isNotBlankString(name) && isBlankString(greet)
        ? ResponseEntity.ok(new User(name, "Hello,"))
        : isBlankString(name) && isBlankString(greet)
        ? ResponseEntity.ok(new User("Ihor", "Hello,"))
        : ResponseEntity.ok(new User(name, greet))
        ;
  }

  private static boolean isBlankString(String name) {
    return Objects.isNull(name) || name.isBlank() || name.isEmpty();
  }

  private static boolean isNotBlankString(String name) {
    return !isBlankString(name);
  }
}
