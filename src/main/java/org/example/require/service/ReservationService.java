package org.example.require.service;

import lombok.RequiredArgsConstructor;
import org.example.require.domain.Payment;
import org.example.require.domain.Reservation;
import org.example.require.domain.Seat;
import org.example.require.domain.User;
import org.example.require.repository.PaymentRepository;
import org.example.require.repository.ReservationRepository;
import org.example.require.repository.SeatRepository;
import org.example.require.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final SeatRepository seatRepository;
    private final PaymentRepository paymentRepository;

    public void createReservation(Long userId, Long seatId,
                                  LocalDateTime startTime,
                                  LocalDateTime endTime,
                                  int amount) {
        // 사용자 조회
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 회원입니다."));

        // 좌석 조회
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(()-> new IllegalArgumentException("좌석이 없습니다."));

        // 시간 겹침 체크
        boolean exists = reservationRepository
                .existsBySeatAndStartTimeLessThanAndEndTimeGreaterThan(
                        seat, endTime, startTime);

        // 예약 생성
        Reservation reservation = new Reservation(user, seat, startTime, endTime);
        reservationRepository.save(reservation);

        // 결제 생성
        Payment payment = new Payment(reservation, amount);
        paymentRepository.save(payment);
    }
}
