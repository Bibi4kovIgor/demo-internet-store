package edu.lemon.demointernetstore.model.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdersPk implements Serializable {
  private Clients client;
  private Products product;
  private Instant orderDate;
}
