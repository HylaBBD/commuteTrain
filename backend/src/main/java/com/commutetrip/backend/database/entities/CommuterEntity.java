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
@Entity
@NoArgsConstructor
@Table(name = "commuters")
public class CommuterEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "commuter_id")
  private Long commuterId;

  @Column(name = "commuter_name")
  private String commuterName;

  @Column(name = "aws_user_id")
  private Long awsUserId;

  public CommuterEntity(String commuterName, Long awsUserId) {
    this.commuterName = commuterName;
    this.awsUserId = awsUserId;
  }
}