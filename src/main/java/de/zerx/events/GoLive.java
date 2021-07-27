package de.zerx.events;

import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.events.ChannelGoLiveEvent;
import de.zerx.clienthandler.ClientHandler;

/**
 * Created by Till O. aka. ZerX
 * <p>
 * Project name: Twitchbot(1)
 * This file is created at 19.05.2021 16:31
 */
public class GoLive {

    //public static final Cache<String, Boolean> recentlyOffline = Caffeine.newBuilder().expireAfterWrite(10, TimeUnit.MINUTES).build();

    public GoLive(SimpleEventHandler simple) {
        simple.onEvent(ChannelGoLiveEvent.class, GoLive::onChannelGoLiveEvent);
    }

    public static void onChannelGoLiveEvent(ChannelGoLiveEvent event) {

        String channelName = event.getChannel().getName();

        //TODO: Bessere nachricht für live gehen!
        ClientHandler.TwitchClient.getChat().sendMessage(channelName, channelName + " ist jetzt Live!");

    }

}
