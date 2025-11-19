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

  public boolean isMatch(String inputPassword, LocalDate inputBirthDate) {
    if (!this.password.equals(inputPassword)) {
      return false;
    }
    return this.birthdate.equals(inputBirthDate);
  }

}
