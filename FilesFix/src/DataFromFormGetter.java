import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by RENT on 2017-08-03.
 */
public class DataFromFormGetter {

    private Form form;
    private BufferedReader reader;

    public String getAnswersFromForm() throws IOException {
        getNameFromForm();
        getSurnameFromForm();
        getAgeFromForm();
        getSexFromForm();
        getAddedAnswers();
        return form.getName() + form.getSurname();
    }

    private void getAddedAnswers() throws IOException {
        getAnswer1FromForm();
        getAnswer2FromForm();
        getAnswer3FromForm();
    }

    private void getAnswer3FromForm() throws IOException {
        String[] ans3 = reader.readLine().split("=");
        form.setAnswer3(ans3[1]);
    }

    private void getAnswer2FromForm() throws IOException {
        String[] ans2 = reader.readLine().split("=");
        form.setAnswer2(ans2[1]);
    }

    private void getAnswer1FromForm() throws IOException {
        String[] ans1 = reader.readLine().split("=");
        form.setAnswer1(ans1[1]);
    }

    private void getSexFromForm() throws IOException {
        String[] sexes = reader.readLine().split("=");
        form.setSex(sexes[1]);
    }

    private void getAgeFromForm() throws IOException {
        String[] ageString = reader.readLine().split("=");
        Integer age = Integer.parseInt(ageString[1]);
        form.setAge(age);
    }

    private void getSurnameFromForm() throws IOException {
        String[] surnames = reader.readLine().split("=");
        form.setSurname(surnames[1]);
    }

    private void getNameFromForm() throws IOException {
        String[] names = reader.readLine().split("=");
        form.setName(names[1]);
    }
}
