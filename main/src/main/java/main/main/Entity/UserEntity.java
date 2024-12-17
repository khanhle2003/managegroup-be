package main.main.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@Entity
@Table(name = "dtb1")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "user_display_name", nullable = false)
    private String UserDisplayName;

    @Column(name = "about_me", nullable = true)
    private String AboutMe;

    @Column(name = "views", nullable = false)
    private int Views;

    @Column(name = "topic_counts", nullable = false)
    private int TopicCounts;

    @Column(name = "Password", nullable = false)
    private String Password;

    @Column(name = "creation_date", nullable = false)
    private String CreationDate;

    @Column(name = "role", nullable = false)
    private String Role;


    public UserEntity(String Email, String userDisplayName, String aboutMe, int views,int topicCounts, String password, String creationDate, String role){
        email = Email;
        UserDisplayName = userDisplayName;
        AboutMe = aboutMe;
        Views = views;
        TopicCounts = topicCounts;
        Password = password;
        CreationDate = creationDate;
        Role = role;
    }
}
