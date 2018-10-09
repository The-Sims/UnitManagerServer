package communication.messages.sharedmessages;

import java.util.ArrayList;

public class MessageOrder {
    String operatorId;
    ArrayList<String> unitIds;
    int orderId;
    String incidentTitle;
    String location;

    public MessageOrder(String operatorId, ArrayList<String> unitIds, int orderId, String incidentTitle, String location){
        this.operatorId=operatorId;
        this.unitIds=unitIds;
        this.orderId=orderId;
        this.incidentTitle=incidentTitle;
        this.location=location;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public ArrayList<String> getUnitIds() {
        return unitIds;
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
