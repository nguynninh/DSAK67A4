package project.main;

import project.snake.SnakeGame;

import javax.swing.*;
import java.io.IOException;

public class PlayStore {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        SettingPanel settingPanel = new SettingPanel();
//        SlideShowPanel settingPanel = new SlideShowPanel();
        jFrame.add(settingPanel);
        jFrame.pack();

//        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
