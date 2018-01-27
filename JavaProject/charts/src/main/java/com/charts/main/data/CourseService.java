package com.charts.main.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        ArrayList<Course> courses = new ArrayList<Course>();
        courseRepository.findAll().forEach(courses::add);
        return  courses;
    }

    public Course findOne(String id){
        return  courseRepository.findOne(id);
    }

    public String save(Course c){
        String status = "ok";
        try {
            courseRepository.save(c);
        }catch (Exception e){
            status = e.getMessage();
        }
        return status;
    }

    public String save(List<Course> courses){
        String status = "ok";
        try {
            courseRepository.save(courses);
        }catch (Exception e){
            status = e.getMessage();
        }
        return status;
    }

    public String delete(String id){
        String status = "ok";
        try {
            courseRepository.delete(id);
        }catch (Exception e){
            status = e.getMessage();
        }
        return status;
    }

    public void addUser(String id, User user){
        Course c = courseRepository.findOne(id);
        Collection<User> collection = c.getUsers();
        collection.add(user);
        c.setUsers(collection);
        courseRepository.save(c);
    }
}
