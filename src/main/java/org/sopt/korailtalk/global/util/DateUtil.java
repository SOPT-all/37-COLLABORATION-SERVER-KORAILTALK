package org.sopt.korailtalk.global.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
  private static final DateTimeFormatter BIRTHDATE_FORMATTER = DateTimeFormatter.ofPattern("yyMMdd");

  private DateUtil() {}

  public static LocalDate parseYYMMDD(String birthdateStr) {
    LocalDate parsedDate = LocalDate.parse(birthdateStr, BIRTHDATE_FORMATTER);
    // 미래 날짜면 - 100년
    if (parsedDate.isAfter(LocalDate.now())) {
      parsedDate = parsedDate.minusYears(100);
    }
    return parsedDate;
  }
}
