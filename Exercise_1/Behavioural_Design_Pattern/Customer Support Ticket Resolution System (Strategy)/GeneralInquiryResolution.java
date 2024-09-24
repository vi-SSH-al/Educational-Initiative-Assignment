
/**
 * Implements the resolution strategy for general inquiry tickets.
 */
public class GeneralInquiryResolution implements TicketResolutionStrategy {

    @Override
    public void resolveTicket(Ticket ticket) {
        Logger.getInstance().info("Resolving general inquiry ticket: " + ticket.getDescription());
        // Simulated general inquiry resolution process
        System.out.println("General inquiry resolved for ticket: " + ticket.getId());
    }
}
