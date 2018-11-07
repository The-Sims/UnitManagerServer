package communication.messages.operatormessages;

import models.Unit;

public class MessageConfirmOrderOperator {

    Unit unit;
    int orderId;
    String reason;
    boolean accepted;

    public MessageConfirmOrderOperator(Unit unit, int orderId, String reason, boolean accepted){
        this.unit=unit;
        this.orderId=orderId;
        this.reason=reason;
        this.accepted=accepted;
    }

    public Unit getUnit() {return unit;}
    public int getOrderId(){return orderId;}
    public String getReason() {return reason;}
    public boolean isAccepted(){return accepted;}
}
