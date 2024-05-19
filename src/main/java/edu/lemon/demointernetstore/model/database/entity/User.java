package edu.lemon.demointernetstore.model.database.entity;

import edu.lemon.demointernetstore.utils.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_list")
public class User {
  @Id
  @Column(name = "name")
  private String name;

  @Column(name = "pass")
  private String pass;

  @Column(name = "role")
  private String role;
}
