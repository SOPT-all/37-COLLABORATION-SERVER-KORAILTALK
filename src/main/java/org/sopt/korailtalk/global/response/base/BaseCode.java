package org.sopt.korailtalk.global.response.base;

import org.springframework.http.HttpStatus;

public interface BaseCode {
  HttpStatus getHttpStatus();
  String getMessage();
}
