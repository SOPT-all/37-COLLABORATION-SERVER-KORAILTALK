package org.sopt.korailtalk.reservation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.korailtalk.global.domain.SeatType;
import org.sopt.korailtalk.global.entity.BaseTimeEntity;
import org.sopt.korailtalk.train.domain.Train;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "reservation_queue")
public class ReservationQueue extends BaseTimeEntity {

  // 예약 대기 생성 후 10분 후 만료
  private static final long RESERVATION_EXPIRATION_MINUTES = 10;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "reservation_queue_id")
  private Long id;

  private LocalDateTime expireAt;

  @Enumerated(EnumType.STRING)
  private SeatType seatType;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "train_id")
  private Train train;

  private ReservationQueue(SeatType seatType, Train train) {
    this.seatType = seatType;
    this.train = train;
    this.expireAt = LocalDateTime.now().plusMinutes(RESERVATION_EXPIRATION_MINUTES);
  }

  public static ReservationQueue create(SeatType seatType, Train train) {
    return new ReservationQueue(seatType, train);
  }
}
