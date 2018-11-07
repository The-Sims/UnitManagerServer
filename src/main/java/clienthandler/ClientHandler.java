package clienthandler;

import communication.messagegenerator.IMessageGenerator;
import communication.messages.unitmessages.MessageConfirmOrder;
import communication.messages.unitmessages.MessageOrder;
import communication.messages.unitmessages.MessageConcludeOrder;
import models.Unit;

import java.util.ArrayList;

public class ClientHandler implements IClientHandler {
    IMessageGenerator messageGenerator;
    ArrayList<Unit> units = new ArrayList<>();


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
        Unit unit = new Unit(sessionId, unitName, true);
        units.add(unit);
        messageGenerator.sendUnitListUpdate(units);
    }

    @Override
    public void concludeOrder(String sessionId, MessageConcludeOrder message) {

    }
}
