package fr.norsys.technomaker.evaluation_spring_rest.controllers;

import fr.norsys.technomaker.evaluation_spring_rest.entities.Room;
import fr.norsys.technomaker.evaluation_spring_rest.service.IRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final IRoomService roomService;

    @GetMapping
    public List<Room> findAllRoomsForRange(
            @RequestParam(name = "startDateTime") LocalDateTime startDateTime,
            @RequestParam(name = "endDateTime") LocalDateTime endDateTime
            ) {
        return roomService.findAvailableRoomsForRange(startDateTime, endDateTime);
    }

}
