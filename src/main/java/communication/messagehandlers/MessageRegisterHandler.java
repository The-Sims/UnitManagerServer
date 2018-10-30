package communication.messagehandlers;

import clienthandler.IClientHandler;
import communication.messages.unitmessages.MessageRegister;

public class MessageRegisterHandler extends MessageHandler<MessageRegister> {

    public MessageRegisterHandler(IClientHandler handler){super(handler);}

    @Override
    public void handleMessageInternal(MessageRegister message, String sessionId) {
        getHandler().register(sessionId, message.getUnitName());
    }
}
