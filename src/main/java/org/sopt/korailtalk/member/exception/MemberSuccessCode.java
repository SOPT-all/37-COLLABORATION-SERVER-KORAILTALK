package org.sopt.korailtalk.member.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.korailtalk.global.response.base.BaseCode;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MemberSuccessCode implements BaseCode {

  // 200 OK
  VERIFICATION_SUCCESS(HttpStatus.OK, "인증되었습니다."),
  VERIFICATION_FAILED(HttpStatus.OK, "인증 정보가 유효하지 않습니다.");

  private final HttpStatus httpStatus;
  private final String message;
}
