package communication.messagegenerator;

import communication.messages.sharedmessages.MessageOrder;

public interface IMessageGenerator {
    void sendKill(String playerId);
    void sendOrder(String unitId, MessageOrder order);
    void sendUnitListUpdate(String )
}
