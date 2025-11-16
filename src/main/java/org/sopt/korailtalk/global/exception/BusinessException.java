package org.sopt.korailtalk.global.exception;

import org.sopt.korailtalk.global.response.base.BaseErrorCode;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
	private final BaseErrorCode baseErrorCode;

	public BusinessException(BaseErrorCode baseErrorCode) {
		super(baseErrorCode.getMessage());
		this.baseErrorCode = baseErrorCode;
	}
}
