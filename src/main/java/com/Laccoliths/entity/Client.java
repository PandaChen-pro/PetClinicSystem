package com.Laccoliths.entity;

/**
 * @author Laccoliths
 */
public class Client {
    private String id;
    private String name;
    private String gender;
    private String telephone;
    private String petName;
    private String varieties;
    private String staffName;
    private String isOk;

    public String getVarieties() {
        return varieties;
    }

    public void setVarieties(String varieties) {
        this.varieties = varieties;
    }

    public Client(String id, String name, String gender, String telephone, String petName, String varieties, String staffName, String isOk) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.telephone = telephone;
        this.petName = petName;
        this.varieties = varieties;
        this.staffName = staffName;
        this.isOk = isOk;
    }

    public Client(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getIsOk() {
        return isOk;
    }

    public void setIsOk(String isOk) {
        this.isOk = isOk;
    }
}
