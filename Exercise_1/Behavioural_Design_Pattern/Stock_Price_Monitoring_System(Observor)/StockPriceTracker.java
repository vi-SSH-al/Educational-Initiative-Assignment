
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Subject class that notifies registered observers about stock price updates.
 */
public class StockPriceTracker {

    private List<StockObserver> observers = new ArrayList<>();
    private double stockPrice;
    private String stockSymbol;
    private Logger logger = Logger.getInstance();

    /**
     * Constructor to initialize stock tracker with a stock symbol.
     */
    public StockPriceTracker(String stockSymbol) {
        if (stockSymbol == null || stockSymbol.isEmpty()) {
            throw new InvalidStockSymbolException("Stock symbol cannot be null or empty.");
        }
        this.stockSymbol = stockSymbol;
        this.stockPrice = 0.0;
        logger.info("StockPriceTracker initialized for symbol: " + stockSymbol);
    }

    /**
     * Registers a new observer.
     */
    public void registerObserver(StockObserver observer) {
        Optional.ofNullable(observer).ifPresent(observers::add);
        logger.info("Observer registered.");
    }

    /**
     * Unregisters an observer.
     */
    public void unregisterObserver(StockObserver observer) {
        Optional.ofNullable(observer).ifPresent(observers::remove);
        logger.info("Observer unregistered.");
    }

    /**
     * Notifies all observers about a price update.
     */
    public void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.updatePrice(stockSymbol, stockPrice);
        }
    }

    /**
     * Updates the stock price and notifies observers.
     */
    public void updateStockPrice(double newPrice) {
        if (newPrice <= 0) {
            logger.warn("Invalid stock price received: " + newPrice);
            return;  // Defensive programming: avoid invalid updates.
        }
        this.stockPrice = newPrice;
        logger.info("Stock price updated: " + newPrice);
        notifyObservers();
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public double getStockPrice() {
        return stockPrice;
    }
}
