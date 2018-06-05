package myprojects.chessproject.virtualchess.board;


import myprojects.chessproject.virtualchess.board.piece.Piece;
import myprojects.chessproject.virtualchess.board.piece.PieceImage;
import myprojects.chessproject.virtualchess.board.piece.pieces.*;
import myprojects.chessproject.virtualchess.board.piece.pieces.Knight;
import myprojects.chessproject.virtualchess.board.piece.pieces.Pawn;
import myprojects.chessproject.virtualchess.geometry.Point;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;


public class Board {

    private int sizeOfSquare;
    private int x, y;
    private BufferedImage boardImage;

    private ArrayList<Piece> pieces;
    private boolean initBoard;
    private boolean whitePiecesFirst;

    public static final int OUT_OF_BOARD = 0;
    public static final int WHITE_SQUARE = 1;
    public static final int BLACK_SQUARE = 2;
    private static final String IMAGE_FOLDER = "Images";

    private ChessImageReader chessImageReader;

    private int lastX;
    private int lastY;


    public Board() {
        this.chessImageReader = new ChessImageReader(Board.IMAGE_FOLDER);
        this.initBoard = false;
        this.whitePiecesFirst = true;
        pieces = new ArrayList<Piece>();
        sizeOfSquare = 75;
        Piece.setSizeOfSquare(this.sizeOfSquare);
        x = 30;
        y = 30;
    }


    public void setSizeOfSquare(int size) {
        this.sizeOfSquare = size;
        Piece.setSizeOfSquare(this.sizeOfSquare);
        this.init();
    }


    public void createBoard() throws NoImagesException {
        this.readImages();
        this.init();
        this.initBoard = true;
    }


    private void readImages() throws NoImagesException {
        this.chessImageReader.readImages();
    }


    public void changeFirstColor() {
        this.whitePiecesFirst = !this.whitePiecesFirst;
        this.init();
    }


    public void draw(Graphics2D g) {
        if (initBoard == false) {
            return;
        }
        g.setColor(Color.BLACK);
        Paint lastPaint = g.getPaint();
        g.draw(new Rectangle(x - 1, y - 1, this.sizeOfSquare * 8 + 1, this.sizeOfSquare * 8 + 1));
        g.setPaint(new TexturePaint(boardImage, new Rectangle(x, y, this.sizeOfSquare * 8 / 4, this.sizeOfSquare * 8 / 4)));
        g.fill(new Rectangle(x, y, this.sizeOfSquare * 8, this.sizeOfSquare * 8));
        g.setPaint(lastPaint);
        for (Piece p : pieces) {
            p.draw(g, this.getColorOfBackground(p.getCoordiantes()));
        }
    }


    public void init() {
        pieces.clear();
        if (this.whitePiecesFirst) {
            this.initPiecesW();
        }
        else {
            this.initPiecesB();
        }
        this.boardImage = (BufferedImage) this.chessImageReader.getChessBoardImage();
    }


    private void initPiecesW()  {
        this.initWhitePiecesW();
        this.initBlackPiecesW();
    }


    private void initPiecesB()  {
        this.initWhitePiecesB();
        this.initBlackPiecesB();
    }


    //
    //Init white pieces.
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //


    private void initWhitePiecesW() {
        this.initWhitePawnsW();
        this.initWhiteKnightsW();
        this.initWhiteCastlesW();
        this.initWhiteBishopsW();
        this.initWhiteKingW();
        this.initWhiteQueenW();
    }


    private void initWhitePiecesB() {
        this.initWhitePawnsB();
        this.initWhiteKnightsB();
        this.initWhiteCastlesB();
        this.initWhiteBishopsB();
        this.initWhiteKingB();
        this.initWhiteQueenB();
    }


    private void initWhitePawnsW() {
        PieceImage whitePawnImages = this.chessImageReader.getPawnW();
        for (int i = 0; i < 8; i++) {
            Pawn p = new Pawn(whitePawnImages);
            p.setCoordinates(new Point(i * sizeOfSquare + x, sizeOfSquare * 1 + y));
            pieces.add(p);
        }
    }


