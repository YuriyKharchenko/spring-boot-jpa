package ua.home.springboot.sample;

public class ProhibitionException extends RuntimeException {

    public ProhibitionException(String message) {
        super(message);
    }
}