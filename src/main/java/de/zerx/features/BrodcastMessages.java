package de.zerx.features;

import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.helix.domain.StreamList;
import de.zerx.handler.ClientHandler;
import de.zerx.handler.UserHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Till O. aka. ZerX
 * <p>
 * Project name: Twitchbot(1)
 * This file is created at 19.04.2021 12:04
 */

public class BrodcastMessages {
    TwitchClient tc = ClientHandler.TwitchClient;

    //TODO: Brodcast nachrichten hinzufügen!
    String[] message = {"Holt euch BetterTwitchTV ► https://bit.ly/1xpxMNA und FrankerFaceZ ► https://bit.ly/1II1E2o für tolle Smileys und weitere Vorteile! (für die Smileys einfach gifs in bttv anmachen)", ""};
    int message_int = 0;

    public BrodcastMessages() {
        run();
    }


    public void run() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                ArrayList<UserHandler> Users = UserHandler.Users;

                for (UserHandler user : Users) {
                    //TODO: Überprüfen ob dies ding funktioniert (Online dingens)!
                    if (isStreamerOnline(user.getName())) {
                        tc.getChat().sendMessage(user.getName(), message[message_int]);
                    }
                }

                message_int++;
                if (message_int > message.length - 1) message_int = 0;

            }
        }, 0, 480000);
    }

    public boolean isStreamerOnline(String s) {
        AtomicBoolean Online = new AtomicBoolean();

        StreamList resultList = tc.getHelix().getStreams(null, null, null, null, null, null, null, Arrays.asList(s)).execute();
        resultList.getStreams().forEach(st -> {
            if (st.getUserName().equalsIgnoreCase(s)) Online.set(true);
        });

        return Online.equals(new AtomicBoolean(true));
    }

}

