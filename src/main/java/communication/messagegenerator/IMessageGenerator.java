package communication.messagegenerator;

import communication.messages.sharedmessages.MessageOrder;

import java.util.ArrayList;

public interface IMessageGenerator {
    void sendKill(String playerId);
    void sendOrder(ArrayList<String> unitId, MessageOrder order);
    void sendUnitListUpdate(String )
}
