package org.sopt.korailtalk.global.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum SeatType {
  NORMAL, PREMIUM;

  @JsonCreator
  public static SeatType of(String value) {
    if (value == null) return null;

    return switch (value.trim().toUpperCase()) {
      case "NORMAL" -> NORMAL;
      case "PREMIUM" -> PREMIUM;
      default -> null;
    };
  }
}
