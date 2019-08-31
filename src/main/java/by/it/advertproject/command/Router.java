package by.it.advertproject.command;

/**
 * This class contains path for redirect or forward,
 * and type of transmission.
 */
public class Router {

    private String path;

    private TransmissionType transmissionType;

    public Router(String path, TransmissionType transmissionType) {
        this.path = path;
        this.transmissionType = transmissionType;
    }

    public String getPath() {
        return path;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }
}

