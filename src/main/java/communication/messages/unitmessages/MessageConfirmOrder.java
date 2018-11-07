package communication.messages.unitmessages;

public class MessageConfirmOrder {

    String operatorId;
    String unitName;
    int orderId;
    String reason;
    boolean accepted;

    public MessageConfirmOrder(String operatorId, String unitName, int orderId, String reason, boolean accepted){
        this.operatorId=operatorId;
        this.unitName=unitName;
        this.orderId=orderId;
        this.reason=reason;
        this.accepted=accepted;
    }

    public String getOperatorId() {return operatorId;}
    public String getUnitName() {return unitName;}
    public int getOrderId(){return orderId;}
    public String getReason() {return reason;}
    public boolean isAccepted(){return accepted;}
}
