package com.charts.main.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    private String uid;
    private String balance;
    private Integer age;
    private String eyeColor;
    private String name;
    private String gender;
    private String company;
    private String email;
    private String phone;
    private String address;
    private String favoriteSport;
    @Column(length=1000)
    private String about;
    private String registered;
    private String greeting;
    private String favoriteFruit;
    @ElementCollection
    private List<String> courses;
}
