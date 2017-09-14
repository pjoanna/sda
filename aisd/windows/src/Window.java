import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by RENT on 2017-09-08.
 */
public class Window extends JFrame{
    private JPanel panelMain;
    private JPanel panelNorth;
    private JPanel panelCenter;
    private JButton button1;
    private JLabel topLabel;
    private JTextField textField;

    public Window(){
        setContentPane(panelMain);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Kliknięto guzik");
                topLabel.setText("hello");
                topLabel.setText(textField.getText());
                textField.setText("");
            }
        });



        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Window().setVisible(true);
            }
        });


    }


}
