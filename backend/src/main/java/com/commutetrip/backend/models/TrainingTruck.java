package com.commutetrip.backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TrainingTruck {
  private Long truckId;
  private Long routeId;

  public TrainingTruck(Long truckId, Long routeId) {
    this.truckId = truckId;
    this.routeId = routeId;
  }
}
