package org.example.require.repository;

import org.example.require.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    boolean findBySeatId(Long seatId);
}
