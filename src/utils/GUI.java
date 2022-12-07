package utils;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GUI {
    private JFrame window;
    private JPanel boardPanel;
    private JPanel[][] backgroundPanel; // black-and-white-alternating blocks in background
    private ChessBoard board;

    /**
     * Initialize GUI class.
     * 
     * @author mqcreaple
     * @param board The initial chess board.
     */
    public GUI(ChessBoard board) {
        this.board = board;
        this.window = new JFrame();
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setSize(600, 600);
        this.boardPanel = new JPanel();
        this.boardPanel.setLayout(new GridLayout(ChessBoard.WIDTH, ChessBoard.HEIGHT));
        this.backgroundPanel = new JPanel[8][8];

        // initialize each block of background and chess pieces
        for (int i = 0; i < ChessBoard.WIDTH; i++) {
            for (int j = 0; j < ChessBoard.HEIGHT; j++) {
                backgroundPanel[i][j] = new JPanel();
                backgroundPanel[i][j].setLayout(new BoxLayout(backgroundPanel[i][j], 0));
                // I'm assuming that boxlayout will take all the space, so the image is displayed
                // but still not sure why flowLayout doesn't work when I overloaded getPreferredSize
                Color curCorlor = ((i + j) % 2 == 0) ? new Color(65, 65, 65) : new Color(220, 220, 220);
                backgroundPanel[i][j]
                        .setBackground(curCorlor);

                if (board.getBoard()[i][j] != null) {
                    // set corresponding image to label on index (i, j)
                    ImagePanel chessLabel = new ImagePanel("resource/" + board.getBoard()[i][j].getIconFile());
                    //// chessLabel.setBackground(curCorlor);
                    chessLabel.setOpaque(false);
                    backgroundPanel[i][j].add(chessLabel);
                }
                this.boardPanel.add(backgroundPanel[i][j], i, j);
            }
        }
        this.window.add(this.boardPanel);
        this.window.setVisible(true);
    }

    /**
     * Apply a move to show it on the GUI.
     * This method would not check if the move is valid.
     * @author mqcreaple
     * @param move the move being performed
     */
    public void applyMove(Move move) {
        int[] start = move.getStart();
        int[] end = move.getEnd();
        int[] capture = move.getCapture();
        if(capture != null) {
            backgroundPanel[capture[0]][capture[1]].removeAll();
        }
        backgroundPanel[end[0]][end[1]].add(backgroundPanel[start[0]][start[1]].getComponent(0));
        backgroundPanel[start[0]][start[1]].removeAll();
    }

    public static void validateAndRepaint(Component comp) {
        do {
            comp.validate();
            comp.repaint();
        } while ((comp = comp.getParent()) != null);
    }
}
