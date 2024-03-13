package fr.norsys.technomaker.evaluation_spring_rest.exceptions;

public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException(String message) {
        super(message);
    }
}
