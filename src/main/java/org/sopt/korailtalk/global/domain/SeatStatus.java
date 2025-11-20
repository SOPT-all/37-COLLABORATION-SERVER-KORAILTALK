package org.sopt.korailtalk.global.domain;

public enum SeatStatus {
    AVAILABLE("예매 가능"),
    ALMOST_SOLD_OUT("매진 임박"),
    SOLD_OUT("매진");

    private final String description;

    SeatStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static SeatStatus from(int remainingSeats) {
        if (remainingSeats > 5) {
            return SeatStatus.AVAILABLE;
        } else if (remainingSeats > 0) {
            return SeatStatus.ALMOST_SOLD_OUT;
        } else {
            return SeatStatus.SOLD_OUT;
        }
    }

}