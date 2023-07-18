package com.commutetrip.backend.database.models;

import java.sql.Timestamp;

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
@Table(name = "truck_routes")
public class TruckRoutes {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "truck_route_id")
  private Long truckRouteId;

  @Column(name = "route_id")
  private Long routeId;

  @Column(name = "pickup_time")
  private Timestamp pickupTime;

  @Column(name = "drop_off_time")
  private Timestamp dropOffTime;

  public TruckRoutes(Long routeId, Timestamp pickupTime, Timestamp dropOffTime) {
    this.routeId = routeId;
    this.pickupTime = pickupTime;
    this.dropOffTime = dropOffTime;
  }

}
