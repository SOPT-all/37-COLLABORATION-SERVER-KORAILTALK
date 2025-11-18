package org.sopt.korailtalk.reservation.repository;

import org.sopt.korailtalk.reservation.domain.ReservationQueue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationQueueRepository extends JpaRepository<ReservationQueue, Long> {

}
