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

  public Route(Long startingPoint, Long endPoint) {
    this.startingPoint = startingPoint;
    this.endPoint = endPoint;
  }

}
