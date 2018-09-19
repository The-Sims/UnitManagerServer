package communication.messages.unitmessages;

public class OrderMessage {
    int orderId;
    String incidentTitle;
    String location;

    public OrderMessage(int orderId, String incidentTitle, String location){
        this.orderId=orderId;
        this.incidentTitle=incidentTitle;
        this.location=location;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getIncidentTitle() {
        return incidentTitle;
    }

    public String getLocation() {
        return location;
    }
}
