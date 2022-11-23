package models;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
public class User {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @OneToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;
}
