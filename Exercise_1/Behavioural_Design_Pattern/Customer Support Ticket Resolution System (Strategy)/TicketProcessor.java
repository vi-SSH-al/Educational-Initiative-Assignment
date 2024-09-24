
/**
 * Context class that processes tickets using different resolution strategies.
 */
public class TicketProcessor {

    private TicketResolutionStrategy resolutionStrategy;
    private Logger logger = Logger.getInstance();

    /**
     * Sets the resolution strategy dynamically based on the ticket type.
     */
    public void setResolutionStrategy(TicketResolutionStrategy resolutionStrategy) {
        this.resolutionStrategy = resolutionStrategy;
        logger.info("Resolution strategy set to: " + resolutionStrategy.getClass().getSimpleName());
    }

    /**
     * Resolves the ticket using the chosen strategy.
     */
    public void resolveTicket(Ticket ticket) {
        if (resolutionStrategy == null) {
            logger.error("No resolution strategy selected.");
            throw new IllegalStateException("Resolution strategy not set.");
        }
        resolutionStrategy.resolveTicket(ticket);
    }
}
