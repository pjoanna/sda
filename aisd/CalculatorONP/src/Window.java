import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by RENT on 2017-09-08.
 */
public class Window extends JFrame{

    public Window(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 400));
        ONP onp = new ONP(equation.toString());


        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source instanceof JButton){
                    JButton button = (JButton) source;
                    String content = button.getText();
                    equation.setText(equation.getText().trim());
                    equation.setText(equation.getText() + content);
                }
            }
        };

        ActionListener listenerOperators = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source instanceof JButton){
                    JButton button = (JButton) source;
                    String content = button.getText();
                    equation.setText(equation.getText().trim());
                    equation.setText(equation.getText() + " " + content + " ");
                }
            }
        };

        button0.addActionListener(listener);
        button00.addActionListener(listener);
        buttonDot.addActionListener(listener);
        button8.addActionListener(listener);
        button9.addActionListener(listener);
        button4.addActionListener(listener);
        button5.addActionListener(listener);
        button6.addActionListener(listener);
        button1.addActionListener(listener);
        button2.addActionListener(listener);
        button3.addActionListener(listener);
        button7.addActionListener(listener);

        buttonClear.addActionListener(listenerOperators);
        buttonPlus.addActionListener(listenerOperators);
        buttonMinus.addActionListener(listenerOperators);
        buttonMulti.addActionListener(listenerOperators);
        buttonDiv.addActionListener(listenerOperators);
        buttonBracketOpen.addActionListener(listenerOperators);
        buttonBracketClose.addActionListener(listenerOperators);
        buttonEq.addActionListener(listenerOperators);


        buttonBackspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!equation.getText().isEmpty()) {
                    equation.setText(equation.getText().trim());
                    equation.setText(equation.getText().substring(0, equation.getText().length() - 1).trim());
                }
            }


        });
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setText("");
            }
        });

        buttonBracketOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        //        equation.setText();
            }
        });

        buttonBracketClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

    private JPanel mainPanel;
    private JPanel northPanel;
    private JPanel southPanel;
    private JTextField equation;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JPanel rightInternalPanel;
    private JPanel leftInternalPanel;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonMulti;
    private JButton buttonDiv;
    private JButton buttonBracketOpen;
    private JButton buttonBracketClose;
    private JButton buttonEq;
    private JButton buttonBackspace;
    private JButton button0;
    private JButton button00;
    private JButton buttonDot;
    private JButton buttonClear;
    private JButton button8;
    private JButton button9;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button7;


}
