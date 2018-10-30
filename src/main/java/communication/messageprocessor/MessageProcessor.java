package communication.messageprocessor;

import clienthandler.IClientHandler;
import communication.messagehandlers.IMessageHandler;
import communication.messagehandlers.IMessageHandlerFactory;

import java.util.ArrayList;

public class MessageProcessor extends MessageProcessorBase {

    private IClientHandler handler;

    public void processMessage(String sessionId, String type, String data){

        String simpleType = type.split("\\.")[type.split("\\.").length - 1];

        IMessageHandler handler = getMessageHandlerFactory().getHandler(simpleType, getHandler());
        handler.handleMessage(data, sessionId, getGson());
    }

    public MessageProcessor(IMessageHandlerFactory messageHandlerFactory, IClientHandler handler)
    {
        super(messageHandlerFactory);
        this.handler = handler;
    }

    public IClientHandler getHandler(){
        return handler;
    }
}
