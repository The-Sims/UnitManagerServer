package communication.messagehandlers;

import clienthandler.IClientHandler;
import communication.messages.unitmessages.MessageConfirmOrder;

public class MessageConfirmOrderHandler extends MessageHandler<MessageConfirmOrder>{

    public MessageConfirmOrderHandler(IClientHandler handler){super(handler);}

    @Override
    public void handleMessageInternal(MessageConfirmOrder message, String sessionId) {
        getHandler().confirmOrder(sessionId, message);
    }
}
