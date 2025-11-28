package org.sopt.korailtalk.train.presentation;

import java.util.List;

import org.sopt.korailtalk.coupon.presentation.dto.CouponInfo;
import org.sopt.korailtalk.global.domain.SeatType;
import org.sopt.korailtalk.global.domain.TrainType;
import org.sopt.korailtalk.global.response.dto.SuccessResponse;

import org.sopt.korailtalk.train.exception.TrainSuccessCode;
import org.sopt.korailtalk.train.presentation.dto.TrainHomeInfoResponse;
import org.sopt.korailtalk.train.presentation.dto.TrainInfoRequest;
import org.sopt.korailtalk.train.presentation.dto.TrainInfoResponse;
import org.sopt.korailtalk.train.service.TrainCouponFacade;
import org.sopt.korailtalk.train.presentation.dto.TrainsRequest;
import org.sopt.korailtalk.train.presentation.dto.TrainsResponse;
import org.sopt.korailtalk.train.service.TrainReservationFacade;
import org.sopt.korailtalk.train.service.TrainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/trains")
public class TrainController {

	private final TrainReservationFacade trainReservationFacade;
	private final TrainService trainService;
	private final TrainCouponFacade	trainCouponFacade;

	@PostMapping("/{trainId}")
	ResponseEntity<SuccessResponse<TrainWithCouponsResponse>> getTrainInfo(
		@PathVariable("trainId") Long trainId,
		@RequestBody @Valid TrainInfoRequest request
	) {

		TrainInfoResponse trainInfo =
			trainReservationFacade.reserveAndGetTrainInfo(trainId, request);
		List<CouponInfo> couponInfo = trainCouponFacade.findAllCoupons();

		TrainWithCouponsResponse response = new TrainWithCouponsResponse(trainInfo, couponInfo);

		return ResponseEntity
			.status(TrainSuccessCode.GET_TRAIN_INFO_SUCCESS.getHttpStatus())
			.body(SuccessResponse.of(TrainSuccessCode.GET_TRAIN_INFO_SUCCESS, response));
	}

	@GetMapping("/home")
	ResponseEntity<SuccessResponse<TrainHomeInfoResponse>> getHomeInfo() {
		String origin = "서울";
		String destination = "부산";

		TrainHomeInfoResponse response = TrainHomeInfoResponse.of(origin, destination);
		return ResponseEntity
			.status(TrainSuccessCode.GET_TRAIN_HOME_INFO_SUCCESS.getHttpStatus())
			.body(SuccessResponse.of(TrainSuccessCode.GET_TRAIN_HOME_INFO_SUCCESS, response));
	}

	@GetMapping
	ResponseEntity<SuccessResponse<TrainsResponse>> getTrains(
			@RequestParam String origin,
			@RequestParam String destination,
			@RequestParam(required = false) String trainType,
			@RequestParam(required = false) String seatType,
			@RequestParam(required = false) Boolean isBookAvailable,
			@RequestParam(required = false) String cursor
	) {

		TrainsRequest request = new TrainsRequest(
				origin,
				destination,
				TrainType.of(trainType),
				seatType != null ? SeatType.of(seatType) : null,
				isBookAvailable,
				cursor
		);
		TrainsResponse response = trainService.getTrains(request);

		return ResponseEntity
				.status(TrainSuccessCode.GET_TRAINS_SUCCESS.getHttpStatus())
				.body(SuccessResponse.of(TrainSuccessCode.GET_TRAINS_SUCCESS, response));
	}

}
