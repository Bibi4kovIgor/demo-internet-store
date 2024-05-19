package edu.lemon.demointernetstore.model.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "documents")
public class Documents {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NonNull
  private Long id;

  @Column(name = "tax_id")
  @NonNull private Long taxId;

  @Column(name = "passport")
  @NonNull private String passport;

  @Column(name = "additional_info")
  private String additionalInfo;
}
