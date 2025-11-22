package org.sopt.korailtalk.train.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.sopt.korailtalk.global.domain.SeatType;
import org.sopt.korailtalk.global.domain.TrainType;
import org.sopt.korailtalk.train.domain.QNormalSeat;
import org.sopt.korailtalk.train.domain.QPremiumSeat;
import org.sopt.korailtalk.train.domain.QTrain;
import org.sopt.korailtalk.train.domain.Train;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TrainQueryRepositoryImpl implements TrainQueryRepository {

    private final JPAQueryFactory query;

    @Override
    public List<Train> findTrainsByFilter(
            String origin,
            String destination,
            TrainType trainType,
            SeatType seatType,
            Boolean isBookAvailable,
            String cursor
    ) {

        QTrain train = QTrain.train;
        QNormalSeat normal = QNormalSeat.normalSeat;
        QPremiumSeat premium = QPremiumSeat.premiumSeat;

        return query
                .select(train).distinct()
                .from(train)
                .leftJoin(train.normalSeat, normal).fetchJoin()
                .leftJoin(train.premiumSeat, premium).fetchJoin()
                .where(
                        originEq(origin),
                        destinationEq(destination),
                        trainTypeEq(trainType),
                        seatTypeEq(seatType),
                        bookAvailableEq(isBookAvailable),
                        cursorLt(cursor)
                )
                .orderBy(train.id.asc())
                .limit(20)
                .fetch();
    }

    @Override
    public int countTrainsByFilter(
            String origin,
            String destination,
            TrainType trainType,
            SeatType seatType,
            Boolean isBookAvailable
    ) {

        QTrain train = QTrain.train;

        return Optional.ofNullable(
                query.select(train.count())
                        .from(train)
                        .where(
                                originEq(origin),
                                destinationEq(destination),
                                trainTypeEq(trainType),
                                seatTypeEq(seatType),
                                bookAvailableEq(isBookAvailable)
                        )
                        .fetchOne()
        ).orElse(0L).intValue();
    }

    private BooleanExpression originEq(String origin) {
        return origin != null ? QTrain.train.origin.eq(origin) : null;
    }

    private BooleanExpression destinationEq(String destination) {
        return destination != null ? QTrain.train.destination.eq(destination) : null;
    }

    private BooleanExpression trainTypeEq(TrainType type) {
        return type != null ? QTrain.train.trainType.eq(type) : null;
    }

    private BooleanExpression seatTypeEq(SeatType type) {
        if (type == null) return null;

        return switch (type) {
            case NORMAL -> QTrain.train.normalSeat.isNotNull();
            case PREMIUM -> QTrain.train.premiumSeat.isNotNull();
        };
    }

    private BooleanExpression bookAvailableEq(Boolean available) {
        if (available == null) return null;

        QNormalSeat normal = QNormalSeat.normalSeat;
        QPremiumSeat premium = QPremiumSeat.premiumSeat;

        return available ?
                normal.remainingSeats.gt(0).or(premium.remainingSeats.gt(0))
                : null;
    }

    private BooleanExpression cursorLt(String cursor) {
        return (cursor != null) ? QTrain.train.id.lt(Long.valueOf(cursor)) : null;
    }
}
