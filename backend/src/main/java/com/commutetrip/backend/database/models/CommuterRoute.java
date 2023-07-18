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
@Table(name = "commuter_routes")
public class CommuterRoute {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "commuter_route_id")
  private Long commuterRouteId;

  @Column(name = "commuter_id")
  private Long commuterId;

  @Column(name = "route_id")
  private Long routeId;

  public CommuterRoute(Long commuterId, Long routeId) {
    this.commuterId = commuterId;
    this.routeId = routeId;
  }
}
