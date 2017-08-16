package app;

import com.samczsun.skype4j.chat.GroupChat;
import com.samczsun.skype4j.events.EventHandler;
import com.samczsun.skype4j.events.Listener;
import com.samczsun.skype4j.events.chat.message.MessageReceivedEvent;
import com.samczsun.skype4j.user.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by joschinc on 8/10/17.
 */
public class UserGroup implements Listener {
    private Map<User, String> userList = new LinkedHashMap<User, String>();

    @EventHandler
    public void onChatGroup(MessageReceivedEvent e) {
        try {
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date today = Calendar.getInstance().getTime();
            String reportDate = df.format(today);
            String plusOne = "+1";
            System.out.println("Message: " + e.getMessage().getContent());
            System.out.println("Usuario " + e.getMessage().getSender().getDisplayName());
            if (e.getMessage().getContent().asPlaintext().equals(plusOne)) {
                System.out.println("+1 entered!");
                userList.put(e.getMessage().getSender(), reportDate);
                Utils.readList((GroupChat) e.getChat(), userList);
            }
            if (e.getMessage().toString().equals("/limpiar-lista")) {
                userList.clear();
            }
        } catch (Exception ex) {
            System.out.println(ex.getCause());
        }
    }
}
