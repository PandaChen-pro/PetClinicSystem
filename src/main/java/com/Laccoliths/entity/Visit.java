package com.Laccoliths.entity;

/**
 * @author Laccoliths
 */
public class Visit {

    private String staffId;

    private String petId;

    private String clientId;
    private String date;

    private String receptionStaffNumber;

    private String staffName;

    public Visit(String staffName, String petName, String petVariety, String clientName, String visitTime, String receptionStaffName) {
        this.staffName = staffName;
        this.petName = petName;
        this.petVariety = petVariety;
        this.clientName = clientName;
        this.visitTime = visitTime;
        this.receptionStaffName = receptionStaffName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetVariety() {
        return petVariety;
    }

    public void setPetVariety(String petVariety) {
        this.petVariety = petVariety;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getReceptionStaffName() {
        return receptionStaffName;
    }

    public void setReceptionStaffName(String receptionStaffName) {
        this.receptionStaffName = receptionStaffName;
    }

    private String petName;
    private String petVariety;
    private String clientName;
    private String visitTime;
    private String receptionStaffName;

    public Visit( String staffId, String petId, String clientId, String date,String receptionStaffNumber) {
        this.staffId = staffId;
        this.petId = petId;
        this.clientId = clientId;
        this.date = date;
        this.receptionStaffNumber = receptionStaffNumber;
    }

    public String getReceptionStaffNumber() {
        return receptionStaffNumber;
    }

    public void setReceptionStaffNumber(String receptionStaffNumber) {
        this.receptionStaffNumber = receptionStaffNumber;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
