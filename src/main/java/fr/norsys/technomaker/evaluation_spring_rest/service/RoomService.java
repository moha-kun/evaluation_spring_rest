package fr.norsys.technomaker.evaluation_spring_rest.service;

import fr.norsys.technomaker.evaluation_spring_rest.entities.Room;
import fr.norsys.technomaker.evaluation_spring_rest.exceptions.InvalidDateTimeRangeException;
import fr.norsys.technomaker.evaluation_spring_rest.repositories.ReservationRepository;
import fr.norsys.technomaker.evaluation_spring_rest.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService implements IRoomService {

    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    @Override
    public List<Room> findAvailableRoomsForRange(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        if (endDateTime.isBefore(startDateTime))
            throw new InvalidDateTimeRangeException("The start date and time " + startDateTime +
                    " should be after the end date and time " + endDateTime);
        List<Room> rooms = roomRepository.getAvailableRoomsForRangeDate(startDateTime, endDateTime);
        return rooms;
    }

}
