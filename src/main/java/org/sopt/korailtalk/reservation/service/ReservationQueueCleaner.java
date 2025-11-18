package org.sopt.korailtalk.reservation.service;

import java.time.LocalDateTime;
import java.util.List;

import org.sopt.korailtalk.reservation.domain.ReservationQueue;
import org.sopt.korailtalk.reservation.repository.ReservationQueueRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationQueueCleaner {

	private final ReservationQueueRepository reservationQueueRepository;

	@Transactional
	@Scheduled(cron = "0 * * * * *") //매 분 0초마다 실행
	public void deleteExpiredReservations() {
		LocalDateTime now = LocalDateTime.now();

		List<ReservationQueue> expiredQueues = reservationQueueRepository.findByExpireAtBefore(now);
		if (expiredQueues.isEmpty())
			return;

		expiredQueues.forEach(queue -> {
			queue.getTrain().increaseRemainingSeat(queue.getSeatType());
		});

		reservationQueueRepository.deleteAllInBatch(expiredQueues);
	}
}
