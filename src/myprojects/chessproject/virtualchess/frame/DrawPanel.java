package myprojects.chessproject.virtualchess.frame;


import javax.swing.*;
import java.awt.*;


class DrawPanel extends JPanel {

    public DrawPanel() {
        super();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ProcessingFrame.draw((Graphics2D) g);
    }
}