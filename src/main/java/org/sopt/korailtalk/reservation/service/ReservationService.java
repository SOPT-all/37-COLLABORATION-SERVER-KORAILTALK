package org.sopt.korailtalk.reservation.service;

import org.sopt.korailtalk.reservation.dto.ReservationCancelResponse;

public interface ReservationService {
  ReservationCancelResponse cancelReservation(Long reservationId);
}
