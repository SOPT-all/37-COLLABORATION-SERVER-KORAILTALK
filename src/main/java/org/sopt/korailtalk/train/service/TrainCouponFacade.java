package org.sopt.korailtalk.train.service;

import java.util.List;

import org.sopt.korailtalk.coupon.presentation.dto.CouponInfo;
import org.sopt.korailtalk.coupon.repository.CouponRepository;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TrainCouponFacade {

	private final CouponRepository couponRepository;

	public List<CouponInfo> findAllCoupons() {
		return couponRepository.findAll().stream()
			.map(coupon -> CouponInfo.of(coupon.getName(), coupon.getDiscountRate()))
			.toList();
	}
}
