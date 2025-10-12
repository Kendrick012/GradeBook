/* This is part of the starter code!
 * You need to complete this class yourself!*/
package util;

public class Student {
    //provides the variables and constructors for the rest of the code.
    private String firstName;
    private String lastName;
    private int pid;
    private Grade grade;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPid() {
        return pid;
    }

    public Grade getGrade() {
        return grade;
    }

    public Student(String firstName, String lastName, int pid, Grade grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = grade;

    }


    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}