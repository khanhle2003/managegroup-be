package main.main.AddData.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "FullName")
    private String FullName;
    @Column(name = "Unit")
    private String Unit;
    @Column(name = "Country")
    private String Country;
    @Column(name = "TripPurpose")
    private String TripPurpose;
    @Column(name = "JobTitle")
    private String JobTitle;
    @Column(name = "SelfFunded")
    private String SelfFunded;
    @Column(name = "Sponsor")
    private String Sponsor;
    @Column(name = "Hospital")
    private String Hospital;
    @Column(name = "InvitationUnit")
    private String InvitationUnit;
    @Column(name = "PartyMember")
    private String PartyMember;
    @Column(name = "ForeignTripCount")
    private String ForeignTripCount;
    @Column(name = "NotificationNumber")
    private String notificationNumber;
    @Column(name = "NotificationDate")
    private LocalDate notificationDate;
    @Column(name = "StartDate")
    private LocalDate StartDate;
    @Column(name = "EndDate")
    private LocalDate EndDate;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private String gender;
    @Column(name = "Position")
    private String position;
    @Column(name = "PartyBranch")
    private String partyBranch;
    @Column(name = "PartyPosition")
    private String partyPosition;
    @Column(name = "Employee")
    private String employee;
    @Column(name = "JobName")
    private String jobName;
    @Column(name = "RestCount")
    private String restCount;
    @Column(name = "Alternative")
    private String alternative;
    @Column(name = "SubmitDay")
    private String submitDay;
    @Column(name ="birthDate")
private LocalDate birthdate;


}
