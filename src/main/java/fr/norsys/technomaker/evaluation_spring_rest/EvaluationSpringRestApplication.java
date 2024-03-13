package fr.norsys.technomaker.evaluation_spring_rest;

import fr.norsys.technomaker.evaluation_spring_rest.entities.Reservation;
import fr.norsys.technomaker.evaluation_spring_rest.entities.Room;
import fr.norsys.technomaker.evaluation_spring_rest.repositories.ReservationRepository;
import fr.norsys.technomaker.evaluation_spring_rest.repositories.RoomRepository;
import fr.norsys.technomaker.evaluation_spring_rest.service.IReservationService;
import fr.norsys.technomaker.evaluation_spring_rest.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.Month;

@SpringBootApplication
public class EvaluationSpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvaluationSpringRestApplication.class, args);
	}

	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	IRoomService roomService;
	@Autowired
	IReservationService reservationService;

	@Bean
	public CommandLineRunner setUp() {
		return args -> {
			Room room = new Room();
			room.setDescription("de");
			roomRepository.save(room);
			Reservation reservation = new Reservation();
			reservation.setReservationStartDateTime(LocalDateTime.of(2024, Month.MARCH, 20, 17, 30));
			reservation.setReservationEndDateTime(LocalDateTime.of(2024, Month.MARCH, 20, 20, 30));

			System.out.println(roomService.findAvailableRoomsForRange(LocalDateTime.of(2024, Month.MARCH, 20, 20, 30), LocalDateTime.of(2024, Month.MARCH, 20, 22, 30)));
			//System.out.println(reservationService.reserveRoom(1L, reservation));
			System.out.println(roomService.findAvailableRoomsForRange(LocalDateTime.of(2024, Month.MARCH, 20, 20, 30), LocalDateTime.of(2024, Month.MARCH, 20, 22, 30)));
		};
	}

}
