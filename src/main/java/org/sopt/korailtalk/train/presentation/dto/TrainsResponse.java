package org.sopt.korailtalk.train.presentation.dto;

import org.sopt.korailtalk.global.domain.TrainType;
import org.sopt.korailtalk.train.domain.Train;

import java.time.format.DateTimeFormatter;
import java.util.List;

public record TrainsResponse(
        String origin,
        String destination,
        int totalTrains,
        String nextCursor,
        List<TrainInfo> trainList
){
    public static TrainsResponse from(
            String origin,
            String destination,
            int totalTrains,
            String nextCursor,
            List<Train> trains
    ) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        return new TrainsResponse(
                origin,
                destination,
                totalTrains,
                nextCursor,
                trains.stream().map(
                        train -> new TrainInfo(
                                train.getTrainType(),
                                train.getTrainNumber(),
                                train.getStartAt().format(timeFormatter),
                                train.getArriveAt().format(timeFormatter),
                                train.getDuration(),
                                train.getNormalSeat().getStatus().getDescription(),
                                train.getPremiumSeat().getStatus().getDescription(),
                                train.getNormalSeat().getPrice(),
                                train.getPremiumSeat().getPrice()
                        )
                ).toList()

        );
    }

    private record TrainInfo (
        TrainType type,
        String trailNumber,
        String startAt,
        String arriveAt,
        int duration,
        String normalSeatStatus,
        String premiumSeatStatus,
        int normalSeatPrice,
        int premiumSeatPrice
    ){}
}
