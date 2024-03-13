package fr.norsys.technomaker.evaluation_spring_rest.mappers;

import fr.norsys.technomaker.evaluation_spring_rest.dtos.ReservationRequest;
import fr.norsys.technomaker.evaluation_spring_rest.entities.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public Reservation toReservation(ReservationRequest reservationRequest) {
        return Reservation.builder()
                .description(reservationRequest.description())
                .reservationStartDateTime(reservationRequest.reservationStartDateTime())
                .reservationEndDateTime(reservationRequest.reservationEndDateTime())
                .build();
    }

}
