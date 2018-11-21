package clienthandler;

import communication.messages.unitmessages.MessageConfirmOrder;
import communication.messages.operatormessages.MessageOrderOperator;
import communication.messages.unitmessages.MessageConcludeOrder;

public interface IClientHandler {
    void order(String sessionId, MessageOrderOperator message);
    void confirmOrder(String sessionId, MessageConfirmOrder message);
    void register(String sessionId, String unitName);
    void concludeOrder(String sessionId, MessageConcludeOrder message);
    void disconnect(String sessionId);
}
