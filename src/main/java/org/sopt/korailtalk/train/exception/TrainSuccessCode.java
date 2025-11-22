package org.sopt.korailtalk.train.exception;

import org.sopt.korailtalk.global.response.base.BaseCode;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TrainSuccessCode implements BaseCode {

	//200 OK
	GET_TRAIN_HOME_INFO_SUCCESS(HttpStatus.OK, "홈 화면 정보 조회가 성공하였습니다." ),
	GET_TRAINS_SUCCESS(HttpStatus.OK, "열차 목록 조회 성공"),

	//201 CREATED
	GET_TRAIN_INFO_SUCCESS(HttpStatus.CREATED, "열차 정보 조회 및 예약 대기 처리가 성공하였습니다.");

	private final HttpStatus httpStatus;
	private final String message;
}
