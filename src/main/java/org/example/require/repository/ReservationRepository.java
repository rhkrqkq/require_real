package org.example.require.repository;

import org.example.require.domain.Reservation;
import org.example.require.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    boolean existsBySeatAndStartTimeLessThanAndEndTimeGreaterThan(Seat seat, LocalDateTime endTime, LocalDateTime startTime);
}
