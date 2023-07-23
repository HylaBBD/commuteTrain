package com.commutetrip.backend.database.entities;

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
@Table(name = "truck_stops")
public class TruckStopEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "stop_id")
  private Long stopId;

  @Column(name = "stop_latitude")
  private Double stopLatitude;

  @Column(name = "stop_longitude")
  private Double stopLongitude;

  @Column(name = "address")
  private String address;

}
