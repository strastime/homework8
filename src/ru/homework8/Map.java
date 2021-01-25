package ru.homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map  extends JPanel {


    private FormMain formMain;

    static final int gameHumvsAi = 0;
    static final int getGameHumvsHum = 1;

    private int mode;

    private boolean dannie;

    private int cellWight;
    private int cellHeight;


    public Map(FormMain gameWindow) {
        this.formMain = gameWindow;

        setBackground(Color.green);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
               int cellX = e.getX() / cellWight;
               int cellY = e.getY() / cellHeight;

               if (!Game.gameOff){
                   Game.humanTurn(cellX,cellY);
               }
                repaint();
            }
        });
    }

    public void newGame(int mode){
        this.mode = mode;
          dannie = true;
          repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!dannie){
            return;
        }

        cellHeight = getHeight()/3;
        cellWight = getWidth()/3;
        for (int i = 1; i < 3; i++) {
            int y = i * cellHeight;
            g.drawLine(0,y,getWidth(),y);
        }
        for (int i = 1; i < 3; i++) {
            int x = i * cellWight;
            g.drawLine(x,0,x,getHeight());
        }
        for (int i = 0; i < Game.SIZE; i++) {
            for (int j = 0; j < Game.SIZE; j++) {
                if(Game.map[i][j] == Game.DOT_X){
                    drawX(g, j, i);
                }
                if (Game.map[i][j] == Game.DOT_O){
                    drawOval(g, j, i);
                }

            }
        }

//        ((Graphics2D)g).setStroke(new BasicStroke(5));
//        g.setColor(Color.red);
//        g.drawLine(100,100,300,300);
//
//        g.drawOval(100,100,200,200);
    }

    private void drawX(Graphics g, int cellX, int cellY) {
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.RED);
        g.drawLine(cellX * cellWight, cellY * cellHeight,
                (cellX + 1) * cellWight, (cellY + 1) * cellHeight);
        g.drawLine(cellX * cellWight, (cellY + 1) * cellHeight,
                (cellX + 1) * cellWight, cellY * cellHeight);
    }

    private void drawOval(Graphics g, int cellX, int cellY) {
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.BLUE);
        g.drawOval(cellX * cellWight, cellY * cellHeight,
                cellWight, cellHeight);
    }

}
