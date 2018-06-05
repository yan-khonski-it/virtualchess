package myprojects.chessproject.virtualchess.geometry;


public class Point {


    private int x;
    private int y;


    public Point() {
        this.x = 0;
        this.y = 0;
    }


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return this.x;
    }


    public int getY() {
        return this.y;
    }


    @Override
    public String toString() {
        return "(" + x + "; " + y + ")";
    }


    public void add(int dx, int dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }
}