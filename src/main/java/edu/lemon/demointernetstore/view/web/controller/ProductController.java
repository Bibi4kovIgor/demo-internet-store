package edu.lemon.demointernetstore.view.web.controller;

import edu.lemon.demointernetstore.controller.service.CrudService;
import java.util.List;

import edu.lemon.demointernetstore.view.web.dto.ProductDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
  private final CrudService<ProductDto, Long> service;

  public ProductController(@Qualifier("ProductService") CrudService<ProductDto, Long> service) {
    this.service = service;
  }

  @GetMapping
  public List<ProductDto> getAll() {
    return service.getAll();
  }

  @PostMapping
  public ProductDto create(@RequestBody ProductDto product) {
    return service.create(product);
  }

}
