package de.zerx.commands;

import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;

/**
 * Created by Till O. aka. ZerX
 * <p>
 * Project name: Twitchbot(1)
 * This file is created at 19.05.2021 16:04
 */
public class DonateCommand {

    public DonateCommand(SimpleEventHandler simple) {
        simple.onEvent(ChannelMessageEvent.class, this::onChannelMessageEvent);
    }

    public void onChannelMessageEvent(ChannelMessageEvent event) {
        if (event.getMessage().equalsIgnoreCase("!")) {
            event.getTwitchChat().sendMessage(event.getChannel().getName(), "@" + event.getUser().getName() + " -> Bli bla blub");
        }
    }
}