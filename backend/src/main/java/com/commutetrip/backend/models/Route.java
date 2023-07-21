package com.commutetrip.backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Route {
  private Long routeId;
  private Long startingPoint;
  private Long endPoint;

  public Route(Long routeId, Long startingPoint, Long endPoint) {
    this.routeId = routeId;
    this.startingPoint = startingPoint;
    this.endPoint = endPoint;
  }
}
