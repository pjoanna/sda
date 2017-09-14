import java.awt.*;

/**
 * Created by RENT on 2017-09-11.
 */
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Window().setVisible(true);
            }
        });
    }
}
