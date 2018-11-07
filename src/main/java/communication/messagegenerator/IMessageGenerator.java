package communication.messagegenerator;

import communication.messages.unitmessages.MessageOrder;
import models.Unit;

import java.util.ArrayList;

public interface IMessageGenerator {
    void sendOrder(ArrayList<String> unitId, MessageOrder order);
    void sendUnitListUpdate(ArrayList<Unit> units);
}
