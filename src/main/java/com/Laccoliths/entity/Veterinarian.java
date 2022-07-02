package com.Laccoliths.entity;

/**
 * @author Laccoliths
 */
public class Veterinarian {
    private String workNumber;
    private String name;
    private String gender;
    private String telephone;
    private String speciality;

    public Veterinarian(String workNumber, String name, String gender, String telephone, String speciality) {
        this.workNumber = workNumber;
        this.name = name;
        this.gender = gender;
        this.telephone = telephone;
        this.speciality = speciality;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
