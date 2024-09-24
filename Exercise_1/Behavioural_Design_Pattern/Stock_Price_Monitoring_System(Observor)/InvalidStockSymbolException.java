
/**
 * Custom exception for invalid stock symbol input.
 */
public class InvalidStockSymbolException extends RuntimeException {

    public InvalidStockSymbolException(String message) {
        super(message);
    }
}
