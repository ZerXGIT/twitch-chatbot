package de.zerx.userhandler;

import java.util.ArrayList;

/**
 * Created by Till O. aka. ZerX
 * <p>
 * Project name: Twitchbot(1)
 * This file is created at 05.06.2021 23:20
 */
public class UserObject {

    public static ArrayList<UserObject> Users = new ArrayList<>();
    String Name;
    String Token;

    public UserObject(String Name, String Token) {
        this.Name = Name;
        this.Token = Token;
    }

    public UserObject() {
    }

    public void addUser() {
        Users.add(new UserObject(Name, Token));
    }

    public void addUser(String Name, String Token) {
        Users.add(new UserObject(Name, Token));
    }

    public ArrayList<UserObject> getUsers() {
        return Users;
    }

    public String getName() {
        return Name;
    }

    public String getToken() {
        return Token;
    }

    public String getToken(String Name) throws NullPointerException {
        for (UserObject user : Users) {
            if (user.getName().equalsIgnoreCase(Name)) return user.getToken();
        }
        return null;
    }


}
