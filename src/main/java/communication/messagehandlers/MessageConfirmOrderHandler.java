package communication.messagehandlers;

import clienthandler.IClientHandler;
import communication.messages.unitmessages.MessageConfirmOrder;
import logger.LogLevel;
import logger.Logger;

public class MessageConfirmOrderHandler extends MessageHandler<MessageConfirmOrder>{

    public MessageConfirmOrderHandler(IClientHandler handler){super(handler);}

    @Override
    public void handleMessageInternal(MessageConfirmOrder message, String sessionId) {
        getHandler().confirmOrder(sessionId, message);
    }
}
