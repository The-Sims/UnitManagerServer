package communication.messages.unitmessages;

import communication.messages.operatormessages.MessageConfirmOrderOperator;
import logger.LogLevel;
import logger.Logger;
import models.Unit;

public class MessageConfirmOrder {

    String operatorId;
    int orderId;
    String reason;
    boolean accepted;

    public MessageConfirmOrder(String operatorId, int orderId, String reason, boolean accepted){
        this.operatorId=operatorId;
        this.orderId=orderId;
        this.reason=reason;
        this.accepted=accepted;
    }

    public String getOperatorId() {return operatorId;}
    public int getOrderId(){return orderId;}
    public String getReason() {return reason;}
    public boolean isAccepted(){return accepted;}

    public MessageConfirmOrderOperator convertToOperatorMessage(Unit unit){
        Logger.getInstance().log("converter?", LogLevel.FATAL);
        return new MessageConfirmOrderOperator(unit, orderId, reason, accepted);
    }
}
