package org.sopt.korailtalk.train.exception;

import org.sopt.korailtalk.global.response.base.BaseCode;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TrainErrorCode implements BaseCode {

	//400 BAD REQUEST
	NO_AVAILABLE_SEAT(HttpStatus.BAD_REQUEST, "예약 가능한 좌석이 없습니다."),

	//404 NOT FOUND
	TRAIN_NOT_FOUND(HttpStatus.NOT_FOUND, "해당하는 열차 정보가 존재하지 않습니다."),
	;

	private final HttpStatus httpStatus;
	private final String message;
}
