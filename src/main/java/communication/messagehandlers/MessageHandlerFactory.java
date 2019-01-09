package communication.messagehandlers;


import clienthandler.IClientHandler;
import communication.messages.operatormessages.MessageConnectAsOperator;
import logger.LogLevel;
import logger.Logger;

public class MessageHandlerFactory implements IMessageHandlerFactory {

    public IMessageHandler getHandler(String simpleType, Object handlerIn) {
        IClientHandler handler = (IClientHandler) handlerIn;
        switch(simpleType){
            case "MessageConcludeOrder":
                return new MessageConcludeOrderHandler(handler);
            case "MessageConfirmOrder":
                return new MessageConfirmOrderHandler(handler);
            case "MessageOrderOperator":
                return new MessageOrderOperatorHandler(handler);
            case "MessageRegister":
                return new MessageRegisterHandler(handler);
            case "MessageConnectAsOperator":
                return new MessageConnectAsOperatorHandler(handler);
            default:
                return null;
        }
    }
}
