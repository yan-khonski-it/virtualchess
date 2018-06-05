package myprojects.chessproject.virtualchess.board.piece.pieces;


import myprojects.chessproject.virtualchess.board.Board;
import myprojects.chessproject.virtualchess.board.piece.Piece;
import myprojects.chessproject.virtualchess.board.piece.PieceImage;
import java.awt.*;


public class Queen extends Piece {

    private Image imageW;
    private Image imageB;
    private Image image;


    public Queen(PieceImage images) {
        image = images.getColor();
        imageW = images.getColorW();
        imageB = images.getColorB();
    }


    @Override
    public void draw(Graphics2D g, int colorOfBackground) {
        if (colorOfBackground == Board.OUT_OF_BOARD) {
            g.drawImage(image, coordinates.getX() + 1, coordinates.getY() + 1, (int) (Piece.sizeOfSquare * 0.99), (int) (Piece.sizeOfSquare * 0.99), null);
        }
        else if (colorOfBackground == Board.BLACK_SQUARE) {
            g.drawImage(imageB, coordinates.getX() + 1, coordinates.getY() + 1, (int) (Piece.sizeOfSquare * 0.99), (int) (Piece.sizeOfSquare * 0.99), null);
        }
        else if (colorOfBackground == Board.WHITE_SQUARE) {
            g.drawImage(imageW, coordinates.getX() + 1, coordinates.getY() + 1, (int) (Piece.sizeOfSquare * 0.99), (int) (Piece.sizeOfSquare * 0.99), null);
        }
    }
}