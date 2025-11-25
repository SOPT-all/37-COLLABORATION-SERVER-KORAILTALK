package org.sopt.korailtalk.train.presentation.dto;

import org.sopt.korailtalk.global.domain.SeatType;
import org.sopt.korailtalk.global.domain.TrainType;

public record TrainInfoResponse(
	String origin,
	String destination,
	String startAt,
	String arriveAt,
	TrainType type,
	String trainNumber,
	SeatType seatType,
	Integer price,
	Long reservationId
) {
	public static TrainInfoResponse of(
		String origin,
		String destination,
		String startAt,
		String arriveAt,
		TrainType type,
		String trainNumber,
		SeatType seatType,
		Integer price,
		Long reservationId
	) {
		return new TrainInfoResponse(origin, destination, startAt, arriveAt, type, trainNumber, seatType, price, reservationId);
	}
}
