
/**
 * Observer interface for receiving stock price updates.
 */
public interface StockObserver {

    void updatePrice(String stockSymbol, double newPrice);
}
