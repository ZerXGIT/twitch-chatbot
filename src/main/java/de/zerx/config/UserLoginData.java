package de.zerx.config;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;

/**
 * Created by Till O. aka. ZerX
 * <p>
 * Project name: Twitchbot(1)
 * This file is created at 19.05.2021 15:35
 */
public class UserLoginData {

    /*
    User-name: Kenexarbot

    Client Login information!
     */

    public static String ClientID;
    public static String ClientSecret;
    public static OAuth2Credential credential;

    static {
        ClientID = "74ne4w6ijxkgscc11qvgftll0da4vx";
        ClientSecret = "uvkga2jx58jfs4xx5wxto7rfr9y1wv";
        credential = new OAuth2Credential("twitch", "5d2vmtc6ydl39bgocu9096rjt8r6gq");
    }
}