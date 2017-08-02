/**
 * Created by amen on 8/1/17.
 */
public class Form {
    private String name;
    private int age;
    private String sex;
    private String answer1;
    private String answer2;
    private String answer3;

    public Form() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {

        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    @Override
    public String toString() {
        return "name=" + name + "\n" +
                "age=" + age + "\n" +
                "sex=" + sex + "\n" +
                "answer1=" + answer1 + "\n" +
                "answer2=" + answer2 + "\n" +
                "answer3=" + answer3 + "\n\n";
    }
}
