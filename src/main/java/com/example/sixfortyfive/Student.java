package com.example.sixfortyfive;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String telephoneNumber;
    private String email;
    private String surveyDate;
    @ElementCollection
    private List<String> campusLikes;
    private String interestedIn;
    private String recommendation;
    private String comments;

}
