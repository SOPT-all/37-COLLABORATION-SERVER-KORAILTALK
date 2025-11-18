package org.sopt.korailtalk.member.repository;

import org.sopt.korailtalk.member.domain.NationalMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationalMemberRepository extends JpaRepository<NationalMember, Long> {

}
