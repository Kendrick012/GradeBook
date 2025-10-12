package util;

import java.util.ArrayList;
import java.util.Arrays;

public class Gradebook {
    //Creates an arraylist of students
    private ArrayList<Student> listOfStudents;

    public Gradebook() {
        listOfStudents = new ArrayList<>();
    }

    //This calculates the average of the scores and letters
    public double calculateAvg() {
        double sum = 0;
        for (Student s : listOfStudents)
            sum += s.getGrade().getScore();
        return sum / listOfStudents.size();
    }

    //The method calculates the median of the all the scores and letters
    public float calculateMedian() {
        int i = 0, n = listOfStudents.size();
        int[] scores = new int[n];
        for (Student s : listOfStudents)
            scores[i++] = s.getGrade().getScore();
        Arrays.sort(scores);
        if (n % 2 == 0)
            return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
        else
            return scores[n / 2];
    }

    //minScore calculates the minimum score of all the students scores and letters
    public double minScore() {
        int tracker = listOfStudents.get(0).getGrade().getScore();
        for (int i = 1; i < listOfStudents.size(); i++) {
            int minimum = listOfStudents.get(i).getGrade().getScore();
            if (minimum < tracker) {
                tracker = minimum;
            }

        }
        return tracker;
    }

    //Outputs the max score and letters of all the students
    public double maxScore() {
        int trackers = listOfStudents.get(0).getGrade().getScore();

        for (int i = 1; i < listOfStudents.size(); i++) {
            int maximum = listOfStudents.get(i).getGrade().getScore();
            if (maximum > trackers) {
                trackers = maximum;
            }

        }
        return trackers;

    }

    //When the user uses the command letter this method goes through the arraylist matching the Pid and returning the letter grade of the student
    public void letterGetter(String pid) {
        boolean get = false;
        int pidInt = Integer.parseInt(pid);
        for (Student student : listOfStudents) {
            if (student.getPid() == pidInt) {
                get = true;
                System.out.println("The Pid letter grade is " + student.getGrade().getLetterGrade());
                break;
            }
        }
        if (!get) {
            System.out.println("The Pid " + pid + " is invalid");
        }
    }

    //When the user uses the command name the method gets the matching Pid from the arraylist and returns the name of the student
    public void nameGetter(String pid) {
        boolean get = false;
        int pidInt = Integer.parseInt(pid);

        for (Student student : listOfStudents) {
            if (student.getPid() == pidInt) {
                get = true;
                String fullName = student.getFirstName() + " " + student.getLastName();
                System.out.println("The name for Pid " + pid + " is " + fullName);
                break;
            }
        }
        if (!get) {
            System.out.println("The Pid " + pid + " is invalid");
        }
    }

    //The method changes the score of the student when the user types the command change.
    public void changeGrade(String pid, int newGrade) {
        int changeGrade = 0;
        int pidInt = Integer.parseInt(pid);

        for (Student s : listOfStudents) {
            if (s.getPid() == pidInt) {
                s.getGrade().setScore(newGrade);
                System.out.println("The grade for Pid " + pid + " is " + newGrade);
                break;
            } else {
                System.out.println("Wrong Pid. Please try again.");
            }
        }
    }


    //This method prints all the students information from the arraylist but with scores
    public String printAllStudents() {
        for (Student s : listOfStudents) {
            System.out.printf("%-15s\t%-15s\t%-15d\t%-15d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
        }
        return null;
    }

    //This method prints all the students information from the arraylist but with letter grades
    public String printAllWithLetters() {
        for (Student s : listOfStudents) {
            System.out.printf("%-15s\t%-15s\t%-15d\t%-15s\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getLetterGrade());
        }

        return null;
    }

    //This method adds a new student to the arraylist
    public void add(Student student) {
        listOfStudents.add(student);
    }


}



