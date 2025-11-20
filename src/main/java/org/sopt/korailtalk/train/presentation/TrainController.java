package org.sopt.korailtalk.train.presentation;

import org.sopt.korailtalk.global.response.dto.SuccessResponse;

import org.sopt.korailtalk.train.exception.TrainSuccessCode;
import org.sopt.korailtalk.train.presentation.dto.TrainInfoRequest;
import org.sopt.korailtalk.train.presentation.dto.TrainInfoResponse;
import org.sopt.korailtalk.train.presentation.dto.TrainsRequest;
import org.sopt.korailtalk.train.presentation.dto.TrainsResponse;
import org.sopt.korailtalk.train.service.TrainReservationFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/trains")
public class TrainController {

	private final TrainReservationFacade trainReservationFacade;

	@PostMapping("{trainId}")
	ResponseEntity<SuccessResponse<TrainInfoResponse>> getTrainInfo(
		@PathVariable("trainId") Long trainId,
		@RequestBody @Valid TrainInfoRequest request
	) {

		TrainInfoResponse response =
			trainReservationFacade.reserveAndGetTrainInfo(trainId, request);

		return ResponseEntity
			.status(TrainSuccessCode.GET_TRAIN_INFO_SUCCESS.getHttpStatus())
			.body(SuccessResponse.of(TrainSuccessCode.GET_TRAIN_INFO_SUCCESS, response));
	}

	@GetMapping
	ResponseEntity<SuccessResponse<TrainsResponse>> getTrains(
		@ModelAttribute TrainsRequest request
	) {
		TrainsResponse response = trainReservationFacade.getTrains(request);

		return ResponseEntity
				.status(TrainSuccessCode.GET_TRAINS_SUCCESS.getHttpStatus())
				.body(SuccessResponse.of(TrainSuccessCode.GET_TRAINS_SUCCESS, response));
	}

}
