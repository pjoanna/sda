import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by RENT on 2017-09-11.
 */
public class Washer {
    private ExecutorService watek = Executors.newSingleThreadExecutor();
    private String[] program1Steps = new String[]{"Pranie wstępne", "Suszenie", "Wirowanie"};
    private WasherProgram[] programs;
    private Timer doorTimer  = new Timer(5000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            doorCheckBox.setSelected(true);
        }
    });

    public JPanel getMainView() {
        return mainView;
    }

    public Washer() {
//        setContentPane(mainView);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setPreferredSize(new Dimension(200, 430));

        doorTimer.setRepeats(false);
        programs = new WasherProgram[3];
        programs[0] = new WasherProgram(new String[]{"Pranie wstępne", "Wirowanie", "Suszenie", "koniec!"});
        programs[1] = new WasherProgram(new String[]{"Pranie wstępne", "Pranie normalne", "Wirowanie", "koniec!"});
        programs[2] = new WasherProgram(new String[]{"Płukanie", "Pranie normalne", "Wirowanie", "Wirowanie spowolnione", "odpomowanie", "koniec!"});

        progressBar1.setValue(0);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("start!");
                // wątek sie uruchamia
                WasherProgram program = null;
                if (program1.isSelected()) {
                    program = programs[0];

                } else if (program2.isSelected()) {
                    program = programs[1];

                } else if (program3.isSelected()) {
                    program = programs[2];
                }
                doorCheckBox.setSelected(false);
                watek.submit(program);
            }
        });

    //    pack();
    }


    private JPanel mainView;
    private JTextField washingMachineName;
    private JPanel status;
    private JPanel progress;
    private JPanel mode;
    private JRadioButton program1;
    private JRadioButton program2;
    private JRadioButton program3;
    private JButton start;
    private JLabel statusValue;
    private JCheckBox doorCheckBox;
    private JCheckBox waterInside;
    private JProgressBar progressBar1;


    private class WasherProgram implements Runnable{
        @Override
        public void run() {
            progressBar1.setValue(0);

            for (int i = 0; i < phases.length; i++) {
                start.setText("Stop");
                statusValue.setText(phases[i]);
                double progressValue = 100.0 / phases.length;
                double jump =  progressValue/10.0;
                try {
                    for (int j = 0; j < 10; j++) {
                        double val = (progressValue*i)+(j*jump);
                        progressBar1.setValue((int)val);
                        Thread.sleep(200);
                    }

                } catch (InterruptedException e1) {
                    System.out.println(e1.getMessage());
                }

            }
            progressBar1.setValue(100);
            doorTimer.start();
            // wracamy do stanu pierwotnego
        }

        private String[] phases = null;

        public WasherProgram(String[] phases) {
            this.phases = phases;
        }
    }




}
