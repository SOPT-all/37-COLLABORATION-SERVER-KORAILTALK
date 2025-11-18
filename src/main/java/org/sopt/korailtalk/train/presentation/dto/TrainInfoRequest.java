package org.sopt.korailtalk.train.presentation.dto;

import org.sopt.korailtalk.global.domain.SeatType;

import jakarta.validation.constraints.NotNull;

public record TrainInfoRequest(
	@NotNull
	SeatType seatType
) {
}
