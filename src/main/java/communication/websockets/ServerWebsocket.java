package communication.websockets;

import communication.messages.EncapsulatingMessage;
import communication.messages.unitmessages.MessageConcludeOrder;
import communication.messages.unitmessages.MessageConfirmOrder;
import communication.messages.unitmessages.MessageOrder;
import communication.messages.unitmessages.MessageRegister;
import logger.LogLevel;
import logger.Logger;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;

@ServerEndpoint(value="/unitmanagerserver/websocket/")
public class ServerWebsocket extends WebsocketBase implements IServerWebsocket {

    private static ArrayList<Session> sessions = new ArrayList<>();

    @OnOpen
    public void onConnect(Session session) {
        sessions.add(session);
        Logger.getInstance().log("[Connected] SessionID:" + session.getId(), LogLevel.INFORMATION);
    }

    @OnMessage
    public void onText(String message, Session session) {
        String sessionId = session.getId();
        Logger.getInstance().log(sessionId + " send: " + message, LogLevel.RECEIVEDMESSAGE);
        EncapsulatingMessage msg = getGson().fromJson(message, EncapsulatingMessage.class);
        getHandler().processMessage(sessionId, msg.getMessageType(), msg.getMessageData());
    }

    @OnClose
    public void onClose(CloseReason reason, Session session) {
        sessions.remove(session);
        Logger.getInstance().log("[Disconnected] SessionID:" + session.getId(), LogLevel.INFORMATION);
        getHandler().processMessage(session.getId(), "disconnect", "disconnect");
    }

    @OnError
    public void onError(Throwable cause, Session session) {
        Logger.getInstance().log(cause.getMessage(), LogLevel.ERROR);
    }

    public void sendTo(String sessionId, Object object)
    {
        String msg = getEncapsulatingMessageGenerator().generateMessageString(object);
        Logger.getInstance().log("sending message: " + msg, LogLevel.INFORMATION);
        Logger.getInstance().log("to id: " + sessionId, LogLevel.INFORMATION);
        sendToClient(getSessionFromId(sessionId), msg);
    }

    @Override
    public void stop() {}

    @Override
    public void start() {}

    public Session getSessionFromId(String sessionId)
    {
        for(Session s : sessions)
        {
            if(s.getId().equals(sessionId))
                return s;
        }
        return null;
    }

    public void broadcast(Object object)
    {
        for(Session session : sessions) {
            sendTo(session.getId(), object);
        }
    }

    public void sendToGroup(String[] sessionIds, Object object)
    {
        for (String sessionId : sessionIds){
            for(Session ses : sessions) {
                if(ses.getId().equals(sessionId))
                    sendTo(ses.getId(), object);
            }
        }
    }

    private void sendToClient(Session session, String message)
    {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            Logger.getInstance().log(e);
        }
    }
}
