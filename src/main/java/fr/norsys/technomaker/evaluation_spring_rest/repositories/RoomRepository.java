package fr.norsys.technomaker.evaluation_spring_rest.repositories;

import fr.norsys.technomaker.evaluation_spring_rest.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long>{

    @Query("""
            select rm from Room rm 
            where rm not in (select rs.room from Reservation rs 
                         where rs.reservationStartDateTime <= :endDateTime and rs.reservationEndDateTime >= :startDateTime
                         and rs.room is not null)
                         
            """)
    public List<Room> getAvailableRoomsForRangeDate(LocalDateTime startDateTime, LocalDateTime endDateTime);

    @Query("""
            select case when rm.id = :idRoom 
                          and rm not in (select rs.room from Reservation rs 
                                      where rs.reservationStartDateTime <= :endDateTime and rs.reservationEndDateTime >= :startDateTime
                                        and rs.room is not null) then true 
                        else false end 
            from Room rm
              """)
    public boolean isRoomAvailableForRangeDate(long idRoom, LocalDateTime startDateTime, LocalDateTime endDateTime);
}
