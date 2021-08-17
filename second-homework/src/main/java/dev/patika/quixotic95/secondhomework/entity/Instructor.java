package dev.patika.quixotic95.secondhomework.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Instructor extends Person {

    private String phoneNumber;

    @OneToMany(mappedBy = "courseInstructor")
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

}
