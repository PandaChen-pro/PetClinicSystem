package com.Laccoliths.entity;

/**
 * @author Laccoliths
 */
public class Pet {
    private String id;
    private String name;
    private String gender;
    private String age;
    private String varieties;
    private String symptom;
    private String isCure;
    private String clientName;
    private String doctorName;

    public Pet(String id, String name, String gender, String age, String varieties, String symptom, String isCure, String clientName, String doctorName) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.varieties = varieties;
        this.symptom = symptom;
        this.isCure = isCure;
        this.clientName = clientName;
        this.doctorName = doctorName;
    }

    public Pet(String id, String name, String varieties) {
        this.id = id;
        this.name = name;
        this.varieties = varieties;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getVarieties() {
        return varieties;
    }

    public void setVarieties(String varieties) {
        this.varieties = varieties;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getIsCure() {
        return isCure;
    }

    public void setIsCure(String isCure) {
        this.isCure = isCure;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}

