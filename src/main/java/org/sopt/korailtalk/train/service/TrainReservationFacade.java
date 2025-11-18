package org.sopt.korailtalk.train.service;

import org.sopt.korailtalk.global.domain.SeatType;
import org.sopt.korailtalk.reservation.domain.ReservationQueue;
import org.sopt.korailtalk.reservation.repository.ReservationQueueRepository;
import org.sopt.korailtalk.train.domain.Train;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TrainReservationFacade {

	private final ReservationQueueRepository queueRepository;

	public Long insertToQueue(SeatType seatType, Train train) {
		return queueRepository.save(ReservationQueue.create(seatType, train)).getId();
	}
}
