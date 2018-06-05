package myprojects.chessproject.virtualchess.board.piece;


import myprojects.chessproject.virtualchess.board.NoImagesException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class PieceImage {


    private Image color;
    private Image colorW;
    private Image colorB;

    private String imageName;
    private String extension;


    public static final String PAWN = "pawn";
    public static final String CASTLE = "castle";
    public static final String KNIGHT = "knight";
    public static final String BISHOP = "bishop";
    public static final String QUEEN = "queen";
    public static final String KING = "king";
    public static final String ext = ".png";



    public PieceImage() {
        this.imageName = "";
        this.extension = "";
        this.color = null;
        this.colorB = null;
        this.colorW = null;
    }


    public PieceImage(String name) {
        this();
        this.imageName = name;
        this.extension = ext;
    }


    public PieceImage(String name, String extension) {
        this();
        this.imageName = name;
        this.extension = extension;
    }


    public void readImage() throws NoImagesException {
        this.readFirst();
        this.readSecond();
        this.readThird();
    }


    private void readFirst() throws NoImagesException {
        File colorF = new File(this.imageName + this.extension);
        try {
            color = ImageIO.read(colorF);
        } catch (IOException e) {
            throw new NoImagesException("There is not image: " + imageName + this.extension);
        }
    }


    private void readSecond() throws NoImagesException {
        File colorWW = new File(this.imageName + "_w" + this.extension);
        try {
            this.colorW = ImageIO.read(colorWW);
        } catch (IOException e) {
            throw new NoImagesException("There is not image: " + imageName + "_w" + this.extension);
        }
    }


    private void readThird() throws NoImagesException {
        File colorWB = new File(this.imageName + "_b" + this.extension);
        try {
            this.colorB = ImageIO.read(colorWB);
        } catch (IOException e) {
            throw new NoImagesException("There is not image: " + imageName + "_b" + this.extension);
        }
    }


    public Image getColor() {
        return color;
    }


    public Image getColorW() {
        return colorW;
    }


    public Image getColorB() {
        return colorB;
    }
}