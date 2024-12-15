package main.main.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "data")
public class DataofCusEntity {
    @Id
    private Long id; 
    private String fullName;
    private String unit;
    private String country;
    private String tripPurpose;
    private String jobTitle;
    private boolean selfFunded;
    private String sponsor;
    private String hospital;
    private String hdBc;
    private String invitationUnit;
    private String doan;
    private String partyMember;
    private int foreignTripCount;
    private String notificationNumber;
    private String notificationDate;
    private String city;
    private String startDate;
    private String endDate;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getTripPurpose() {
        return tripPurpose;
    }
    public void setTripPurpose(String tripPurpose) {
        this.tripPurpose = tripPurpose;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public boolean isSelfFunded() {
        return selfFunded;
    }
    public void setSelfFunded(boolean selfFunded) {
        this.selfFunded = selfFunded;
    }
    public String getSponsor() {
        return sponsor;
    }
    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }
    public String getHospital() {
        return hospital;
    }
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
    public String getHdBc() {
        return hdBc;
    }
    public void setHdBc(String hdBc) {
        this.hdBc = hdBc;
    }
    public String getInvitationUnit() {
        return invitationUnit;
    }
    public void setInvitationUnit(String invitationUnit) {
        this.invitationUnit = invitationUnit;
    }
    public String getDoan() {
        return doan;
    }
    public void setDoan(String doan) {
        this.doan = doan;
    }
    public String getPartyMember() {
        return partyMember;
    }
    public void setPartyMember(String partyMember) {
        this.partyMember = partyMember;
    }
    public int getForeignTripCount() {
        return foreignTripCount;
    }
    public void setForeignTripCount(int foreignTripCount) {
        this.foreignTripCount = foreignTripCount;
    }
    public String getNotificationNumber() {
        return notificationNumber;
    }
    public void setNotificationNumber(String notificationNumber) {
        this.notificationNumber = notificationNumber;
    }
    public String getNotificationDate() {
        return notificationDate;
    }
    public void setNotificationDate(String notificationDate) {
        this.notificationDate = notificationDate;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}
