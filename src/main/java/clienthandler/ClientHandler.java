package clienthandler;

import communication.messagegenerator.IMessageGenerator;
import communication.messages.operatormessages.MessageOrderOperator;
import communication.messages.unitmessages.MessageConfirmOrder;
import communication.messages.unitmessages.MessageOrder;
import communication.messages.unitmessages.MessageConcludeOrder;
import models.Unit;

import java.util.ArrayList;

public class ClientHandler implements IClientHandler {
    IMessageGenerator messageGenerator;
    ArrayList<Unit> units = new ArrayList<>();


    public ClientHandler(IMessageGenerator messageGenerator){this.messageGenerator=messageGenerator;}

    @Override
    public void order(String sessionId, MessageOrderOperator message) {
        ArrayList<Unit> units = message.getUnits();
        ArrayList<String> unitIds = new ArrayList<>();
        for(Unit u:units)
            unitIds.add(u.getUnitId());

        messageGenerator.sendOrder(unitIds, message.convertToUnitMessage(sessionId));
    }

    @Override
    public void confirmOrder(String sessionId, MessageConfirmOrder message) {
        int o=-1;
        for (int i = 0; i<units.size(); i++) {
            if (units.get(i).getUnitId().equals(sessionId)) {
                units.get(i).setUnitAvailability(false);
                o=i;
                i = units.size();
            }
        }
        messageGenerator.sendConfirmOrder(message.getOperatorId(), message.convertToOperatorMessage(units.get(o)));
    }

    @Override
    public void register(String sessionId, String unitName) {
        Unit unit = new Unit(sessionId, unitName, true);
        units.add(unit);
        messageGenerator.sendUnitListUpdate(units);
    }

    @Override
    public void concludeOrder(String sessionId, MessageConcludeOrder message) {

    }
}
