package fr.norsys.technomaker.evaluation_spring_rest.dtos;

import java.time.LocalDateTime;

public record ReservationRequest(String description, LocalDateTime reservationStartDateTime, LocalDateTime reservationEndDateTime, Long roomId) {
}
