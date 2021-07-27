package de.zerx;

import de.zerx.userhandler.UserHandler;
import de.zerx.userhandler.UserObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(Main.class);

       public static void main(String[] args) {

        String Spacer =
                "                                                                            ";

        System.out.println(Spacer + " _   __ _____ _   _  _______   __  ___  ______ _           _   \n" +
                            Spacer + "| | / /|  ___| \\ | ||  ___\\ \\ / / / _ \\ | ___ \\ |         | |  \n" +
                            Spacer + "| |/ / | |__ |  \\| || |__  \\ V / / /_\\ \\| |_/ / |__   ___ | |_ \n" +
                            Spacer + "|    \\ |  __|| . ` ||  __| /   \\ |  _  ||    /| '_ \\ / _ \\| __|\n" +
                            Spacer + "| |\\  \\| |___| |\\  || |___/ /^\\ \\| | | || |\\ \\| |_) | (_) | |_ \n" +
                            Spacer + "\\_| \\_/\\____/\\_| \\_/\\____/\\/   \\/\\_| |_/\\_| \\_|_.__/ \\___/ \\__|\n" +
                            Spacer + "                                                               \n" +
                            Spacer + "                Programmed by Till O. aka. ZerX                                              \n ");

        UserObject UserObject = new UserObject();

        UserObject.addUser("<User>", "<Twitch Token>");

        UserHandler clienthandler = new UserHandler();
        clienthandler.init();
        clienthandler.registerStreamer();
        clienthandler.registerEvents();

        // BrodcastMessages br = new BrodcastMessages();
    }


}

