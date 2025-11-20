package org.sopt.korailtalk.train.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.sopt.korailtalk.global.domain.SeatType;
import org.sopt.korailtalk.global.exception.BusinessException;
import org.sopt.korailtalk.train.domain.Train;
import org.sopt.korailtalk.train.exception.TrainErrorCode;
import org.sopt.korailtalk.train.presentation.dto.TrainInfoRequest;
import org.sopt.korailtalk.train.presentation.dto.TrainInfoResponse;
import org.sopt.korailtalk.train.presentation.dto.TrainsRequest;
import org.sopt.korailtalk.train.presentation.dto.TrainsResponse;
import org.sopt.korailtalk.train.repository.TrainRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainServiceImpl implements TrainService {

	private final TrainRepository trainRepository;
	private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

	public TrainInfoResponse getTrainInfo(Long trainId, TrainInfoRequest request, Long reservationId) {
		Train train = findById(trainId);
		SeatType seatType = request.seatType();
		train.decreaseRemainingSeat(seatType);

		return TrainInfoResponse.of(
			train.getStartAt().format(TIME_FORMATTER),
			train.getArriveAt().format(TIME_FORMATTER),
			train.getTrainType(),
			train.getTrainNumber(),
			seatType,
			seatPriceReturnerBySeatType(train, seatType),
			reservationId
		);
	}

	public Train findById(Long trainId) {
		return trainRepository.findById(trainId)
			.orElseThrow(()-> new BusinessException(TrainErrorCode.TRAIN_NOT_FOUND));
	}

	private Integer seatPriceReturnerBySeatType(Train train, SeatType seatType) {
		Integer price;
		if (seatType == SeatType.NORMAL) {
			price = train.getNormalSeat().getPrice();
		} else {
			price = train.getPremiumSeat().getPrice();
		}
		return price;
	}

	public TrainsResponse getTrains(TrainsRequest request) {

		List<Train> trains = trainRepository.findTrainsByFilter(
				request.origin(),
				request.destination(),
				request.trainType(),
				request.seatType(),
				request.isBookAvailable(),
				request.cursor()
		);

		String nextCursor = trains.isEmpty() ?
				null :
				String.valueOf(trains.get(trains.size() - 1).getId());

		int total = trainRepository.countTrainsByFilter(
				request.origin(),
				request.destination(),
				request.trainType(),
				request.seatType(),
				request.isBookAvailable()
		);

		return TrainsResponse.from(
				request.origin(),
				request.destination(),
				total,
				nextCursor,
				trains
		);
	}
}
