package communication.messagehandlers;

import clienthandler.IClientHandler;
import communication.messages.operatormessages.MessageOrderOperator;
import communication.messages.unitmessages.MessageOrder;

public class MessageOrderOperatorHandler extends MessageHandler<MessageOrderOperator> {

    public MessageOrderOperatorHandler(IClientHandler handler){super(handler);}

    @Override
    public void handleMessageInternal(MessageOrderOperator message, String sessionId) {
        getHandler().order(sessionId, message);
    }
}
