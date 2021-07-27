package de.zerx.userhandler;

import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import de.zerx.commands.DonateCommand;
import de.zerx.commands.GameChangeCommand;
import de.zerx.commands.TitleChangeCommand;
import de.zerx.config.UserLoginData;
import feign.Logger;

/**
 * Created by Till O. aka. ZerX
 * <p>
 * Project name: Twitchbot(1)
 * This file is created at 19.03.2021 16:00
 */

public class UserHandler {

    public static TwitchClient TwitchClient;

    public UserHandler() {
    }

    public void init() {
        TwitchClientBuilder clientBuilder = TwitchClientBuilder.builder();

        TwitchClient = clientBuilder
                .withChatAccount(UserLoginData.credential)
                .withClientId(UserLoginData.ClientID)
                .withClientSecret(UserLoginData.ClientSecret)
                .withEnableHelix(true)
                .withEnableKraken(true)
                .withEnableChat(true)
                .withDefaultEventHandler(SimpleEventHandler.class)
                .withFeignLogLevel(Logger.Level.FULL)
                .build();
    }

    public void registerEvents() {
        SimpleEventHandler simpleEventHandler = TwitchClient.getEventManager().getEventHandler(SimpleEventHandler.class);

        // Commands
        new DonateCommand(simpleEventHandler);
        new TitleChangeCommand(simpleEventHandler, TwitchClient);
        new GameChangeCommand(simpleEventHandler, TwitchClient);
    }

    public void registerStreamer() {
        for (UserObject user : UserObject.Users) {
            if (!(TwitchClient.getChat().isChannelJoined(user.Name))) {
                TwitchClient.getChat().joinChannel(user.getName());
            }
        }
    }
}