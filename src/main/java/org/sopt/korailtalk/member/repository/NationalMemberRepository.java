package org.sopt.korailtalk.member.repository;

import java.util.Optional;
import org.sopt.korailtalk.member.domain.NationalMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationalMemberRepository extends JpaRepository<NationalMember, Long> {
  Optional<NationalMember> findByNationalId(String nationalId);
}
