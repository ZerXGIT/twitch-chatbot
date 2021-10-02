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
        ClientID = "";
        ClientSecret = "";
        credential = new OAuth2Credential("twitch", "");
    }
}