    private void initWhitePawnsB() {
        PieceImage whitePawnImages = this.chessImageReader.getPawnW();
        for (int i = 0; i < 8; i++) {
            Pawn p = new Pawn(whitePawnImages);
            p.setCoordinates(new Point(i * sizeOfSquare + x, sizeOfSquare * 6 + y));
            pieces.add(p);
        }
    }


    private void initWhiteKnightsW() {
        PieceImage whiteKnightImages = this.chessImageReader.getKnightW();
        Knight wk1 = new Knight(whiteKnightImages);
        wk1.setCoordinates(new Point(1 * sizeOfSquare + x, 0 * sizeOfSquare + y));
        Knight wk2 = new Knight(whiteKnightImages);
        wk2.setCoordinates(new Point(6 * sizeOfSquare + x, 0 * sizeOfSquare + y));
        pieces.add(wk1);
        pieces.add(wk2);
    }


    private void initWhiteKnightsB() {
        PieceImage whiteKnightImages = this.chessImageReader.getKnightW();
        Knight wk1 = new Knight(whiteKnightImages);
        wk1.setCoordinates(new Point(1 * sizeOfSquare + x, 7 * sizeOfSquare + y));
        Knight wk2 = new Knight(whiteKnightImages);
        wk2.setCoordinates(new Point(6 * sizeOfSquare + x, 7 * sizeOfSquare + y));
        pieces.add(wk1);
        pieces.add(wk2);
    }


    private void initWhiteCastlesW() {
        PieceImage whiteCastleImages = this.chessImageReader.getCastleW();
        Castle wc1 = new Castle(whiteCastleImages);
        wc1.setCoordinates(new Point(0 * sizeOfSquare + x, 0 * sizeOfSquare + y));
        Castle wc2 = new Castle(whiteCastleImages);
        wc2.setCoordinates(new Point(7 * sizeOfSquare + x, 0 * sizeOfSquare + y));
        pieces.add(wc1);
        pieces.add(wc2);
    }


    private void initWhiteCastlesB() {
        PieceImage whiteCastleImages = this.chessImageReader.getCastleW();
        Castle wc1 = new Castle(whiteCastleImages);
        wc1.setCoordinates(new Point(0 * sizeOfSquare + x, 7 * sizeOfSquare + y));
        Castle wc2 = new Castle(whiteCastleImages);
        wc2.setCoordinates(new Point(7 * sizeOfSquare + x, 7 * sizeOfSquare + y));
        pieces.add(wc1);
        pieces.add(wc2);
    }


    private void initWhiteBishopsW() {
        PieceImage whiteBishopImages = this.chessImageReader.getBishopW();
        Bishop wb1 = new Bishop(whiteBishopImages);
        wb1.setCoordinates(new Point(2 * sizeOfSquare + x, 0 * sizeOfSquare + y));
        Bishop wb2 = new Bishop(whiteBishopImages);
        wb2.setCoordinates(new Point(5 * sizeOfSquare + x, 0 * sizeOfSquare + y));
        pieces.add(wb1);
        pieces.add(wb2);
    }


    private void initWhiteBishopsB() {
        PieceImage whiteBishopImages = this.chessImageReader.getBishopW();
        Bishop wb1 = new Bishop(whiteBishopImages);
        wb1.setCoordinates(new Point(2 * sizeOfSquare + x, 7 * sizeOfSquare + y));
        Bishop wb2 = new Bishop(whiteBishopImages);
        wb2.setCoordinates(new Point(5 * sizeOfSquare + x, 7 * sizeOfSquare + y));
        pieces.add(wb1);
        pieces.add(wb2);
    }


    private void initWhiteKingW() {
        King wK = new King(this.chessImageReader.getKingW());
        wK.setCoordinates(new Point(3 * sizeOfSquare + x, 0 * sizeOfSquare + y));
        pieces.add(wK);
    }


    private void initWhiteKingB() {
        King wK = new King(this.chessImageReader.getKingW());
        wK.setCoordinates(new Point(4 * sizeOfSquare + x, 7 * sizeOfSquare + y));
        pieces.add(wK);
    }


