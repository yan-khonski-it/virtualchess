package myprojects.chessproject.virtualchess.board.piece;


import myprojects.chessproject.virtualchess.geometry.Point;
import java.awt.*;


public class Piece {


    protected Point coordinates;
    protected static int sizeOfSquare;


    public static void setSizeOfSquare(int size) {
        Piece.sizeOfSquare = size;
    }


    public static int getSizeOfSquare() {
        return Piece.sizeOfSquare;
    }


    public void draw(Graphics2D g, int colorOfBackground) {
    }


    public boolean isSelected(Point p) {
        int dx = (p.getX() - this.coordinates.getX());
        int dy = (p.getY() - this.coordinates.getY());
        if ((dx < 0) || (dy < 0)) {
            return false;
        }
        if ((dx > sizeOfSquare) || (dy > sizeOfSquare)) {
            return false;
        }
        return true;
    }


    public Point getCoordiantes() {
        return this.coordinates;
    }


    public void setCoordinates(Point p) {
        coordinates = p;
    }


    @Override
    public String toString() {
        return coordinates + "";
    }
}