package edu.lemon.demointernetstore.model.mapper;

import edu.lemon.demointernetstore.model.database.entity.Product;
import edu.lemon.demointernetstore.view.web.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
  ProductDto toDto(Product product);
  Product fromDto(ProductDto productDto);
}
