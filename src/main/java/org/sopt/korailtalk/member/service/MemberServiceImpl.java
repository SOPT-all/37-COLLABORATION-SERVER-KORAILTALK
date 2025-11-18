package org.sopt.korailtalk.member.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.sopt.korailtalk.member.domain.NationalMember;
import org.sopt.korailtalk.member.dto.NationalVerifyRequest;
import org.sopt.korailtalk.member.dto.NationalVerifyResponse;
import org.sopt.korailtalk.member.repository.NationalMemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {
  private final NationalMemberRepository nationalMemberRepository;
  public NationalVerifyResponse verifyNationalMember(NationalVerifyRequest request) {
    Optional<NationalMember> memberOp = nationalMemberRepository.findByNationalId(request.nationalId());

    if (memberOp.isEmpty()) {
      return NationalVerifyResponse.of(false);
    }

    NationalMember member = memberOp.get();

    boolean isVerified = member.isMatch(request.password(), request.birthdate());

    return NationalVerifyResponse.of(isVerified);
  }
}