    private void initWhiteQueenW() {
        Queen wq = new Queen(this.chessImageReader.getQueenW());
        wq.setCoordinates(new Point(4 * sizeOfSquare + x, 0 * sizeOfSquare + y));
        pieces.add(wq);
    }


    private void initWhiteQueenB() {
        Queen wq = new Queen(this.chessImageReader.getQueenW());
        wq.setCoordinates(new Point(3 * sizeOfSquare + x, 7 * sizeOfSquare + y));
        pieces.add(wq);
    }


    //
    //Init black pieces.
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //


    private void initBlackPiecesW() {
        this.initBlackPawnsW();
        this.initBlackKnightsW();
        this.initBlackCastlesW();
        this.initBlackBishopsW();
        this.initBlackKingW();
        this.initBlackQueenW();
    }


    private void initBlackPiecesB() {
        this.initBlackPawnsB();
        this.initBlackKnightsB();
        this.initBlackCastlesB();
        this.initBlackBishopsB();
        this.initBlackKingB();
        this.initBlackQueenB();
    }


    private void initBlackPawnsW() {
        PieceImage blackPawnImages = this.chessImageReader.getPawnB();
        for (int i = 0; i < 8; i++) {
            Pawn p = new Pawn(blackPawnImages);
            p.setCoordinates(new Point(i * sizeOfSquare + x, sizeOfSquare * 6 + y));
            pieces.add(p);
        }
    }


    private void initBlackPawnsB() {
        PieceImage blackPawnImages = this.chessImageReader.getPawnB();
        for (int i = 0; i < 8; i++) {
            Pawn p = new Pawn(blackPawnImages);
            p.setCoordinates(new Point(i * sizeOfSquare + x, sizeOfSquare * 1 + y));
            pieces.add(p);
        }
    }


    private void initBlackKnightsW() {
        PieceImage blackKnightsImages = this.chessImageReader.getKnightB();
        Knight bk1 = new Knight(blackKnightsImages);
        bk1.setCoordinates(new Point(1 * sizeOfSquare + x, 7 * sizeOfSquare + y));
        Knight bk2 = new Knight(blackKnightsImages);
        bk2.setCoordinates(new Point(6 * sizeOfSquare + x, 7 * sizeOfSquare + y));
        pieces.add(bk1);
        pieces.add(bk2);
    }


    private void initBlackKnightsB() {
        PieceImage blackKnightsImages = this.chessImageReader.getKnightB();
        Knight bk1 = new Knight(blackKnightsImages);
        bk1.setCoordinates(new Point(1 * sizeOfSquare + x, 0 * sizeOfSquare + y));
        Knight bk2 = new Knight(blackKnightsImages);
        bk2.setCoordinates(new Point(6 * sizeOfSquare + x, 0 * sizeOfSquare + y));
        pieces.add(bk1);
        pieces.add(bk2);
    }


    private void initBlackCastlesW() {
        PieceImage blackCastleImages = this.chessImageReader.getCastleB();
        Castle bc1 = new Castle(blackCastleImages);
        bc1.setCoordinates(new Point(0 * sizeOfSquare + x, 7 * sizeOfSquare + y));
        Castle bc2 = new Castle(blackCastleImages);
        bc2.setCoordinates(new Point(7 * sizeOfSquare + x, 7 * sizeOfSquare + y));
        pieces.add(bc1);
        pieces.add(bc2);
    }


    private void initBlackCastlesB() {
        PieceImage blackCastleImages = this.chessImageReader.getCastleB();
        Castle bc1 = new Castle(blackCastleImages);
        bc1.setCoordinates(new Point(0 * sizeOfSquare + x, 0 * sizeOfSquare + y));
        Castle bc2 = new Castle(blackCastleImages);
        bc2.setCoordinates(new Point(7 * sizeOfSquare + x, 0 * sizeOfSquare + y));
        pieces.add(bc1);
        pieces.add(bc2);
    }


