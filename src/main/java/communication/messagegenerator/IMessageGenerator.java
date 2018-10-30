package communication.messagegenerator;

import communication.messages.sharedmessages.MessageOrder;

import java.util.ArrayList;

public interface IMessageGenerator {
    void sendOrder(ArrayList<String> unitId, MessageOrder order);
    void sendUnitListUpdate(ArrayList<String[]> units);
}
