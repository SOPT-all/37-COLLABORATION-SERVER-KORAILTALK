package org.sopt.korailtalk.reservation.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.korailtalk.global.response.dto.SuccessResponse;
import org.sopt.korailtalk.reservation.dto.ReservationCancelResponse;
import org.sopt.korailtalk.reservation.exception.ReservationSuccessCode;
import org.sopt.korailtalk.reservation.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reservation")
public class ReservationController {
  private final ReservationService reservationService;

  @DeleteMapping("/{reservationId}")
  public ResponseEntity<SuccessResponse<ReservationCancelResponse>> cancelReservation(
      @PathVariable Long reservationId
  ) {
    ReservationCancelResponse response = reservationService.cancelReservation(reservationId);

    return ResponseEntity
        .status(ReservationSuccessCode.RESERVATION_CANCEL_SUCCESS.getHttpStatus())
        .body(SuccessResponse.of(ReservationSuccessCode.RESERVATION_CANCEL_SUCCESS, response));
  }
}
