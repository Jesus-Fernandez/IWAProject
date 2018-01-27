package com.charts.main.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        ArrayList<User> courses = new ArrayList<User>();
        userRepository.findAll().forEach(courses::add);
        return  courses;
    }

    public User findOne(String id){
        return  userRepository.findOne(id);
    }

    public User findByName(String name){
        return  userRepository.findUserByName(name);
    }

    public String save(User c){
        String status = "ok";
        try {
            userRepository.save(c);
        }catch (Exception e){
            status = e.getMessage();
        }
        return status;
    }

    public String save(List<User> courses){
        String status = "ok";
        try {
            userRepository.save(courses);
        }catch (Exception e){
            status = e.getMessage();
        }
        return status;
    }

    public String delete(String id){
        String status = "ok";
        try {
            userRepository.delete(id);
        }catch (Exception e){
            status = e.getMessage();
        }
        return status;
    }
}
