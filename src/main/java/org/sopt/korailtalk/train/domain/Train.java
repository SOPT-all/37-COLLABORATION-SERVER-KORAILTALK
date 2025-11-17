package org.sopt.korailtalk.train.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.korailtalk.global.domain.TrainType;
import org.sopt.korailtalk.global.entity.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "trains")
public class Train extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "train_id")
  private Long id;

  private LocalDateTime startAt;
  private LocalDateTime endAt;

  @Enumerated(EnumType.STRING)
  private TrainType trainType;

  private String trailNumber;

  private String origin;
  private String destination;

  @OneToOne(mappedBy = "train", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private NormalSeat normalSeat;

  @OneToOne(mappedBy = "train", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private PremiumSeat premiumSeat;
}
