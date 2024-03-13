package fr.norsys.technomaker.evaluation_spring_rest.repositories;

import fr.norsys.technomaker.evaluation_spring_rest.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
