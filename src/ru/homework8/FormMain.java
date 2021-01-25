package ru.homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormMain extends JFrame {

    static final int windowX = 400;
    static final int winodwsY = 400;
    static final int winodwsWidth = 450;
    static final int winodwsHeight = 450;

    private  SettingGameWindow settingGameWindow;

    private Map map;

    public FormMain () {

        setTitle("Game Windows");
        setBounds(windowX,winodwsY,winodwsWidth,winodwsHeight);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        settingGameWindow = new SettingGameWindow(this);
        map = new Map(this);

        add(map,BorderLayout.CENTER);

        JPanel panel = new JPanel (new GridLayout(1,2));

        JButton buttonGame = new JButton("Start");
        panel.add(buttonGame);
        JButton buttonExsit = new JButton("Exsit");
        panel.add(buttonExsit);
        add(panel, BorderLayout.NORTH);

        buttonGame.addActionListener(e -> {

            settingGameWindow.setVisible(true);
                });

        buttonExsit.addActionListener(e ->
                System.exit(0)
                );


        setVisible(true);

    }

    public void newGame(int mode){
        map.newGame(mode);
    }

    private static class WIndowsRunnable implements /*extends*/ Runnable{

        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {

        new FormMain();
        //EventQueue.invokeLater(new WIndowsRunnable());

    }
}
