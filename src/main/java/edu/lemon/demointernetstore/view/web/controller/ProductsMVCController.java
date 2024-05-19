package edu.lemon.demointernetstore.view.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductsMVCController {

  @GetMapping
  public String loadProducts(){
    return "pages/products_dynamic";
  }

}
