package main.main.jwtauth.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "data")
public class listDoan {

    @Id
    private Long id;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "Unit")
    private String unit;

    @Column(name = "Country")
    private String country;

    @Column(name = "TripPurpose")
    private String tripPurpose;

    @Column(name = "JobTitle")
    private String jobTitle;

    @Column(name = "Email")
    private String email;

    @Column(name = "SelfFunded")
    private String selfFunded;

    @Column(name = "Sponsor")
    private String sponsor;

    @Column(name = "Hospital")
    private String hospital;

    @Column(name = "HD/BC")
    private String hdBc;

    @Column(name = "InvitationUnit")
    private String invitationUnit;

    @Column(name = "Doan")
    private String doan;

    @Column(name = "PartyMember")
    private String partyMember;

    @Column(name = "ForeignTripCount")
    private String foreignTripCount;

    @Column(name = "NotificationNumber")
    private String notificationNumber;

    @Column(name = "NotificationDate")
    private String notificationDate;

    @Column(name = "city")
    private String city;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "EndDate")
    private Date endDate;

    @Column(name = "BirthDate")
    private String birthDate;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Position")
    private String position;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "PartyBranch")
    private String party_branch;

    @Column(name = "PartyPosition")
    private String party_position;

    @Column(name = "Contract")
    private String contract;

    @Column(name = "Official")
    private String official;

    @Column(name = "JobName")
    private String job_name;

    @Column(name = "RestCount")
    private String rest_count;

    @Column(name = "Alternative")
    private String alternative;

    @Column(name = "SubmitDay")
    private String submit_day;

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

    public String getSelfFunded() {
        return selfFunded;
    }

    public void setSelfFunded(String selfFunded) {
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

    public String getForeignTripCount() {
        return foreignTripCount;
    }

    public void setForeignTripCount(String foreignTripCount) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPartyBranch() {
        return party_branch;
    }

    public void setPartyBranch(String party_branch) {
        this.party_branch = party_branch;
    }

    public String getPartyPosition() {
        return party_position;
    }

    public void setPartyPosition(String party_position) {
        this.party_position = party_position;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }

    public String getJobName() {
        return job_name;
    }

    public void setJobName(String job_name) {
        this.job_name = job_name;
    }

    public String getRestCount() {
        return rest_count;
    }

    public void setRestCount(String rest_count) {
        this.rest_count = rest_count;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public String getSubmitDay() {
        return submit_day;
    }

    public void setSubmitDay(String submit_day) {
        this.submit_day = submit_day;
    }
}
