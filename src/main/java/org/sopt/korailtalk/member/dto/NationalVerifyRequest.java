package org.sopt.korailtalk.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record NationalVerifyRequest(
    @NotBlank(message = "보훈 번호는 필수입니다.")
    String nationalId,

    @NotBlank(message = "비밀번호는 필수입니다.")
    String password,

    @NotBlank(message = "생년월일은 필수입니다.")
    @Pattern(regexp = "\\d{6}", message = "생년월일은 6자리 숫자여야 합니다. (YYMMDD)")
    String birthdate
) {

}
