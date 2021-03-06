package communication.messagegenerator;

import communication.messages.operatormessages.MessageConfirmOrderOperator;
import communication.messages.unitmessages.MessageConcludeOrder;
import communication.messages.unitmessages.MessageOrder;
import models.Unit;

import java.util.ArrayList;

public interface IMessageGenerator {
    void sendOrder(ArrayList<String> unitId, MessageOrder order);
    void sendUnitListUpdate(ArrayList<Unit> units);
    void sendConfirmOrder(String operatorId, MessageConfirmOrderOperator message);
    void sendConcludeOrder(MessageConcludeOrder message);
}
