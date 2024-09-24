
import java.util.Random;

/**
 * Simulates stock price changes for demonstration purposes with adjustable
 * interval.
 */
public class StockPriceSimulator {

    private StockPriceTracker tracker;
    private Random random = new Random();
    private int interval = 2000; // Default update interval in milliseconds

    public StockPriceSimulator(StockPriceTracker tracker) {
        this.tracker = tracker;
    }

    /**
     * Allows setting the interval between stock price updates.
     */
    public void setInterval(int seconds) {
        this.interval = seconds * 1000;
    }

    public void start() {
        new Thread(() -> {
            while (true) {
                try {
                    // Simulate a new random stock price
                    double newPrice = 100 + (random.nextDouble() * 100);
                    tracker.updateStockPrice(newPrice);

                    // Wait for the defined interval before the next update
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    Logger.getInstance().error("Simulator interrupted: " + e.getMessage());
                }
            }
        }).start();
    }
}
