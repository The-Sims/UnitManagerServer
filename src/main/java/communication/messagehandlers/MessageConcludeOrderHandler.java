package communication.messagehandlers;

import clienthandler.IClientHandler;
import communication.messages.unitmessages.MessageConcludeOrder;

public class MessageConcludeOrderHandler extends MessageHandler<MessageConcludeOrder> {

    public MessageConcludeOrderHandler(IClientHandler handler){super(handler);}

    @Override
    public void handleMessageInternal(MessageConcludeOrder message, String sessionId) {
        getHandler().concludeOrder(sessionId, message);
    }
}
