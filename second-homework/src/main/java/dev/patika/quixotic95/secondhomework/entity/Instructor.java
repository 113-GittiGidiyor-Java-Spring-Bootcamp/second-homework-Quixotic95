package dev.patika.quixotic95.secondhomework.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@JsonIdentityInfo(scope = Instructor.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Instructor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String phoneNumber;

    @OneToMany(mappedBy = "courseInstructor", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Course> instructorCourses = new HashSet<>();

    public Instructor() {
    }

    public Instructor(String firstName, String lastName, String address, String phoneNumber) {
        super(firstName, lastName, address);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Course> getInstructorCourses() {
        return instructorCourses;
    }

    public void setInstructorCourses(Set<Course> instructorCourses) {
        this.instructorCourses = instructorCourses;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", instructorCourses=" + instructorCourses +
                "} " + super.toString();
    }
}
