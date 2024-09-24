
/**
 * Ticket class representing a customer support ticket.
 */
public class Ticket {

    private final int id;
    private final String description;
    private final String type; // Can be "Technical", "Billing", or "General"

    public Ticket(int id, String description, String type) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Ticket description cannot be null or empty.");
        }
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Ticket type cannot be null or empty.");
        }
        this.id = id;
        this.description = description;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}
