package utils;

public class Move {
    private Piece piece;
    private int[] start;
    private int[] end;
    private int[] capture;   // position of the piece being captured, optional

    public Move(Piece piece, int[] start, int[] end) {
        this.piece = piece;
        this.start = start;
        this.end = end;
        this.capture = null;
    }
    public Move(Piece piece, int[] start, int[] end, int[] capture) {
        this.piece = piece;
        this.start = start;
        this.end = end;
        this.capture = capture;
    }
    public Move(Piece piece, int startX, int startY, int endX, int endY) {
        this.piece = piece;
        this.start = new int[] {startX, startY};
        this.end = new int[] {endX, endY};
        this.capture = null;
    }
    public Move(Piece piece, int startX, int startY, int endX, int endY, int captureX, int captureY) {
        this.piece = piece;
        this.start = new int[] {startX, startY};
        this.end = new int[] {endX, endY};
        this.capture = new int[] {captureX, captureY};
    }

    public Piece getPiece() {
        return piece;
    }

    public int[] getStart() {
        return start;
    }

    public int[] getEnd() {
        return end;
    }

    public int[] getCapture() {
        return capture;
    }

    @Override
    public String toString() {
        return piece + " from " + start[0] + ", " + start[1] + " to " + end[0] + ", " + end[1];
    }
}
