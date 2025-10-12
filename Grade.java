package util;

public class Grade {
    //Creates cut off point variables to determine the grade of the user
    public static final int A_CUTOFF_POINT = 95;
    public static final int AMINUS_CUTOFF_POINT = 90;
    public static final int BPLUS_CUTOFF_POINT = 87;
    public static final int B_CUTOFF_POINT = 83;
    public static final int BMINUS_CUTOFF_POINT = 80;
    public static final int CPLUS_CUTOFF_POINT = 77;

    public static final int C_CUTOFF_POINT = 70;

    public static final int D_CUTOFF_POINT = 60;

    private int score;
    private String letterGrade;

    public Grade(int score) {
        this.score = score;
        this.letterGrade = scoreToLetter(score);
    }

    public int getScore() {
        return score;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    //In this method the variables are set to determine the grade of the user
    public static String scoreToLetter(double number) {
        if (number >= A_CUTOFF_POINT)
            return "A";

        if (number >= AMINUS_CUTOFF_POINT)
            return "A-";

        if (number >= BPLUS_CUTOFF_POINT)
            return "B+";

        if (number >= B_CUTOFF_POINT)
            return "B";

        if (number >= BMINUS_CUTOFF_POINT)
            return "B-";

        if (number >= CPLUS_CUTOFF_POINT)
            return "C+";

        if (number >= C_CUTOFF_POINT)
            return "C";

        if (number >= D_CUTOFF_POINT)
            return "D";

        return "F";
    }

    //Sets a new score for the user when they use the change command
    public void setScore(int newGrade) {
        score = newGrade;
    }
}
