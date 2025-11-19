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

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.sopt.korailtalk.global.domain.SeatType;
import org.sopt.korailtalk.global.domain.TrainType;
import org.sopt.korailtalk.global.entity.BaseTimeEntity;
import org.sopt.korailtalk.reservation.domain.ReservationQueue;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "train")
public class Train extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "train_id")
	private Long id;

	private LocalDateTime startAt;
	private LocalDateTime arriveAt;

	@Enumerated(EnumType.STRING)
	private TrainType trainType;

	private String trainNumber;

	private String origin;
	private String destination;

	@OneToOne(mappedBy = "train", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private NormalSeat normalSeat;

	@OneToOne(mappedBy = "train", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private PremiumSeat premiumSeat;

	@OneToMany(mappedBy = "train")
	private List<ReservationQueue> reservationQueues = new ArrayList<>();

	public void decreaseRemainingSeat(SeatType seatType) {
		if (seatType == SeatType.NORMAL)
			normalSeat.decrease();
		else
			premiumSeat.decrease();
	}

	public void increaseRemainingSeat(SeatType seatType) {
		if (seatType == SeatType.NORMAL)
			normalSeat.increase();
		else
			premiumSeat.increase();
	}

}
