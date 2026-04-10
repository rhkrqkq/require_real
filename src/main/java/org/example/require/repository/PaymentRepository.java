package org.example.require.repository;

import org.example.require.domain.Payment;
import org.example.require.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByReservation(Reservation reservation);
}
