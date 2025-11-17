package org.sopt.korailtalk.train.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "normal_seats")
public class NormalSeat {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "normal_seat_id")
  private Long id;

  private Integer totalSeats;
  private Integer remainingSeats;
  private Integer price;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "train_id")
  private Train train;
}
