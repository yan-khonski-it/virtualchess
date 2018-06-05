package myprojects.chessproject.virtualchess.board;


import java.io.IOException;


public class NoImagesException extends IOException {


    private String excpetion;


    public NoImagesException() {
        this.excpetion = "";
    }


    public NoImagesException(String exc) {
        this.excpetion = exc;
    }


    public String getException() {
        return this.excpetion;
    }
}