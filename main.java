
package Main;

import util.*;

import java.util.Scanner;
//This method prints all the students information from the arraylist but with scores.

public class main {
    public static void Main(String[] args) {
        Gradebook g = new Gradebook();
        Scanner keyboard = new Scanner(System.in);

        //The prompt that welcomes the user
        System.out.println("Welcome to my grade book!" + "\n" + "Please enter the information of the first student using the following format:" + "\n" + "'firstName lastName PID Grade'" + "\n" + "Press Enter when you are done.");
        while (true) {
            String studentInfo = keyboard.nextLine();

            if (studentInfo.equals("DONE")) {
                g.printAllStudents();
                break;
            }
            //These methods check if the student typed the correct information. Also checks if there are 4 inputs and runs through the methods
            String[] tokens = studentInfo.split(" ");
            if (tokens.length != 4) {
                System.out.println("Wrong entry. Please follow the format!");
                continue;
            }
            if (!checkFirstName(tokens[0])) {
                System.out.println("Wrong first name. Please try again!");
                continue;
            }
            if (!checkLastName(tokens[1])) {
                System.out.println("Wrong last name. Please try again!");
                continue;
            }
            if (!checkID(tokens[2])) {
                System.out.println("Wrong id. Please try again!");
                continue;
            }
            if (!checkScore(tokens[3])) {
                System.out.println("Wrong score. Please try again!");
                continue;
            }
            // The input from the user gets seperated into 4 tokens.
            Student student = new Student(tokens[0], tokens[1], Integer.parseInt(tokens[2]), new Grade(Integer.parseInt(tokens[3])));

            g.add(student);

            System.out.println("Please enter the information of the next student using the same format." + "\n" + "If there is no more students, please enter the keyword 'DONE'" + "\n" + "Press Enter when you are done.");
        }
        System.out.println("These are the commands you may use.\n " + "min score, min letter, max score, max letter\n " + "letter XXXXXXX(The X is the Pid), name XXXXXXX, change XXXXXXX YY(the YY is the score)\n " + "average score, average letter, median score, median letter, tab score, tab letters, quit.");

        // This while loop controls all the commands that are available to the user. They call the commands from the gradebook class.
        while (true) {
            System.out.println("Please enter a new command");
            String command = keyboard.nextLine();

            if (command.equals("quit")) {
                break;
            }
            if (command.startsWith("min")) {
                if (command.equals("min score")) {
                    System.out.println(g.minScore());
                } else {
                    System.out.println(Grade.scoreToLetter(g.minScore()));
                }

            } else if (command.startsWith("max")) {
                if (command.equals("max score")) {
                    System.out.println(g.maxScore());
                } else {
                    System.out.println(Grade.scoreToLetter(g.maxScore()));
                }
            }

            if (command.startsWith("letter")) {
                String[] tokens = command.split(" ");
                if (tokens.length == 2) {
                    String pidToGet = tokens[1];
                    g.letterGetter(pidToGet);

                }
            }

            if (command.startsWith("name")) {
                String[] tokens = command.split(" ");
                if (tokens.length == 2) {
                    String pidToGet = tokens[1];
                    g.nameGetter(pidToGet);

                }
            }

            if (command.startsWith("change")) {
                String[] tokens = command.split(" ");
                if (tokens.length == 3) {
                    String pidToChange = tokens[1];
                    String newGradeSymbol = tokens[2];
                    int newGrade = Integer.parseInt(newGradeSymbol);
                    g.changeGrade(pidToChange, newGrade); // Call the new method
                } else {
                    System.out.println("Wrong command. Please try again.");
                }
            } else if (command.startsWith("average")) {
                if (command.equals("average score")) System.out.println(g.calculateAvg());
                else System.out.println(Grade.scoreToLetter(g.calculateAvg()));
            }

            if (command.startsWith("median")) {
                if (command.equals("median score")) {
                    System.out.println(g.calculateMedian());
                } else {
                    System.out.println(Grade.scoreToLetter(g.calculateMedian()));
                }
            }

            if (command.startsWith("tab")) {

                if (command.equals("tab scores")) {
                    System.out.printf("%-15s\t%-15s\t%-15s\t%-15s\n", "FirstName", "LastName", "Pid", "Scores");

                    g.printAllStudents();
                } else {
                    System.out.printf("%-15s\t%-15s\t%-15s\t%-15s\n", "FirstName", "LastName", "Pid", "Letter Grade");

                    g.printAllWithLetters();
                }
            }
        }
    }

    //These methods check if the user inputed the information correctly.
    private static boolean checkFirstName(String token) {
        if (!Character.isUpperCase(token.charAt(0)) && !Character.isLetter(token.charAt(0))) {
            return false;
        }
        return true;
    }

    private static boolean checkLastName(String token) {
        if (!Character.isUpperCase(token.charAt(0)) && !Character.isLetter(token.charAt(0))) {
            return false;
        }
        return true;
    }

    private static boolean checkID(String token) {
        if (token.length() != 7) {
            return false;
        }
        return true;
    }

    private static boolean checkScore(String token) {
        for (int i = 0; i < token.length(); i++) {
            if (!Character.isDigit(token.charAt(i))) {
                return false;
            }
        }
        int score = Integer.parseInt(token);
        if (score < 0 || score > 100) {
            return false;
        }
        return true;

    }
}