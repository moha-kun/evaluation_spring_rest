package fr.norsys.technomaker.evaluation_spring_rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Room {

    private static final int DESCRIPTION_MAX_LENGTH = 50;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = DESCRIPTION_MAX_LENGTH,
            message = "The length of the message should not exceed " + DESCRIPTION_MAX_LENGTH)
    private String description;

    @OneToMany(mappedBy = "room",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<Reservation> reservations;

    public void addReservation(Reservation reservation) {
        if (reservations == null)
            reservations = new HashSet<>();
        reservations.add(reservation);
    }
}
