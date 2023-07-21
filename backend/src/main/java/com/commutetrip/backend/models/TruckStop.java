package com.commutetrip.backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TruckStop {
  private Long stopId;
  private Double stopLatitude;
  private Double stopLongitude;

  public TruckStop(Long stopId, Double stopLatitude, Double stopLongitude) {
    this.stopId = stopId;
    this.stopLatitude = stopLatitude;
    this.stopLongitude = stopLongitude;
  }
}
