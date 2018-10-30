package clienthandler;

import communication.messagegenerator.IMessageGenerator;
import communication.messages.sharedmessages.MessageConfirmOrder;
import communication.messages.sharedmessages.MessageOrder;
import communication.messages.unitmessages.MessageConcludeOrder;

import java.util.ArrayList;

public class ClientHandler implements IClientHandler {
    IMessageGenerator messageGenerator;
    ArrayList<String[]> units = new ArrayList<>();

    public ClientHandler(IMessageGenerator messageGenerator){this.messageGenerator=messageGenerator;}

    @Override
    public void order(String sessionId, MessageOrder message) {
        ArrayList<String> sendTo = message.getUnitIds();
        messageGenerator.sendOrder(sendTo, message);
    }

    @Override
    public void confirmOrder(String sessionId, MessageConfirmOrder message) {

    }

    @Override
    public void register(String sessionId, String unitName) {
        String[] unit = {sessionId, unitName};
        units.add(unit);
    }

    @Override
    public void concludeOrder(String sessionId, MessageConcludeOrder message) {

    }
}
