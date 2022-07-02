package com.Laccoliths.entity;

/**
 * @author MSI
 */
public class SystemAdmin {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SystemAdmin(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    private String name;
    private String username;
    private String password;


    public SystemAdmin( String username, String password) {

        this.username = username;
        this.password = password;

    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
