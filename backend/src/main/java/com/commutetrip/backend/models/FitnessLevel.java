package com.commutetrip.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "fitness_levels")
public class FitnessLevel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "fitness_level_id")
  private Long fitnessLevelId;

  @Column(name = "description")
  private String fitnessDescription;

  public FitnessLevel(String fitnessDescription) {
    this.fitnessDescription = fitnessDescription;
  }
}
