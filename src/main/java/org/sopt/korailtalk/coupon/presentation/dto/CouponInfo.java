package org.sopt.korailtalk.coupon.presentation.dto;

import org.sopt.korailtalk.coupon.domain.Coupon;

public record CouponInfo(
	String name,
	Integer discountRate
) {
	public static CouponInfo of(String name, Integer discountRate) {
		return new CouponInfo(name, discountRate);
	}
}
