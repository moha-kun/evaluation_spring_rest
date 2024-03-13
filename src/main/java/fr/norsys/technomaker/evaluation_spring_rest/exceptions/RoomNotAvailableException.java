package fr.norsys.technomaker.evaluation_spring_rest.exceptions;

public class RoomNotAvailableException extends RuntimeException {

    public RoomNotAvailableException(String message) {
        super(message);
    }
}
