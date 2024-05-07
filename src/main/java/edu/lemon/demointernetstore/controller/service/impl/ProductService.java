package edu.lemon.demointernetstore.controller.service.impl;

import edu.lemon.demointernetstore.controller.service.CrudService;
import edu.lemon.demointernetstore.model.database.entity.Products;
import edu.lemon.demointernetstore.model.mapper.ProductMapper;
import edu.lemon.demointernetstore.model.repository.ProductRepository;

import java.util.List;

import edu.lemon.demointernetstore.view.web.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service("ProductService")
@AllArgsConstructor
public class ProductService implements CrudService<ProductDto, Long> {
  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  @Override
  public ProductDto create(ProductDto productDto) {
    Products products = productMapper.fromDto(productDto);
    products = productRepository.save(products);
    return productMapper.toDto(products);
  }

  @Override
  public List<ProductDto> getAll() {
    return productRepository.findAll()
        .stream().map(productMapper::toDto)
        .toList();
  }

  @Override
  public ProductDto getById(Long id) {
    return productMapper.toDto(productRepository.findById(id).orElse(null));
  }

  @Override
  public ProductDto update(ProductDto object) {
    return productMapper.toDto(productRepository.save(productMapper.fromDto(object)));
  }

  @Override
  public void deleteById(Long id) {
    productRepository.deleteById(id);
  }

  @Override
  public List<ProductDto> getByQuantity(Integer quantity) {
    return productRepository
        .findAllByQuantity(quantity)
        .stream()
        .map(productMapper::toDto)
        .toList();
  }
}
