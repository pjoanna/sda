/**
 * Created by pjoanna on 2017-08-09.
 */
public class Grade {
    private float grade;
    private GradeType gradeType;

    public Grade(float grade, GradeType gradeType) {
        this.grade = grade;
        this.gradeType = gradeType;
    }

    public float getGrade() {
        return grade;
    }

    public GradeType getGradeType() {
        return gradeType;
    }
}
