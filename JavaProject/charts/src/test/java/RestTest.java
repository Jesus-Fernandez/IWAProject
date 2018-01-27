import jdk.nashorn.internal.objects.annotations.Constructor;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.junit.matchers.JUnitMatchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

import static com.jayway.restassured.RestAssured.*;

public class RestTest {
     private final String host = "http://localhost:9090";

     @Test
     public void testCourses(){
          given().get(host+"/courses").then().statusCode(200).log().all();
     }

     @Test
     public void testCoursesElements(){
          given().get(host+"/courses").then()
                  .body("id",hasItems("AngularJS","Ionic","Java","PHP","Python"));
     }

     @Test
     public void testUsers(){
          given().get(host+"/users").then().statusCode(200).log().all();
     }
}
