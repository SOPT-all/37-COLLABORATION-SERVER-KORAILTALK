package org.sopt.korailtalk.reservation.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.korailtalk.global.response.base.BaseSuccessCode;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ReservationSuccessCode implements BaseSuccessCode {
  // 200 OK
  RESERVATION_CANCEL_SUCCESS(HttpStatus.OK, "예약이 취소되었습니다.");

  private final HttpStatus httpStatus;
  private final String message;
}
