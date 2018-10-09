package communication.messages.unitmessages;

public class MessageConcludeOrder {

    int orderId;
    String conclusion;

    public MessageConcludeOrder(int orderId, String conclusion){
        this.orderId = orderId;
        this.conclusion=conclusion;
    }

    public int getOrderId() {return orderId;}
    public String getConclusion() {return conclusion;}
}
