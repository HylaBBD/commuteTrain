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
@Entity
@NoArgsConstructor
@Table(name = "commuters")
public class Commuter {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "commuter_id")
  private Long commuterId;

  @Column(name = "commuter_name")
  private String commuterName;

  @Column(name = "route_id")
  private Long routeId;

  public Commuter(String commuterName, Long routeId) {
    this.commuterName = commuterName;
    this.routeId = routeId;
  }
}