package fr.norsys.technomaker.evaluation_spring_rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    private static final int DESCRIPTION_MAX_LENGTH = 50;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = DESCRIPTION_MAX_LENGTH,
            message = "The length of the message should not exceed " + DESCRIPTION_MAX_LENGTH)
    private String description;
    private LocalDateTime reservationStartDateTime;
    private LocalDateTime reservationEndDateTime;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    private Room room;

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", reservationStartDateTime=" + reservationStartDateTime +
                ", reservationEndDateTime=" + reservationEndDateTime +
                '}';
    }
}
