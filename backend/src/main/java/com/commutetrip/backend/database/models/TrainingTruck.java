package com.commutetrip.backend.database.models;

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
@Table(name = "training_trucks")
public class TrainingTruck {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "truck_id")
  private Long truckId;

  @Column(name = "route_id")
  private Long routeId;

  public TrainingTruck(Long routeId) {
    this.routeId = routeId;
  }

}
