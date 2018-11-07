package communication.messages.operatormessages;

import models.Unit;

import java.util.ArrayList;

public class MessageUnitListUpdate {
    ArrayList<Unit> unitIds=new ArrayList<>();

    public MessageUnitListUpdate(ArrayList<Unit> unitIds){
        this.unitIds=unitIds;
    }

    public ArrayList<Unit> getUnitIds() {
        return unitIds;
    }
}
