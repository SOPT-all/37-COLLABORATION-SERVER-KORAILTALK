package org.sopt.korailtalk.member.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.korailtalk.global.response.dto.SuccessResponse;
import org.sopt.korailtalk.member.dto.NationalVerifyRequest;
import org.sopt.korailtalk.member.dto.NationalVerifyResponse;
import org.sopt.korailtalk.member.exception.MemberSuccessCode;
import org.sopt.korailtalk.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/national")
public class MemberController {
  private final MemberService memberService;

  @PostMapping("/verify")
  public ResponseEntity<SuccessResponse<NationalVerifyResponse>> verifyNationalMember(
      @RequestBody @Valid NationalVerifyRequest request
  ) {
    NationalVerifyResponse response = memberService.verifyNationalMember(request);

    // 인증 성공 여부
    MemberSuccessCode successCode = response.verified()
        ? MemberSuccessCode.VERIFICATION_SUCCESS
        : MemberSuccessCode.VERIFICATION_FAILED;

    return ResponseEntity
        .status(successCode.getHttpStatus())
        .body(SuccessResponse.of(successCode, response));
  }
}
