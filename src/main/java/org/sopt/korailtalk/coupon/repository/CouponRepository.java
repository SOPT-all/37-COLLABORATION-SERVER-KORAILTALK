package org.sopt.korailtalk.coupon.repository;

import org.sopt.korailtalk.coupon.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

}
