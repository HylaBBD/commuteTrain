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
@Table(name = "commuter_bookings")
public class CommuterBooking {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "booking_id")
  private Long bookingId;

  @Column(name = "commuter_id")
  private Long commuterId;

  @Column(name = "truck_route_id")
  private Long truckRouteId;

  public CommuterBooking(Long commuterId, Long truckRouteId) {
    this.commuterId = commuterId;
    this.truckRouteId = truckRouteId;
  }
}
