package edu.lemon.demointernetstore.model.mapper;

import edu.lemon.demointernetstore.model.database.entity.Products;
import edu.lemon.demointernetstore.utils.IdTransformUtility;
import edu.lemon.demointernetstore.view.web.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ProductMapper {
  @Mapping(target = "id", source = "id", qualifiedByName = "encryptId")
  ProductDto toDto(Products products);

  @Named("encryptId")
  default String encryptId(Long id) {
    return id != null ? IdTransformUtility.encryptId(id) : null;
  }

  @Mapping(target = "id", source = "id", qualifiedByName = "decryptId")
  Products fromDto(ProductDto productDto);

  @Named("decryptId")
  default Long decryptId(String id) {
    return id != null ? IdTransformUtility.decryptId(id) : null;
  }
}
