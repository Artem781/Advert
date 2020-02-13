package by.it.advertproject.exception;

public class AdvertException extends Exception {
    public AdvertException(String message) {
        super(message);
    }

    public AdvertException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdvertException(Throwable cause) {
        super(cause);
    }

    public AdvertException() {
    }
}