    private void initBlackBishopsW() {
        PieceImage blackBishopImages = this.chessImageReader.getBishopB();
        Bishop bb1 = new Bishop(blackBishopImages);
        bb1.setCoordinates(new Point(2 * sizeOfSquare + x, 7 * sizeOfSquare + y));
        Bishop bb2 = new Bishop(blackBishopImages);
        bb2.setCoordinates(new Point(5 * sizeOfSquare + x, 7 * sizeOfSquare + y));
        pieces.add(bb1);
        pieces.add(bb2);
    }


    private void initBlackBishopsB() {
        PieceImage blackBishopImages = this.chessImageReader.getBishopB();
        Bishop bb1 = new Bishop(blackBishopImages);
        bb1.setCoordinates(new Point(2 * sizeOfSquare + x, 0 * sizeOfSquare + y));
        Bishop bb2 = new Bishop(blackBishopImages);
        bb2.setCoordinates(new Point(5 * sizeOfSquare + x, 0 * sizeOfSquare + y));
        pieces.add(bb1);
        pieces.add(bb2);
    }


    private void initBlackKingW() {
        King bK = new King(this.chessImageReader.getKingB());
        bK.setCoordinates(new Point(3 * sizeOfSquare + x, 7 * sizeOfSquare + y));
        pieces.add(bK);
    }


    private void initBlackKingB() {
        King bK = new King(this.chessImageReader.getKingB());
        bK.setCoordinates(new Point(4 * sizeOfSquare + x, 0 * sizeOfSquare + y));
        pieces.add(bK);
    }


    private void initBlackQueenW() {
        Queen bq = new Queen(this.chessImageReader.getQueenB());
        bq.setCoordinates(new Point(4 * sizeOfSquare + x, 7 * sizeOfSquare + y));
        pieces.add(bq);
    }


