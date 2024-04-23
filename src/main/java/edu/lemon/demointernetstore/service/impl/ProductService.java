package edu.lemon.demointernetstore.service.impl;

import edu.lemon.demointernetstore.database.model.Product;
import edu.lemon.demointernetstore.repository.ProductRepository;
import edu.lemon.demointernetstore.service.CrudService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service("ProductService")
@AllArgsConstructor
public class ProductService implements CrudService<Product, Long> {
  private final ProductRepository productRepository;

  @Override
  public Product create(Product object) {
    return productRepository.save(object);
  }

  @Override
  public List<Product> getAll() {
    return productRepository.findAll();
  }

  @Override
  public Product getById(Long id) {
    return productRepository.findById(id).orElse(null);
  }

  @Override
  public Product update(Product object) {
    return productRepository.save(object);
  }

  @Override
  public void deleteById(Long id) {
    productRepository.deleteById(id);
  }
}
