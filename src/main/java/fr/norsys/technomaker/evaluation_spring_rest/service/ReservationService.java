package fr.norsys.technomaker.evaluation_spring_rest.service;

import fr.norsys.technomaker.evaluation_spring_rest.entities.Reservation;
import fr.norsys.technomaker.evaluation_spring_rest.entities.Room;
import fr.norsys.technomaker.evaluation_spring_rest.exceptions.InvalidDateTimeRangeException;
import fr.norsys.technomaker.evaluation_spring_rest.exceptions.RoomNotAvailableException;
import fr.norsys.technomaker.evaluation_spring_rest.exceptions.RoomNotFoundException;
import fr.norsys.technomaker.evaluation_spring_rest.repositories.ReservationRepository;
import fr.norsys.technomaker.evaluation_spring_rest.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReservationService implements IReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    @Override
    public String reserveRoom(long idRoom, Reservation reservation) {
        LocalDateTime startDateTime = reservation.getReservationStartDateTime();
        LocalDateTime endDateTime = reservation.getReservationEndDateTime();
        if (endDateTime.isBefore(startDateTime))
            throw new InvalidDateTimeRangeException("The start date and time " + startDateTime +
                    " should be after the end date and time " + endDateTime);
        Room room = roomRepository.findById(idRoom)
                .orElseThrow(() -> new RoomNotFoundException("There is no room with such ID"));
        if (!roomRepository.isRoomAvailableForRangeDate(idRoom, startDateTime, endDateTime))
            throw new RoomNotAvailableException("The room is not available for this range");
        room.addReservation(reservation);
        reservation.setRoom(room);
        reservationRepository.save(reservation);
        return "Done!";
    }

}
