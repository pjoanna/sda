import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by RENT on 2017-08-03.
 */
public class DataFromFormGetter {

    private final Form form;
    private final BufferedReader reader;

    public DataFromFormGetter(Form form, BufferedReader reader) {
        this.form = form;
        this.reader = reader;
    }

    public String getAnswersFromForm() throws IOException {
        form.setName(nextValue());
        form.setSurname(nextValue());
        form.setAge(nextInt());
        form.setSex(Sex.valueOf(nextValue()));
        form.setAnswer1(nextValue());
        form.setAnswer2(nextValue());
        form.setAnswer3(nextValue());
        return form.getName() + form.getSurname();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextValue());
    }

    private String nextValue() throws IOException {
        String[] ans = reader.readLine().split("=");
        return ans[1];
    }


}
