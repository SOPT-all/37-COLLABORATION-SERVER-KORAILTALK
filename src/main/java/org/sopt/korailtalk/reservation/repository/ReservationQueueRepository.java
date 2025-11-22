package org.sopt.korailtalk.reservation.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.sopt.korailtalk.reservation.domain.ReservationQueue;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationQueueRepository extends JpaRepository<ReservationQueue, Long> {

	@EntityGraph(attributePaths = {"train"})
	List<ReservationQueue> findByExpireAtBefore(LocalDateTime now);
}
