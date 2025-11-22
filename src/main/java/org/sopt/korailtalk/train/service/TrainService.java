package org.sopt.korailtalk.train.service;

import org.sopt.korailtalk.train.domain.Train;
import org.sopt.korailtalk.train.presentation.dto.TrainInfoRequest;
import org.sopt.korailtalk.train.presentation.dto.TrainInfoResponse;
import org.sopt.korailtalk.train.presentation.dto.TrainsRequest;
import org.sopt.korailtalk.train.presentation.dto.TrainsResponse;

public interface TrainService {

	TrainInfoResponse getTrainInfo(Long trainId, TrainInfoRequest request, Long reservationId);
	Train findById(Long trainId);
	TrainsResponse getTrains(TrainsRequest request);
}
