package org.sopt.korailtalk.train.presentation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.sopt.korailtalk.train.domain.Train;

import java.time.format.DateTimeFormatter;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
                                train.getId(),
                                train.getTrainType().getValue(),
                                train.getTrainNumber(),
                                train.getStartAt().format(timeFormatter),
                                train.getArriveAt().format(timeFormatter),
                                train.getDuration(),
                                train.getNormalSeat().getStatus().getDescription(),
                                train.getPremiumSeat() != null? train.getPremiumSeat().getStatus().getDescription() : null,
                                train.getNormalSeat().getPrice(),
                                train.getPremiumSeat() != null ? train.getPremiumSeat().getPrice() : null
                        )
                ).toList()

        );
    }

    private record TrainInfo (
        Long trainId,
        String type,
        String trailNumber,
        String startAt,
        String arriveAt,
        Integer duration,
        String normalSeatStatus,
        String premiumSeatStatus,
        Integer normalSeatPrice,
        Integer premiumSeatPrice
    ){}
}
