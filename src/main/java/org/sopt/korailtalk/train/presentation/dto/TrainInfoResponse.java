package org.sopt.korailtalk.train.presentation.dto;

import org.sopt.korailtalk.global.domain.SeatType;
import org.sopt.korailtalk.global.domain.TrainType;

public record TrainInfoResponse(
	String startAt,
	String arriveAt,
	TrainType type,
	String trainNumber,
	SeatType seatType,
	Integer price,
	Long reservationId
) {
	public static TrainInfoResponse of(
		String startAt,
		String arriveAt,
		TrainType type,
		String trainNumber,
		SeatType seatType,
		Integer price,
		Long reservationId
	) {
		return new TrainInfoResponse(startAt, arriveAt, type, trainNumber, seatType, price, reservationId);
	}
}
