package communication.messagehandlers;

import clienthandler.IClientHandler;
import com.google.gson.Gson;
import logger.LogLevel;
import logger.Logger;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class MessageHandler<T> implements IMessageHandler {
    IClientHandler clientHandler;

    public MessageHandler(IClientHandler clientHandler){
        this.clientHandler = clientHandler;
    }

    public IClientHandler getHandler() {
        return clientHandler;
    }

    public void handleMessage(String data, String sessionId, Gson gson){
        Logger.getInstance().log("Handling message of type: " + getClass(), LogLevel.INFORMATION);
        Type type = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        T msg = gson.fromJson(data, type);
        handleMessageInternal(msg, sessionId);
    }

    public abstract void handleMessageInternal(T message, String sessionId);
}
