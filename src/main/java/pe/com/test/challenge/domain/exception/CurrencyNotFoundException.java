package pe.com.test.challenge.domain.exception;

public class CurrencyNotFoundException extends RuntimeException {

    public CurrencyNotFoundException(String message) {
        super(message);
    }

}