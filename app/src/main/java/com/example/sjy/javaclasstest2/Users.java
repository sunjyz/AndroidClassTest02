package com.example.sjy.javaclasstest2;

import org.litepal.crud.DataSupport;

/**
 * Created by sjy on 2018/3/21.
 */

public class Users extends DataSupport{
    private String Username;
    private String Password;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
