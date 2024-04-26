package edu.lemon.demointernetstore.view.web.dto;

public record User(String name, String greeting) {
  @Override
  public String toString() {
    return greeting + " " + name;
  }
}
