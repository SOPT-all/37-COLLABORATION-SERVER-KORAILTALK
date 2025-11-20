package org.sopt.korailtalk.train.presentation.dto;

public record TrainHomeInfoResponse(
	String origin,
	String destination
) {
	public static TrainHomeInfoResponse of(String origin, String destination) {
		return new TrainHomeInfoResponse(origin, destination);
	}
}
