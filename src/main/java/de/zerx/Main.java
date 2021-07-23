package de.zerx;

import de.zerx.handler.ClientHandler;
import de.zerx.handler.UserHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class Main {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(Main.class);

       public static void main(String[] args) {

        String Spacer = "                                                                            ";


        System.out.println(Spacer + " _   __ _____ _   _  _______   __  ___  ______ _           _   \n" +
                Spacer + "| | / /|  ___| \\ | ||  ___\\ \\ / / / _ \\ | ___ \\ |         | |  \n" +
                Spacer + "| |/ / | |__ |  \\| || |__  \\ V / / /_\\ \\| |_/ / |__   ___ | |_ \n" +
                Spacer + "|    \\ |  __|| . ` ||  __| /   \\ |  _  ||    /| '_ \\ / _ \\| __|\n" +
                Spacer + "| |\\  \\| |___| |\\  || |___/ /^\\ \\| | | || |\\ \\| |_) | (_) | |_ \n" +
                Spacer + "\\_| \\_/\\____/\\_| \\_/\\____/\\/   \\/\\_| |_/\\_| \\_|_.__/ \\___/ \\__|\n" +
                Spacer + "                                                               \n" +
                Spacer + "                Programmed by Till O. aka. ZerX                                              \n ");

        UserHandler UserHandler = new UserHandler();

        UserHandler.addUser("ZerXDElive", "6f1vqycesr8zk95zp9arttufiokaxc");
        //UserHandler.addUser("andredelive", "9bjvabolae4o6uk787rglqrl1a56y3");

        ClientHandler clienthandler = new ClientHandler();
        clienthandler.init();
        clienthandler.registerStreamer();
        clienthandler.registerEvents();

        // BrodcastMessages br = new BrodcastMessages();
    }


}

