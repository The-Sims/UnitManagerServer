package communication.messages.operatormessages;

import communication.messages.unitmessages.MessageOrder;
import models.Unit;

import java.util.ArrayList;

public class MessageOrderOperator {
    ArrayList<Unit> units;
    int orderId;
    String incidentTitle;
    String location;

    public MessageOrderOperator(ArrayList<Unit> units, int orderId, String incidentTitle, String location){
        this.units=units;
        this.orderId=orderId;
        this.incidentTitle=incidentTitle;
        this.location=location;
    }

    public ArrayList<Unit> getUnits() {
        return units;
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

    public MessageOrder convertToUnitMessage(String operatorId){
        return new MessageOrder(operatorId, orderId, incidentTitle, location);
    }
}
