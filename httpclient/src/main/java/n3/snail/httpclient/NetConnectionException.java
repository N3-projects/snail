package n3.snail.httpclient;

/**
 * @author N3 on 2017/3/5.
 */
public class NetConnectionException extends RuntimeException {

    public NetConnectionException(String message) {
        super(message);
    }

    public NetConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
