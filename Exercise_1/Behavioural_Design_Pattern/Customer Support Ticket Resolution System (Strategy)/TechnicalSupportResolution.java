
/**
 * Implements the resolution strategy for technical support tickets.
 */
public class TechnicalSupportResolution implements TicketResolutionStrategy {

    @Override
    public void resolveTicket(Ticket ticket) {
        Logger.getInstance().info("Resolving technical support ticket: " + ticket.getDescription());
        // Simulated technical support resolution process
        System.out.println("Technical support issue resolved for ticket: " + ticket.getId());
    }
}
