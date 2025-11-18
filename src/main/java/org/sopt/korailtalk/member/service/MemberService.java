package org.sopt.korailtalk.member.service;

import org.sopt.korailtalk.member.dto.NationalVerifyRequest;
import org.sopt.korailtalk.member.dto.NationalVerifyResponse;

public interface MemberService {
  NationalVerifyResponse verifyNationalMember(NationalVerifyRequest request);
}
