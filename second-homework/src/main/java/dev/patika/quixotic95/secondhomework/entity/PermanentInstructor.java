package dev.patika.quixotic95.secondhomework.entity;

import javax.persistence.Entity;

@Entity
public class PermanentInstructor extends Instructor {

    private double fixedSalary;

    public PermanentInstructor() {
    }

    public PermanentInstructor(String firstName, String lastName, String address, String phoneNumber, double fixedSalary) {
        super(firstName, lastName, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "fixedSalary=" + fixedSalary +
                "} " + super.toString();
    }
    
}
