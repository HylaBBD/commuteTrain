package com.commutetrip.backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class TruckRoute {
  private Long truckRouteId;
  private Long routeId;
  private Timestamp pickupTime;
  private Timestamp dropOffTime;

  public TruckRoute(Long truckRouteId, Long routeId, Timestamp pickupTime, Timestamp dropOffTime) {
    this.truckRouteId = truckRouteId;
    this.routeId = routeId;
    this.pickupTime = pickupTime;
    this.dropOffTime = dropOffTime;
  }
}
