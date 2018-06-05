package myprojects.chessproject.virtualchess.frame;


import myprojects.chessproject.virtualchess.board.Board;
import myprojects.chessproject.virtualchess.geometry.Point;
import myprojects.chessproject.virtualchess.board.NoImagesException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class ProcessingFrame {


    private static Board board = null;
    private static int indexOfChosenPeace;


    public static void create() {
        board = new Board();
        try {
            board.createBoard();
        } catch (NoImagesException e) {
            JOptionPane.showMessageDialog(null, "Error!\n" + e.getException());
            System.err.println("ProcessingFrame:\n" + e.getException());
            System.exit(0);
        }
        indexOfChosenPeace = -1;
    }


    public static void draw(Graphics2D g) {
        if (board == null) {
            return;
        }
        board.draw(g);
    }


    public static void init() {
        indexOfChosenPeace = -1;
        board.init();
    }


    public static void choosePeace(Point coordiantes) {
        if (indexOfChosenPeace <= 0) {
            indexOfChosenPeace = board.choosePeace(coordiantes);
        }
    }


    public static void movePeace(Point coordinates) {
        if (indexOfChosenPeace >= 0) {
            board.movePeace(indexOfChosenPeace, coordinates);
        }
    }


    public static void takeOut() {
        indexOfChosenPeace = -1;
        try {
            board.takeOut();
        } catch (IOException ex) {

        }
    }


    public static void putPeace() {
        indexOfChosenPeace = -1;
    }


    public static void changeColor() {
        board.changeFirstColor();
    }


    public static void setSizeOfBoard() {
        String res = JOptionPane.showInputDialog("Enter size of one square.");
        if ((res == null) || (res.length() == 0)) {
            return;
        }
        try {
            int size = Integer.parseInt(res);
            if ((size <= 0) || (size >= 77)) {
                return;
            }
            board.setSizeOfSquare(size);
        } catch (NumberFormatException e) {
        }

    }
}