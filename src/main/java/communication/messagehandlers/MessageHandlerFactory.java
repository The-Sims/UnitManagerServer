package communication.messagehandlers;


import clienthandler.IClientHandler;

public class MessageHandlerFactory implements IMessageHandlerFactory {

    public IMessageHandler getHandler(String simpleType, Object handlerIn) {
        IClientHandler handler = (IClientHandler) handlerIn;

        switch(simpleType){
            case "MessageConcludeOrder":
                return new MessageConcludeOrderHandler(handler);
            case "MessageConfirmOrder":
                return new MessageConfirmOrderHandler(handler);
            case "MessageOrder":
                return new MessageOrderHandler(handler);
            case "MessageRegister":
                return new MessageRegisterHandler(handler);
            default:
                return null;
        }
    }
}
