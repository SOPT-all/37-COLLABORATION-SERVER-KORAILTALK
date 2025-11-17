package org.sopt.korailtalk.global.response.base;

import org.springframework.http.HttpStatus;

public interface BaseSuccessCode {

	HttpStatus getHttpStatus();

	String getMessage();

}

