package org.sopt.korailtalk.train.service;

import org.sopt.korailtalk.train.domain.Train;
import org.sopt.korailtalk.train.presentation.dto.TrainInfoRequest;
import org.sopt.korailtalk.train.presentation.dto.TrainInfoResponse;

public interface TrainService {

	TrainInfoResponse getTrainInfo(Long trainId, TrainInfoRequest request, Long reservationId);
	Train findById(Long trainId);

}
