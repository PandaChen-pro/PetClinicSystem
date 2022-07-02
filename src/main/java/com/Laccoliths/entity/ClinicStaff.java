package com.Laccoliths.entity;

/**
 * @author Laccoliths
 */
public class ClinicStaff {
    private String number;
    private String name;
    private String gender;
    private String telephone;
    private String username;
    private String password;

    public ClinicStaff(String number, String name, String gender, String telephone, String username, String password) {
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.telephone = telephone;
        this.username = username;
        this.password = password;
    }

    public ClinicStaff(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
