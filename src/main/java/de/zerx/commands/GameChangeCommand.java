package de.zerx.commands;

import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import com.github.twitch4j.helix.domain.ChannelInformation;
import com.github.twitch4j.helix.domain.Game;
import com.github.twitch4j.helix.domain.ModeratorList;
import de.zerx.handler.ClientHandler;
import de.zerx.handler.UserHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Till O. aka. ZerX
 * <p>
 * Project name: Twitchbot(1)
 * This file is created at 22.05.2021 15:48
 */
public class GameChangeCommand {

    TwitchClient tc;

    public GameChangeCommand(SimpleEventHandler simple, TwitchClient tc) {
        simple.onEvent(ChannelMessageEvent.class, this::onChannelMessageEvent);
        this.tc = tc;
    }

    public void onChannelMessageEvent(ChannelMessageEvent event) {
        if (event.getMessage().startsWith("!game")) {

            String ChannelName = event.getChannel().getName();

            UserHandler ush = new UserHandler();
            event.getUser();

            List<String> modlist = new ArrayList<>();
            ModeratorList moderatorList = tc.getHelix().getModerators(ush.getToken(ChannelName), event.getChannel().getId(), null, null).execute();

            moderatorList.getModerators().forEach(str -> modlist.add(str.getUserName().toLowerCase(Locale.ROOT)));

            if (modlist.contains(event.getUser().getName()) || event.getUser().getName().equals(ChannelName)) {
                try {
                    String inputeString = event.getMessage().substring(6);
                    List<Game> result = ClientHandler.TwitchClient.getHelix().searchCategories(ush.getToken(ChannelName), inputeString, 1, null).execute().getResults();

                    if (result != null) {
                        Game game = result.get(0);
                        tc.getHelix().updateChannelInformation(ush.getToken(ChannelName), event.getChannel().getId(), new ChannelInformation().withGameId(game.getId())).execute();
                        event.getTwitchChat().sendMessage(ChannelName, "@" + event.getUser().getName() + " -> Das Game wurde auf: " + game.getName() + " gesetzt.");
                    } else {
                        event.getTwitchChat().sendMessage(ChannelName, "@" + event.getUser().getName() + " -> Fehler: Das Game konnte nicht gefunden werden.");
                    }
                } catch (IndexOutOfBoundsException ex) {
                    event.getTwitchChat().sendMessage(ChannelName, "@" + event.getUser().getName() + " -> Fehler: Du hast kein Game angegeben!");
                }
            }
        }
    }
}