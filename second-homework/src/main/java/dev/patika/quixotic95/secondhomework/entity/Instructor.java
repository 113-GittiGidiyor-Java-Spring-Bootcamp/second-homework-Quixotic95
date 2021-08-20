package dev.patika.quixotic95.secondhomework.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = VisitingResearcher.class, name = "VisitingResearcher"),
        @JsonSubTypes.Type(value = PermanentInstructor.class, name = "PermanentInstructor")
})
//@JsonIdentityInfo(scope = Instructor.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Instructor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String phoneNumber;

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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "phoneNumber='" + phoneNumber + '\'' +
                "} " + super.toString();
    }

}
