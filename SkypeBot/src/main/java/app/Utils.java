package app;

import com.samczsun.skype4j.chat.Chat;
import com.samczsun.skype4j.chat.GroupChat;
import com.samczsun.skype4j.exceptions.ConnectionException;
import com.samczsun.skype4j.user.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by joschinc on 7/30/17.
 */
public class Utils {

    public static void sendMessage(Chat chat, String message) {
        try {
            chat.sendMessage(message);
        } catch (ConnectionException e) {
            e.printStackTrace();
            System.out.println("Error on sending message!");
        }
    }

    public static void sendMessage(GroupChat groupChat) {
        try {
            groupChat.sendMessage("Lista de Jugadores :P");
            groupChat.sendMessage(groupChat.getAllUsers().toString());

        } catch (ConnectionException e) {
            e.printStackTrace();
            System.out.println("Error on sending message!");
        }
    }


    public static void readList(GroupChat groupChat, Map<User, String> map) {
        try {
            int i = 0;
            String groupList = "# Convocatoria Oficial #";
            for (Map.Entry<User, String> entry : map.entrySet())
            {
                System.out.println("User: " + entry.getKey() + " Date: " + entry.getValue());
                groupList += "\n" + (i + 1) + ". " +  entry.getKey().getDisplayName() + " " + entry.getValue().toString();
            }
            groupChat.sendMessage(groupList);
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
    }
}
