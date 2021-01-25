package ru.homework8;

import javax.swing.*;
import java.awt.*;

public class SettingGameWindow extends JFrame {
   private static final int windowX = FormMain.windowX;
   private static final int winodwsY = FormMain.winodwsY;
   private static final int winodwsWidth = FormMain.winodwsWidth;
   private static final int winodwsHeight = FormMain.winodwsHeight;

   private FormMain formMain;
   private JRadioButton humanVsAi;
   private JRadioButton humanVshuman;
   private ButtonGroup gameMode;

    public SettingGameWindow (FormMain gameWindow){

        this.formMain = gameWindow;
        setTitle("Game Setting");
        setBounds(windowX,winodwsY,winodwsWidth,winodwsHeight);
        setLayout(new GridLayout(8,1));

        add(new JLabel("Setting"));
        humanVsAi = new JRadioButton("Human vs Ai",true);
        add(humanVsAi);
        humanVshuman = new JRadioButton("Human vs Human");
        add(humanVshuman);
        gameMode = new ButtonGroup();
        gameMode.add(humanVsAi);
        gameMode.add(humanVshuman);




        JButton buttonStartGame = new JButton("Start Game");
        add(buttonStartGame);

        buttonStartGame.addActionListener(e -> {

            int mode;
            if (humanVsAi.isSelected()) {
                mode = Map.gameHumvsAi;
            }else {
                mode = Map.getGameHumvsHum;
            }
            Game.initMap();
            Game.gameOff = false;
            formMain.newGame(mode);

            setVisible(false);
        });

        setVisible(false);
    }




}
