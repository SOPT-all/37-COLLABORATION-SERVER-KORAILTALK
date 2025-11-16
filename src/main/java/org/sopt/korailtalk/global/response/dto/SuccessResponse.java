package org.sopt.korailtalk.global.response.dto;

import org.sopt.korailtalk.global.response.base.BaseSuccessCode;

public record SuccessResponse<T>(
	int status,
	String message,
	T data
) {

	public static <T> SuccessResponse<T> of(BaseSuccessCode baseSuccesscode) { //반환 데이터 없음
		return new SuccessResponse<>(baseSuccesscode.getHttpStatus().value(), baseSuccesscode.getMessage(), null);
	}

	public static <T> SuccessResponse<T> of(BaseSuccessCode baseSuccesscode, String message) { //반환 데이터 없음, 메시지 커스텀
		return new SuccessResponse<>(baseSuccesscode.getHttpStatus().value(), message, null);
	}

	public static <T> SuccessResponse<T> of(BaseSuccessCode baseSuccesscode, T data) { //반환 데이터 있음
		return new SuccessResponse<>(baseSuccesscode.getHttpStatus().value(), baseSuccesscode.getMessage(), data);
	}

	public static <T> SuccessResponse<T> of(BaseSuccessCode baseSuccesscode, String message,
		T data) { //반환 데이터 있음, 메시지 커스텀
		return new SuccessResponse<>(baseSuccesscode.getHttpStatus().value(), message, data);
	}
}