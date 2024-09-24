
/**
 * Implements the resolution strategy for billing inquiry tickets.
 */
public class BillingInquiryResolution implements TicketResolutionStrategy {

    @Override
    public void resolveTicket(Ticket ticket) {
        Logger.getInstance().info("Resolving billing inquiry ticket: " + ticket.getDescription());
        // Simulated billing inquiry resolution process
        System.out.println("Billing inquiry resolved for ticket: " + ticket.getId());
    }
}
