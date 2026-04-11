package org.example.require.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.require.domain.enums.ReservationStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    @Builder
    public Reservation(User user, Seat seat, LocalDateTime startTime, LocalDateTime endTime) {
        this.user = user;
        this.seat = seat;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createdAt = LocalDateTime.now();
    }
}
