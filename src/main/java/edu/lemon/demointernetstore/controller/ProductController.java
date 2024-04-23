package edu.lemon.demointernetstore.controller;

import edu.lemon.demointernetstore.database.model.Product;
import edu.lemon.demointernetstore.service.CrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
  private final CrudService<Product, Long> service;

  public ProductController(@Qualifier("ProductService") CrudService<Product, Long> service) {
    this.service = service;
  }

  @GetMapping
  public List<Product> getAll() {
    return service.getAll();
  }

  @PostMapping
  public Product create(@RequestBody Product product) {
    return service.create(product);
  }

}
