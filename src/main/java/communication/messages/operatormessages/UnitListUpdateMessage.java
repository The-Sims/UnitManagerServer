package communication.messages.operatormessages;

import java.util.ArrayList;

public class UnitListUpdateMessage {
    ArrayList<String> unitNames=new ArrayList<String>();

    public UnitListUpdateMessage(ArrayList<String> unitNames){
        this.unitNames=unitNames;
    }

    public ArrayList<String> getUnitNames() {
        return unitNames;
    }
}
