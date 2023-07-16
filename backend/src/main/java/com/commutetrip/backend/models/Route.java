package com.commutetrip.backend.models;

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
@Table(name = "routes")
public class Route {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "route_id")
  private Long routeId;

  @Column(name = "starting_point")
  private Long startingPoint;

  @Column(name = "end_point")
  private Long endPoint;

  @Column(name = "pickup_time")
  private Timestamp pickupTime;

  @Column(name = "drop_off_time")
  private Timestamp dropOffTime;

  public Route(Long startingPoint, Long endPoint, Timestamp pickupTime, Timestamp dropOffTime) {
    this.startingPoint = startingPoint;
    this.endPoint = endPoint;
    this.pickupTime = pickupTime;
    this.dropOffTime = dropOffTime;
  }

}
