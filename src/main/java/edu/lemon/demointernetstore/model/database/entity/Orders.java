package edu.lemon.demointernetstore.model.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Orders {
  @Id
  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "client_id", referencedColumnName = "id")
  @NonNull
  private Clients client;

  @Id
  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  @NonNull
  private Products product;

  @Id
  @NonNull
  @Column(name = "order_date")
  private Instant orderDate;

  @Column(name = "quantity")
  private int quantity;
}
