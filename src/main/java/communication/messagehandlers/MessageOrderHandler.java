package communication.messagehandlers;

import clienthandler.IClientHandler;
import communication.messages.unitmessages.MessageOrder;

public class MessageOrderHandler extends MessageHandler<MessageOrder> {

    public MessageOrderHandler(IClientHandler handler){super(handler);}

    @Override
    public void handleMessageInternal(MessageOrder message, String sessionId) {
        getHandler().order(sessionId, message);
    }
}
