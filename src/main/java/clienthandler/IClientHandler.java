package clienthandler;

import communication.messages.unitmessages.MessageConfirmOrder;
import communication.messages.unitmessages.MessageOrder;
import communication.messages.unitmessages.MessageConcludeOrder;

public interface IClientHandler {
    void order(String sessionId, MessageOrder message);
    void confirmOrder(String sessionId, MessageConfirmOrder message);
    void register(String sessionId, String unitName);
    void concludeOrder(String sessionId, MessageConcludeOrder message);


}
