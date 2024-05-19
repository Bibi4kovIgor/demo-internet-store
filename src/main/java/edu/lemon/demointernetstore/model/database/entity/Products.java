package edu.lemon.demointernetstore.model.database.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "products")
@Data
public class Products {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "vendor_code")
  private String vendorCode;

  @Column(name = "description")
  private String description;

  @Column(name = "quantity")
  private Integer quantity;

  @Column(name = "price")
  private BigDecimal price;

  @ManyToMany(cascade = CascadeType.ALL,
      fetch = FetchType.EAGER,
      mappedBy = "products")
  @BatchSize(size = 20)
  List<Categories> categories;
}
