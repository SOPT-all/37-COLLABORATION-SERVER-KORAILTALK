package org.sopt.korailtalk.train.service;

import org.sopt.korailtalk.reservation.domain.ReservationQueue;
import org.sopt.korailtalk.reservation.repository.ReservationQueueRepository;
import org.sopt.korailtalk.train.domain.Train;
import org.sopt.korailtalk.train.presentation.dto.TrainInfoRequest;
import org.sopt.korailtalk.train.presentation.dto.TrainInfoResponse;
import org.sopt.korailtalk.train.presentation.dto.TrainsRequest;
import org.sopt.korailtalk.train.presentation.dto.TrainsResponse;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TrainReservationFacade {

	private final ReservationQueueRepository queueRepository;
	private final TrainService trainService;

	@Transactional
	public TrainInfoResponse reserveAndGetTrainInfo(Long trainId, TrainInfoRequest request) {

		Train train = trainService.findById(trainId);
		Long reservationId = queueRepository.save(ReservationQueue.create(request.seatType(), train)).getId();

		return trainService.getTrainInfo(trainId, request, reservationId);

	}


	public TrainsResponse getTrains(TrainsRequest request) {
		return trainService.getTrains(request);
	}
}
