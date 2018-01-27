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
public class Course {
    @Id
    private String id;
    private String description;
    private Integer hours;
    @ManyToMany
    @JoinTable(
            name="COURSE_USERS",
            joinColumns=@JoinColumn(name="COURSE_ID", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="USER_ID", referencedColumnName="uid"))
    private Collection<User> users;
}
