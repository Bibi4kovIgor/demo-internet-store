package edu.lemon.demointernetstore.model.repository;

import edu.lemon.demointernetstore.model.database.entity.Products;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
  List<Products> findAllByQuantity(Integer quantity);

  @Query("from Products p where p.quantity > :quant")
  List<Products> findAllByQuantityMoreThan(@Param("quant") Integer quantity);
}
