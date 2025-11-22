package org.sopt.korailtalk.train.repository;

import org.sopt.korailtalk.global.domain.SeatType;
import org.sopt.korailtalk.global.domain.TrainType;
import org.sopt.korailtalk.train.domain.Train;

import java.util.List;

public interface TrainQueryRepository {
    List<Train> findTrainsByFilter(
            String origin,
            String destination,
            TrainType trainType,
            SeatType seatType,
            Boolean isBookAvailable,
            String cursor
    );

    int countTrainsByFilter(
            String origin,
            String destination,
            TrainType trainType,
            SeatType seatType,
            Boolean isBookAvailable
    );
}
