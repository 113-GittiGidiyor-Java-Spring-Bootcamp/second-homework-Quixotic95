package dev.patika.quixotic95.secondhomework.entity;

import javax.persistence.Entity;

@Entity
public class VisitingResearcher extends Instructor {

    private double hourlySalary;

    public VisitingResearcher() {
    }

    public VisitingResearcher(String firstName, String lastName, String address, String phoneNumber, double hourlySalary) {
        super(firstName, lastName, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "hourlySalary=" + hourlySalary +
                "} " + super.toString();
    }
}
