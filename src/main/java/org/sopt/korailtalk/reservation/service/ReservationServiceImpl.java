package org.sopt.korailtalk.reservation.service;

import lombok.RequiredArgsConstructor;
import org.sopt.korailtalk.global.exception.BusinessException;
import org.sopt.korailtalk.reservation.domain.ReservationQueue;
import org.sopt.korailtalk.reservation.dto.ReservationCancelResponse;
import org.sopt.korailtalk.reservation.exception.ReservationErrorCode;
import org.sopt.korailtalk.reservation.repository.ReservationQueueRepository;
import org.sopt.korailtalk.train.domain.Train;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationServiceImpl implements ReservationService {
  private final ReservationQueueRepository reservationQueueRepository;

  @Override
  @Transactional
  public ReservationCancelResponse cancelReservation(Long reservationId) {
    ReservationQueue reservation = reservationQueueRepository.findById(reservationId)
        .orElseThrow(() -> new BusinessException(ReservationErrorCode.RESERVATION_NOT_FOUND));

    // 좌석 수 복구
    Train train = reservation.getTrain();

    // TODO: feat/#5 머지 되면 주석 해제하기
    // train.increaseRemainingSeat(reservation.getSeatType());

    reservationQueueRepository.delete(reservation);

    return ReservationCancelResponse.of(reservationId);
  }
}
