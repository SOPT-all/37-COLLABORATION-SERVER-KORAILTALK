package org.sopt.korailtalk.global.response.dto;

import org.sopt.korailtalk.global.response.base.BaseErrorCode;
import org.springframework.http.HttpStatus;

public record ErrorResponse(
	int status,
	String message
) {

	public static ErrorResponse of(BaseErrorCode baseErrorCode) {
		return new ErrorResponse(baseErrorCode.getHttpStatus().value(), baseErrorCode.getMessage());
	}

	public static ErrorResponse of(HttpStatus httpStatus, String message) { //메시지 추가 커스텀
		return new ErrorResponse(httpStatus.value(), message);
	}

	public static ErrorResponse of(BaseErrorCode errorCode, Object detail) { //디테일 추가 커스텀
		return new ErrorResponse(errorCode.getHttpStatus().value(),
			errorCode.getMessage() + (detail != null ? ": " + detail : "")
		);
	}
}
