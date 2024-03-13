package fr.norsys.technomaker.evaluation_spring_rest.service;

import fr.norsys.technomaker.evaluation_spring_rest.entities.Room;

import java.time.LocalDateTime;
import java.util.List;

public interface IRoomService {
    List<Room> findAvailableRoomsForRange(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
