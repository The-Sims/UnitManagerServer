package communication.messages.operatormessages;

import java.util.ArrayList;

public class MessageUnitListUpdate {
    ArrayList<String> unitIds=new ArrayList<String>();
    ArrayList<String> unitNames=new ArrayList<String>();

    public MessageUnitListUpdate(ArrayList<String> unitIds, ArrayList<String> unitNames){
        this.unitIds=unitIds;
        this.unitNames=unitNames;
    }

    public ArrayList<String> getUnitIds() {
        return unitIds;
    }

    public ArrayList<String> getUnitNames() {
        return unitNames;
    }
}
