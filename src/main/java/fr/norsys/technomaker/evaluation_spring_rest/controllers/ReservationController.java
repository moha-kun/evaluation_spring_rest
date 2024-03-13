package fr.norsys.technomaker.evaluation_spring_rest.controllers;

import fr.norsys.technomaker.evaluation_spring_rest.dtos.ReservationRequest;
import fr.norsys.technomaker.evaluation_spring_rest.entities.Reservation;
import fr.norsys.technomaker.evaluation_spring_rest.mappers.ReservationMapper;
import fr.norsys.technomaker.evaluation_spring_rest.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    @PostMapping
    public ResponseEntity<Void> reserveRoom(
            @RequestBody ReservationRequest reservationRequest
            ) {
        Reservation reservation = reservationMapper.toReservation(reservationRequest);
        reservationService.reserveRoom(reservationRequest.roomId(), reservation);
        return ResponseEntity.ok(null);
    }

}
