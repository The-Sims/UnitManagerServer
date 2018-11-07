package communication.messages.unitmessages;

import communication.messages.operatormessages.MessageOrderOperator;

import java.util.ArrayList;

public class MessageOrder {
    String operatorId;
    int orderId;
    String incidentTitle;
    String location;

    public MessageOrder(String operatorId, int orderId, String incidentTitle, String location){
        this.operatorId=operatorId;
        this.orderId=orderId;
        this.incidentTitle=incidentTitle;
        this.location=location;
    }

    public String getOperatorId() {
        return operatorId;
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
