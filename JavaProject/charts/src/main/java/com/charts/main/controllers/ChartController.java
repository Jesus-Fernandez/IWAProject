package com.charts.main.controllers;

import com.charts.main.data.Course;
import com.charts.main.data.CourseService;
import com.charts.main.data.User;
import com.charts.main.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class ChartController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String saluda(){
        return "Hola Spring";
    }

    @RequestMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @RequestMapping("/courses/{id}")
    public Course getCourse(@PathVariable String id){
        return courseService.findOne(id);
    }

    @RequestMapping("/courses/{id}/users")
    public Collection<User> getUsersCourse(@PathVariable String id){
        return courseService.findOne(id).getUsers();
    }

    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/users/{name}")
    public User getUser(@PathVariable String name){
        return userService.findByName(name);
    }
}
