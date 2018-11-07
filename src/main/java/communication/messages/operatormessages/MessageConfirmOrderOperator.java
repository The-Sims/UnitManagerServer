package communication.messages.operatormessages;

public class MessageConfirmOrderOperator {

    String unitId;
    String unitName;
    int orderId;
    String reason;
    boolean accepted;

    public MessageConfirmOrderOperator(String unitId, String unitName, int orderId, String reason, boolean accepted){
        this.unitId=unitId;
        this.unitName=unitName;
        this.orderId=orderId;
        this.reason=reason;
        this.accepted=accepted;
    }

    public String getUnitId() {return unitId;}
    public String getUnitName() {return unitName;}
    public int getOrderId(){return orderId;}
    public String getReason() {return reason;}
    public boolean isAccepted(){return accepted;}
}
