package de.zerx.handler;

import java.util.ArrayList;

/**
 * Created by Till O. aka. ZerX
 * <p>
 * Project name: Twitchbot(1)
 * This file is created at 05.06.2021 23:20
 */
public class UserHandler {

    public static ArrayList<UserHandler> Users = new ArrayList<>();
    String Name;
    String Token;

    public UserHandler(String Name, String Token) {
        this.Name = Name;
        this.Token = Token;
    }

    public UserHandler() {
    }

    public void addUser() {
        Users.add(new UserHandler(Name, Token));
    }

    public void addUser(String Name, String Token) {
        Users.add(new UserHandler(Name, Token));
    }

    public ArrayList<UserHandler> getUsers() {
        return Users;
    }

    public String getName() {
        return Name;
    }

    public String getToken() {
        return Token;
    }

    public String getToken(String Name) throws NullPointerException {
        for (UserHandler user : Users) {
            if (user.getName().equalsIgnoreCase(Name)) return user.getToken();
        }
        return null;
    }


}
