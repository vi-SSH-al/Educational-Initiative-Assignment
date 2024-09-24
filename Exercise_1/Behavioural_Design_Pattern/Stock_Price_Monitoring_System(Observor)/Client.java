
/**
 * A client that acts as an observer for stock price updates.
 */
public class Client implements StockObserver {

    private String clientId;
    private Logger logger = Logger.getInstance();

    public Client(String clientId) {
        if (clientId == null || clientId.isEmpty()) {
            throw new IllegalArgumentException("Client ID cannot be null or empty.");
        }
        this.clientId = clientId;
        logger.info("Client initialized with ID: " + clientId);
    }

    @Override
    public void updatePrice(String stockSymbol, double newPrice) {
        logger.info("Client " + clientId + " notified of price change for "
                + stockSymbol + ": $" + newPrice);
    }
}
