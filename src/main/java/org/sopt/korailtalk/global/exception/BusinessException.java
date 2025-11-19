package org.sopt.korailtalk.global.exception;

import lombok.Getter;
import org.sopt.korailtalk.global.response.base.BaseCode;

@Getter
public class BusinessException extends RuntimeException {
	private final BaseCode baseCode;

	public BusinessException(BaseCode baseCode) {
		super(baseCode.getMessage());
		this.baseCode = baseCode;
	}
}
