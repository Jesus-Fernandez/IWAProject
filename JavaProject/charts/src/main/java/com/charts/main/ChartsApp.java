package com.charts.main;

import com.charts.main.data.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EntityScan
@EnableJpaRepositories
public class ChartsApp {

    public  static String port;

    public static void main(String [] args){
        ChartsApp.port = args[0];
        SpringApplication.run(ChartsApp.class,args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/users").allowedOrigins("http://localhost:"+ChartsApp.port);
                registry.addMapping("/courses").allowedOrigins("http://localhost:"+ChartsApp.port);
            }
        };
    }

    @Bean
    public CommandLineRunner demo(CourseService courseService, UserService userService) {
        return (args) -> {

            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<Course>> courseTypeReference = new TypeReference<List<Course>>(){};
            try {
                Path currentRelativePath = Paths.get("");
                String s = currentRelativePath.toAbsolutePath().toString();
                //System.out.println(s);
                List<Course> courses = objectMapper.readValue(new File(s+ "/json/courses.json"), courseTypeReference);
                courses.forEach(c ->courseService.save(c));
                //courses.forEach(c -> System.out.println(c.toString()));
            }catch (Exception e) {
                //System.out.println(e);
            }

            TypeReference<List<User>> userTypeReference = new TypeReference<List<User>>(){};
            try {
                Path currentRelativePath = Paths.get("");
                String s = currentRelativePath.toAbsolutePath().toString();
                //System.out.println(s);
                List<User> users = objectMapper.readValue(new File(s+ "/json/users.json"), userTypeReference);
                users.forEach(u ->userService.save(u));
                userService.getAllUsers().forEach(u -> {u.getCourses().forEach(c->{
                    switch (c){
                        case "Python":
                            courseService.addUser("Python",u);
                            break;
                        case "Java":
                            courseService.addUser("Java",u);
                            break;
                        case "AngularJS":
                            courseService.addUser("AngularJS",u);
                            break;
                        case "PHP":
                            courseService.addUser("PHP",u);
                            break;
                        case "Ionic":
                            courseService.addUser("Ionic",u);
                            break;
                    }
                });});
            }catch (Exception e){
                //System.out.println(e);
            }



            /*Course o = new Course();
            o.setId("Java");
            courseService.save(new Course("Python","",50,null));
            courseService.save(o);
            courseService.save(new Course("AngularJS","",50,null));
            courseService.save(new Course("PHP","",50,null));
            courseService.save(new Course("Ionic","",50,null));*/

            //List<Course> l = courseService.getAllCourses();



            /*userService.save(new User("111","10",30,"black","Jesus","male",
                    "x","example@example.com","987654","sdjdlkasd","soccer",
                    "","","","banana"));

            Course c = courseService.findOne("Python");
            c.setUsers(userService.getAllUsers());
            courseService.save(c);*/

        };}
}
