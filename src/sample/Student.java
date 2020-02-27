package sample;

import java.util.UUID;

public class Student implements School {
    //Just laid the foundation for what a Object Student will have every time when I created a new Student Object
    public String studentName;
    public UUID studentID;
    public int studentAge;
    public String studentMajor;
    public double studentGPA;

    @Override
    public String toString(){
        return (this.studentName);
    }

    //Did not end up using it :(
    @Override
    public void filter() {

    }
}
