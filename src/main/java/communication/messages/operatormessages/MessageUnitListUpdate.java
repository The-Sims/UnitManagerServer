package communication.messages.operatormessages;

import java.util.ArrayList;

public class MessageUnitListUpdate {
    ArrayList<String[]> unitIds=new ArrayList<>();

    public MessageUnitListUpdate(ArrayList<String[]> unitIds){
        this.unitIds=unitIds;
    }

    public ArrayList<String[]> getUnitIds() {
        return unitIds;
    }
}