    private void initBlackQueenB() {
        Queen bq = new Queen(this.chessImageReader.getQueenB());
        bq.setCoordinates(new Point(3 * sizeOfSquare + x, 0 * sizeOfSquare + y));
        pieces.add(bq);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //
    //Take out pieces.
    //////////////////////////////////////////////////////////////////////////////////////////
    //


    public void takeOut() throws IOException {
        pieces.clear();
        lastX = x + 9 * this.sizeOfSquare;
        lastY = y + 1 * this.sizeOfSquare;
        this.takeOutPawns();
        this.takeOutCastles();
        this.takeOutKnights();
        this.takeOutBishops();
        this.takeOutQueens();
        this.takeOutKings();
    }


    private void takeOutPawns() {
        PieceImage blackPawnImages = this.chessImageReader.getPawnB();
        PieceImage whitePawnImages = this.chessImageReader.getPawnW();
        for (int i = 0; i < 8; i++) {
            Pawn blackPawn = new Pawn(blackPawnImages);
            Pawn whitePawn = new Pawn(whitePawnImages);
            whitePawn.setCoordinates(new Point(lastX, lastY));
            this.nextPlace();
            blackPawn.setCoordinates(new Point(lastX, lastY));
            this.nextPlace();
            pieces.add(whitePawn);
            pieces.add(blackPawn);
        }
    }


    private void takeOutCastles() {
        PieceImage blackCastleImages = this.chessImageReader.getCastleB();
        PieceImage whiteCastleImages = this.chessImageReader.getCastleW();
        for (int i = 0; i < 2; i++) {
            Castle blackCastle = new Castle(blackCastleImages);
            Castle whiteCastle = new Castle(whiteCastleImages);
            whiteCastle.setCoordinates(new Point(lastX, lastY));
            this.nextPlace();
            blackCastle.setCoordinates(new Point(lastX, lastY));
            this.nextPlace();
            pieces.add(whiteCastle);
            pieces.add(blackCastle);
        }
    }


    private void takeOutKnights() {
        PieceImage blackKnightImages = this.chessImageReader.getKnightB();
        PieceImage whiteKnightImages = this.chessImageReader.getKnightW();
        for (int i = 0; i < 2; i++) {
            Knight blackKnight = new Knight(blackKnightImages);
            Knight whiteKnight = new Knight(whiteKnightImages);
            whiteKnight.setCoordinates(new Point(lastX, lastY));
            this.nextPlace();
            blackKnight.setCoordinates(new Point(lastX, lastY));
            this.nextPlace();
            pieces.add(whiteKnight);
            pieces.add(blackKnight);
        }
    }


    private void takeOutBishops() {
        PieceImage blackBishopImages = this.chessImageReader.getBishopB();
        PieceImage whiteBishopImages = this.chessImageReader.getBishopW();
        for (int i = 0; i < 2; i++) {
            Bishop blackBishop = new Bishop(blackBishopImages);
            Bishop whiteBishop = new Bishop(whiteBishopImages);
            whiteBishop.setCoordinates(new Point(lastX, lastY));
            this.nextPlace();
            blackBishop.setCoordinates(new Point(lastX, lastY));
            this.nextPlace();
            pieces.add(whiteBishop);
            pieces.add(blackBishop);
        }
    }


    private void takeOutQueens() {
        Queen whiteQueen = new Queen(this.chessImageReader.getQueenW());
        Queen blackQueen = new Queen(this.chessImageReader.getQueenB());
        whiteQueen.setCoordinates(new Point(lastX, lastY));
        this.nextPlace();
        blackQueen.setCoordinates(new Point(lastX, lastY));
        this.nextPlace();
        this.pieces.add(whiteQueen);
        this.pieces.add(blackQueen);
    }


    private void takeOutKings() {
        King whiteKing = new King(this.chessImageReader.getKingW());
        King blackKing = new King(this.chessImageReader.getKingB());
        whiteKing.setCoordinates(new Point(lastX, lastY));
        this.nextPlace();
        blackKing.setCoordinates(new Point(lastX, lastY));
        this.nextPlace();
        this.pieces.add(whiteKing);
        this.pieces.add(blackKing);
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public int getColorOfBackground(Point c) {
        int sx = c.getX();
        int sy = c.getY();
        sx = (sx - x) / this.sizeOfSquare;
        sy = (sy - y) / this.sizeOfSquare;
        if ((sx >= 8) || (sy >= 8)) {
            return Board.OUT_OF_BOARD;
        }
        if ((sy % 2 == 1) && (sx % 2 == 1)) {
            return Board.WHITE_SQUARE;
        }
        if ((sy % 2 == 1) && (sx % 2 == 0)) {
            return Board.BLACK_SQUARE;
        }
        if ((sy % 2 == 0) && (sx % 2 == 1)) {
            return Board.BLACK_SQUARE;
        }
        if ((sy % 2 == 0) && (sx % 2 == 0)) {
            return Board.WHITE_SQUARE;
        }
        return Board.OUT_OF_BOARD;
    }


    private void nextPlace() {
        if (lastX + this.sizeOfSquare >= (9 + 6) * this.sizeOfSquare + 30) {
            lastX = x + 9 * this.sizeOfSquare;
            lastY = lastY + this.sizeOfSquare;
        }
        else {
            lastX = lastX + this.sizeOfSquare;
        }
    }


    public void coorectCoordinates(Piece p) {
        Point c = p.getCoordiantes();
        int sx = c.getX();
        int sy = c.getY();
        sx = (sx - x) / sizeOfSquare;
        sy = (sy - y) / sizeOfSquare;
        if ((sx > 8) && (sy > 8)) {
            nextPlace();
            p.setCoordinates(new Point(lastX, lastY));
            return;
        }
        else {
            p.setCoordinates(new Point(sx * sizeOfSquare + x, sy * sizeOfSquare + y));
        }
    }


    public int choosePeace(Point coordinates) {
        int i = 0;
        for (Piece p : pieces) {
            if (p.isSelected(coordinates)) {
                return i;
            }
            i++;
        }
        return -1;
    }


    public void movePeace(int index, Point coordinates) {
        Piece p = pieces.get(index);
        p.setCoordinates(coordinates);
        this.coorectCoordinates(p);
    }
}