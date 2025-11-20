package org.sopt.korailtalk.reservation.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.korailtalk.global.response.base.BaseCode;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ReservationErrorCode implements BaseCode {

  // 404 NOT FOUND
  RESERVATION_NOT_FOUND(HttpStatus.NOT_FOUND, "예약을 찾을 수 없습니다.");

  private final HttpStatus httpStatus;
  private final String message;
}
