package app;

import com.samczsun.skype4j.chat.GroupChat;
import com.samczsun.skype4j.events.EventHandler;
import com.samczsun.skype4j.events.Listener;
import com.samczsun.skype4j.events.chat.message.MessageReceivedEvent;
import com.samczsun.skype4j.exceptions.ConnectionException;

/**
 * Created by joschinc on 7/30/17.
 */
public class UserChat implements Listener {
    @EventHandler
    public void onChat(MessageReceivedEvent e) {
        try {
            Utils.sendMessage(e.getChat(), "Hello " + e.getMessage().getSender().getDisplayName().toString() + "! Actually Josue is busy :( Try it later!");
        } catch (ConnectionException e1) {
            e1.printStackTrace();
        }
    }
    @EventHandler
    public void onChatGroup(MessageReceivedEvent e) {
        Utils.sendMessage((GroupChat) e.getChat());
    }
}

