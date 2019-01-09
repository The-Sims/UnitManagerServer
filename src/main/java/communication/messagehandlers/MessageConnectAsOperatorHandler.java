package communication.messagehandlers;

import clienthandler.IClientHandler;
import communication.messages.unitmessages.MessageConcludeOrder;

public class MessageConnectAsOperatorHandler extends MessageHandler<MessageConcludeOrder> {

    public MessageConnectAsOperatorHandler(IClientHandler handler){super(handler);}

    @Override
    public void handleMessageInternal(MessageConcludeOrder message, String sessionId) {
        return;
    }
}
