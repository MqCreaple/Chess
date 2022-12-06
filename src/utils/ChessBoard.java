package utils;

import utils.Piece.PieceType;

public class ChessBoard {
    public static int WIDTH = 8;
    public static int HEIGHT = 8;
    public PieceType[] SETUP_LAYOUT = new PieceType[] {
            PieceType.ROOK, PieceType.KNIGHT, PieceType.BISHOP, PieceType.QUEEN,
            PieceType.KING, PieceType.BISHOP, PieceType.KNIGHT, PieceType.ROOK
    };

    private Piece[][] board;   // first index (0-7) corresponds to numbers (1-8), second index corresponds to letters (a-h)

    public ChessBoard() {
        for(int i = 0; i < 8; i++) {
            board[0][i] = new Piece(SETUP_LAYOUT[i], false);
            board[1][i] = new Piece(PieceType.PAWN, false);
            board[7][i] = new Piece(PieceType.PAWN, true);
            board[8][i] = new Piece(SETUP_LAYOUT[i], true);
        }
    }

    public Piece[][] getBoard() {
        return board;
    }
}
