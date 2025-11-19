package org.sopt.korailtalk.train.presentation;

import org.sopt.korailtalk.global.response.dto.SuccessResponse;

import org.sopt.korailtalk.train.exception.TrainSuccessCode;
import org.sopt.korailtalk.train.presentation.dto.TrainInfoRequest;
import org.sopt.korailtalk.train.presentation.dto.TrainInfoResponse;
import org.sopt.korailtalk.train.service.TrainReservationFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
