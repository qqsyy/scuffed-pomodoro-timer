import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class pomodoroTimer extends JFrame{


    private JPanel Main;
    private JLabel Title;
    private JButton startButton;

    private JButton stopButton;
    private JLabel pTimer;
    private JButton resetButton;

    public static void playMusic(String location){
        try
        {
            File musicPath = new File(location);
            if(musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
            else{
                System.out.println("Can't find file");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public pomodoroTimer() {
        final Timer[] t = new Timer[1];
        final int[] k = {1499};

        t[0] = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // convert into minutes and seconds
                int m = k[0] % 3600 / 60;
                int k2 = k[0] % 3600 % 60;
                String mStr = String.valueOf(m);
                String k2Str = String.valueOf(k2);
                pTimer.setText(mStr + ":" + k2Str);
                k[0]--;
                if(k[0] == -1){
                    t[0].stop();
                }
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playMusic("C:\\Users\\Bondo\\OneDrive\\Desktop\\Intellij Projects\\pomodoroTimer\\src\\Audio\\Button.wav");
                t[0].start();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playMusic("C:\\Users\\Bondo\\OneDrive\\Desktop\\Intellij Projects\\pomodoroTimer\\src\\Audio\\Button.wav");
                t[0].stop();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playMusic("C:\\Users\\Bondo\\OneDrive\\Desktop\\Intellij Projects\\pomodoroTimer\\src\\Audio\\Button.wav");
                k[0] = 1499;
                pTimer.setText("25:00");
            }
        });
    }

    public static void main(String[] args){
        pomodoroTimer frame = new pomodoroTimer();
        frame.setContentPane(new pomodoroTimer().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setName("Pomodoro Timer v1.0");
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}
