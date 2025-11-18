package org.sopt.korailtalk.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "national_member")
public class NationalMember {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "national_member_id")
  private Long id;

  @Column(unique = true, nullable = false)
  private String nationalId;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private LocalDate birthdate;

  private static final DateTimeFormatter BIRTHDATE_FORMATTER = DateTimeFormatter.ofPattern("yyMMdd");

  public boolean isMatch(String inputPassword, String inputBirthdate6Digits) {
    if (!this.password.equals(inputPassword)) {
      return false;
    }

    LocalDate inputDate = parseBirthdate(inputBirthdate6Digits);
    return this.birthdate.equals(inputDate);
  }

  // 날짜 변환 로직
  private LocalDate parseBirthdate(String birthdateStr) {
    LocalDate parsedDate = LocalDate.parse(birthdateStr, BIRTHDATE_FORMATTER);
    if (parsedDate.isAfter(LocalDate.now())) {
      parsedDate = parsedDate.minusYears(100);
    }
    return parsedDate;
  }
}
