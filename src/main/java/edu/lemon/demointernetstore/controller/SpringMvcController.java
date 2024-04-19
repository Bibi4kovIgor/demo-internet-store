package edu.lemon.demointernetstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/internet-store")
public class SpringMvcController {

  @GetMapping
  public String greetings(){
    return "index.html";
  }

}
