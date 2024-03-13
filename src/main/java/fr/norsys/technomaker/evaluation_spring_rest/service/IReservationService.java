package fr.norsys.technomaker.evaluation_spring_rest.service;

import fr.norsys.technomaker.evaluation_spring_rest.entities.Reservation;

public interface IReservationService {
    String reserveRoom(long idRoom, Reservation reservation);
}
