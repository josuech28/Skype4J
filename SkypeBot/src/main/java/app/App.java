package app;

import com.samczsun.skype4j.Skype;
import com.samczsun.skype4j.SkypeBuilder;
import com.samczsun.skype4j.exceptions.ConnectionException;
import com.samczsun.skype4j.exceptions.InvalidCredentialsException;
import com.samczsun.skype4j.exceptions.NotParticipatingException;

/**
 * Created by joschinc on 7/30/17.
 */
public class App {
    public static void main(String[] args) {
        new App();
    }

    public App() {
        String userName = "";
        String password = "";
        Skype skype = new SkypeBuilder(userName, password).withAllResources().build();
        try {
            skype.login();
        } catch (InvalidCredentialsException e) {
            e.printStackTrace();
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (NotParticipatingException e) {
            e.printStackTrace();
        }

        registerEvents(skype);

        try{
            skype.subscribe();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("User " + skype.getUsername() + " is loggin!");
    }

    private void registerEvents(Skype skype) {
        skype.getEventDispatcher().registerListener(new UserGroup());
    }

}
