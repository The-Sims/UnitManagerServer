package communication.messages.operatormessages;

public class ConfirmOrderMessage {
    int orderId;
    String unitName;
    String reason;
    boolean isAccepted;

    public ConfirmOrderMessage(int orderId, String unitName, String reason, boolean isAccepted){
        this.orderId=orderId;
        this.unitName=unitName;
        this.reason=reason;
        this.isAccepted=isAccepted;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getReason() {
        return reason;
    }

    public String getUnitName() {
        return unitName;
    }

    public boolean isAccepted() {
        return isAccepted;
    }
}
