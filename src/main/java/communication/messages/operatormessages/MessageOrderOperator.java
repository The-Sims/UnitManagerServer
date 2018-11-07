package communication.messages.operatormessages;

import java.util.ArrayList;

public class MessageOrderOperator {
    ArrayList<String> unitIds;
    int orderId;
    String incidentTitle;
    String location;

    public MessageOrderOperator(ArrayList<String> unitIds, int orderId, String incidentTitle, String location){
        this.unitIds=unitIds;
        this.orderId=orderId;
        this.incidentTitle=incidentTitle;
        this.location=location;
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
