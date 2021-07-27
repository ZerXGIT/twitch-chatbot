package de.zerx.commands;

import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import com.github.twitch4j.helix.domain.ModeratorList;
import de.zerx.userhandler.UserObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Till O. aka. ZerX
 * <p>
 * Project name: Twitchbot(1)
 * This file is created at 19.05.2021 16:38
 */

public class TitleChangeCommand {

    TwitchClient tc;

    public TitleChangeCommand(SimpleEventHandler simple, TwitchClient twitchClient) {
        simple.onEvent(ChannelMessageEvent.class, this::onChannelMessageEvent);
        this.tc = twitchClient;
    }

    public void onChannelMessageEvent(ChannelMessageEvent event) {
        if (event.getMessage().startsWith("!title")) {

            UserObject User = new UserObject();
            String ChannelName = event.getChannel().getName();

            List<String> ModeratorNameList = new ArrayList<>();
            ModeratorList moderatorList = tc.getHelix().getModerators(User.getToken(ChannelName), event.getChannel().getId(), null, null).execute();

            moderatorList.getModerators().forEach(str -> ModeratorNameList.add(str.getUserName().toLowerCase(Locale.ROOT)));

            if (event.getUser().getName().equals(ChannelName) || ModeratorNameList.contains(event.getUser().getName())) {
                try {
                    String inputString = event.getMessage().substring(7);

                    if (inputString.length() > 141) {
                        event.getTwitchChat().sendMessage(ChannelName, "@" + event.getUser().getName() + " -> Du hast die maximale Anzahl von Zeichen überschritten!");
                        return;
                    }

                    tc.getKraken().updateTitle(User.getToken(ChannelName), event.getChannel().getId(), inputString).execute();
                    event.getTwitchChat().sendMessage(ChannelName, "@" + event.getUser().getName() + " -> Der Titel wurde auf: \"" + inputString + "\" geändert!");
                } catch (IndexOutOfBoundsException exception) {
                    event.getTwitchChat().sendMessage(ChannelName, "@" + event.getUser().getName() + " -> Fehler: Du hast kein Titel angegeben!");
                }
            }
        }
    }
}