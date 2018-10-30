package communication.messagegenerator;

import communication.messages.operatormessages.MessageUnitListUpdate;
import communication.messages.sharedmessages.MessageOrder;
import communication.websockets.IServerWebsocket;

import java.util.ArrayList;

public class MessageGenerator implements IMessageGenerator {

    private IServerWebsocket serverSocket;

    public MessageGenerator(IServerWebsocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void sendOrder(ArrayList<String> unitId, MessageOrder order) {
        String[] temp = new String[unitId.size()];
        temp = unitId.toArray(temp);
        serverSocket.sendToGroup(temp, order);
    }

    @Override
    public void sendUnitListUpdate(ArrayList<String[]> units) {
        MessageUnitListUpdate msg = new MessageUnitListUpdate(units);
        serverSocket.broadcast(msg);
    }
}
