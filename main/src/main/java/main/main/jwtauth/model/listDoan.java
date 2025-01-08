package main.main.jwtauth.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

    @Column(name = "hd_bc")
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
    private Date birthDate;

    @Column(name = "Gender")
    private String gender;

    @Column(name ="phoneNumber")
    private String phoneNumber;

    @Column(name = "Position")
    private String position;

}