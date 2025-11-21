package org.sopt.korailtalk.train.presentation;

import java.util.List;

import org.sopt.korailtalk.coupon.presentation.dto.CouponInfo;
import org.sopt.korailtalk.train.presentation.dto.TrainInfoResponse;

public record TrainWithCouponsResponse(
	TrainInfoResponse trainInfo,
	List<CouponInfo> coupons
) {
	public static TrainWithCouponsResponse of(TrainInfoResponse trainInfo, List<CouponInfo> coupons) {
		return new TrainWithCouponsResponse(trainInfo, coupons);
	}
}
