package org.sopt.korailtalk.train.presentation.dto;

import org.sopt.korailtalk.global.domain.SeatType;
import org.sopt.korailtalk.global.domain.TrainType;

public record TrainsRequest(
        String origin,
        String destination,
        TrainType trainType,
        SeatType seatType,
        Boolean isBookAvailable,
        String cursor
) {
}
