package edu.lemon.demointernetstore.model.repository;

import edu.lemon.demointernetstore.model.database.entity.Product;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findAllByQuantity(Integer quantity);

  @Query("from Product p where p.quantity > :quant")
  List<Product> findAllByQuantityMoreThan(@Param("quant") Integer quantity);
}
