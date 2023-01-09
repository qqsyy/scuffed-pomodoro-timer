import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.Objects;
import javax.swing.Timer;
public class pomodoroTimer extends JFrame{
    private JPanel Main;
    private JLabel Title;
    private JButton startButton;

    private JButton stopButton;
    private JLabel pTimer;
    private JButton resetButton;

    public pomodoroTimer() {
        final Timer[] t = new Timer[1];
        final int[] k = {1500};

        t[0] = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strVal = String.valueOf(k[0]);
                pTimer.setText(strVal);
                k[0]--;
                if(k[0] == -1){
                    t[0].stop();

                }
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t[0].start();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t[0].stop();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k[0] = 1500;
                String strVal = String.valueOf(k[0]);
                pTimer.setText(strVal);
            }
        });
    }

    public static void main(String[] args){
        pomodoroTimer frame = new pomodoroTimer();
        frame.setContentPane(new pomodoroTimer().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setName("Pomodoro Timer v1.0");
        frame.pack();
        frame.setVisible(true);
    }
}
