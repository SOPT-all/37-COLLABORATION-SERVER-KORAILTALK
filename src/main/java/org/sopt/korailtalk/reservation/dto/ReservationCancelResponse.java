package org.sopt.korailtalk.reservation.dto;

public record ReservationCancelResponse(
    Long canceledReservationId
) {
  public static ReservationCancelResponse of(Long canceledReservationId) {
    return new ReservationCancelResponse(canceledReservationId);
  }
}
