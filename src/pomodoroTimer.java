import javax.sound.sampled.Clip;
import javax.swing.*;
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
    private JButton pomodoroButton;
    private JButton shortBreakButton;
    private JButton longBreakButton;

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
                System.out.println("Can't find audio file");
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

        t[0] = new Timer(1000, e -> {
            // convert into minutes and seconds
            int m = k[0] % 3600 / 60;
            int k2 = k[0] % 3600 % 60;
            String mStr = String.valueOf(m);
            String k2Str = String.valueOf(k2);
            k[0]--;

            if(m < 10 && k2 < 10){ // Concatenate 0 when one of the values becomes a singular digit
                pTimer.setText("0" + mStr + ":" + "0" + k2Str);
            } else if (m < 10){
                pTimer.setText("0" + mStr + ":" + k2Str);
            } else if (k2 < 10){
                pTimer.setText(mStr + ":" + "0" + k2Str);
            } else {
                pTimer.setText(mStr + ":" + k2Str);
            }
            if(k[0] == -1){
                t[0].stop();
            }
        });

        startButton.addActionListener(e -> {
            playMusic("C:\\Users\\Bondo\\OneDrive\\Desktop\\Intellij Projects\\pomodoroTimer\\src\\Audio\\Button.wav");
            t[0].start();
        });
        stopButton.addActionListener(e -> {
            playMusic("C:\\Users\\Bondo\\OneDrive\\Desktop\\Intellij Projects\\pomodoroTimer\\src\\Audio\\Button.wav");
            t[0].stop();
        });
        pomodoroButton.addActionListener(e -> {
            k[0] = 1499;
            pTimer.setText("25:00");
            playMusic("C:\\Users\\Bondo\\OneDrive\\Desktop\\Intellij Projects\\pomodoroTimer\\src\\Audio\\Button.wav");
        });
        shortBreakButton.addActionListener(e -> {
            k[0] = 299;
            pTimer.setText("05:00");
            playMusic("C:\\Users\\Bondo\\OneDrive\\Desktop\\Intellij Projects\\pomodoroTimer\\src\\Audio\\Button.wav");
        });
        longBreakButton.addActionListener(e -> {
            k[0] = 899;
            pTimer.setText("15:00");
            playMusic("Audio\\Button.wav");
        });
    }

    public static void frameSettings(pomodoroTimer frame) {
        frame.setContentPane(new pomodoroTimer().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setName("Pomodoro Timer");
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        pomodoroTimer frame = new pomodoroTimer();
        frameSettings(frame);
    }
}
