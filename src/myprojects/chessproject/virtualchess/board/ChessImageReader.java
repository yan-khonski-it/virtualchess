package myprojects.chessproject.virtualchess.board;


import myprojects.chessproject.virtualchess.board.piece.PieceImage;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class ChessImageReader {


    private String imageFolderName;
    private String gap;

    private PieceImage pawnW;
    private PieceImage pawnB;
    private PieceImage knightW;
    private PieceImage knightB;
    private PieceImage bishopW;
    private PieceImage bishopB;
    private PieceImage castleW;
    private PieceImage castleB;
    private PieceImage kingW;
    private PieceImage kingB;
    private PieceImage queenW;
    private PieceImage queenB;

    private Image chessBoardImage;
    private static final String BOARD_FILE = "board.bmp";


    public ChessImageReader() {
        this.gap = File.separator;
        this.imageFolderName = ".";
        this.bishopB = null;
        this.bishopW = null;
        this.castleW = null;
        this.castleB = null;
        this.kingB = null;
        this.kingW = null;
        this.knightW = null;
        this.knightB = null;
        this.pawnB = null;
        this.pawnW = null;
        this.queenB = null;
        this.queenW = null;
    }


    public ChessImageReader(String folder) {
        this();
        this.imageFolderName = folder;
    }


    public void readImages()throws NoImagesException {
        File folder = new File(this.imageFolderName);
        if (!folder.isDirectory()) {
            throw new NoImagesException("The folder " + this.imageFolderName + " does not exist.");
        }
        this.readPieces();
    }


    private void readPieces() throws NoImagesException {
        this.readPawns();
        this.readCastles();
        this.readKnights();
        this.readBishops();
        this.readQueens();
        this.readKings();
        this.readBoard();
    }


    private void readBoard() throws NoImagesException {
        try {
            this.chessBoardImage = ImageIO.read(new File(this.imageFolderName + gap + ChessImageReader.BOARD_FILE));
        } catch (IOException ex) {
            throw new NoImagesException("There is not file: " + ChessImageReader.BOARD_FILE);
        }
    }


    private void readPawns() throws NoImagesException {
        this.pawnW = new PieceImage(this.imageFolderName + gap + PieceImage.PAWN + "_w");
        this.pawnW.readImage();
        this.pawnB = new PieceImage(this.imageFolderName + gap + PieceImage.PAWN + "_b");
        this.pawnB.readImage();
    }


    private void readCastles() throws NoImagesException {
        this.castleW = new PieceImage(this.imageFolderName + gap + PieceImage.CASTLE + "_w");
        this.castleW.readImage();
        this.castleB = new PieceImage(this.imageFolderName + gap + PieceImage.CASTLE + "_b");
        this.castleB.readImage();
    }


    private void readKnights() throws NoImagesException {
        this.knightW = new PieceImage(this.imageFolderName + gap + PieceImage.KNIGHT + "_w");
        this.knightW.readImage();
        this.knightB = new PieceImage(this.imageFolderName + gap + PieceImage.KNIGHT + "_b");
        this.knightB.readImage();
    }


    private void readBishops() throws NoImagesException {
        this.bishopW = new PieceImage(this.imageFolderName + gap + PieceImage.BISHOP + "_w");
        this.bishopW.readImage();
        this.bishopB = new PieceImage(this.imageFolderName + gap + PieceImage.BISHOP + "_b");
        this.bishopB.readImage();
    }


    private void readQueens() throws NoImagesException {
        this.queenW = new PieceImage(this.imageFolderName + gap + PieceImage.QUEEN + "_w");
        this.queenW.readImage();
        this.queenB = new PieceImage(this.imageFolderName + gap + PieceImage.QUEEN + "_b");
        this.queenB.readImage();
    }


    private void readKings() throws NoImagesException {
        this.kingW = new PieceImage(this.imageFolderName + gap + PieceImage.KING + "_w");
        this.kingW.readImage();
        this.kingB = new PieceImage(this.imageFolderName + gap + PieceImage.KING + "_b");
        this.kingB.readImage();
    }


    public PieceImage getPawnW() {
        return this.pawnW;
    }


    public PieceImage getPawnB() {
        return this.pawnB;
    }


    public PieceImage getCastleW() {
        return this.castleW;
    }


    public PieceImage getCastleB() {
        return this.castleB;
    }


    public PieceImage getKnightW() {
        return this.knightW;
    }


    public PieceImage getKnightB() {
        return this.knightB;
    }


    public PieceImage getBishopW() {
        return this.bishopW;
    }


    public PieceImage getBishopB() {
        return this.bishopB;
    }


    public PieceImage getQueenW() {
        return this.queenW;
    }


    public PieceImage getQueenB() {
        return this.queenB;
    }


    public PieceImage getKingW() {
        return this.kingW;
    }


    public PieceImage getKingB() {
        return this.kingB;
    }


    public Image getChessBoardImage() {
        return this.chessBoardImage;
    }
}