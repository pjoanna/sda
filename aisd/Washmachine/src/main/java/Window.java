import javax.swing.*;
import java.awt.*;

/**
 * Created by RENT on 2017-09-12.
 */
public class Window extends JFrame {
    public Window() {
        JPanel mainPanel = new JPanel(new GridLayout(1, 0));
        for (int i = 0; i < 5; i++) {
            mainPanel.add(new Washer().getMainView());
        }

        setPreferredSize(new Dimension(1000, 430));
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();

    }
}
