package communication.websockets;

import communication.messages.EncapsulatingMessage;
import communication.messages.unitmessages.MessageOrder;
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
        System.out.println("[Connected] SessionID:" + session.getId());
        Logger.getInstance().log("[Connected] SessionID:" + session.getId(), LogLevel.INFORMATION);

        MessageOrder msg = new MessageOrder("derp", 666, "Testing this garbage", "here");
        sendTo(session.getId(), msg);
    }

    @OnMessage
    public void onText(String message, Session session) {
        String sessionId = session.getId();
        EncapsulatingMessage msg = getGson().fromJson(message, EncapsulatingMessage.class);
        getHandler().processMessage(sessionId, msg.getMessageType(), msg.getMessageData());
    }

    @OnClose
    public void onClose(CloseReason reason, Session session) {
        sessions.remove(session);
        Logger.getInstance().log("[Disconnected] SessionID:" + session.getId(), LogLevel.INFORMATION);
    }

    @OnError
    public void onError(Throwable cause, Session session) {
        System.out.println("[ERROR] SessionID:" + session.getId() + "ERROR: " + cause.getMessage());
        Logger.getInstance().log(cause.getMessage(), LogLevel.ERROR);
    }

    public void sendTo(String sessionId, Object object)
    {
        String msg = getEncapsulatingMessageGenerator().generateMessageString(object);
        System.out.println("Sending: " + msg);
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
                if(!ses.getId().equals(sessionId))
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
