import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class Panel extends JPanel implements ActionListener {
    int w = 1500, h = 1500;
    double scale = 0.7;
    Timer time;
    private int[][] arr;
    Board board = new Board(100, 100);
    int fieldX = board.getX();
    int fieldY = board.getY();

    //Constructor which creates the panel and also adds a mouse listener.
    Panel() {
        time = new Timer(20, this);
        this.setPreferredSize(new Dimension(w, h));
        this.setBackground(Color.DARK_GRAY);
        board.initBoard();
        arr = board.getField();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                int i = Math.round(e.getX() / 15);
                int j = Math.round(e.getY() / 15);
                if (arr[i][j] == 0)
                    arr[i][j] = 1;
                else
                    arr[i][j] = 0;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Release");
                repaint();
            }
        });
    }

    /* This method initially checks the array in order to understand
     * which cells will live through the generation.
     * It then changes the array to adapt to the new generation.
     */

    public void nextGen() {
        if (Window.start) {
            for (int i = 1; i < fieldX - 1; i++) {
                for (int j = 1; j < fieldY - 1; j++) {
                    int counter = 0;
                    //Checks every cell to see if it will survive throught the next gen or not.
                    if (arr[i - 1][j - 1] == 1 || arr[i - 1][j - 1] == 3) {
                        counter++;
                    }
                    if (arr[i - 1][j] == 1 || arr[i - 1][j] == 3) {
                        counter++;
                    }
                    if (arr[i - 1][j + 1] == 1 || arr[i - 1][j + 1] == 3) {
                        counter++;
                    }
                    if (arr[i][j - 1] == 1 || arr[i][j - 1] == 3) {
                        counter++;
                    }
                    if (arr[i][j + 1] == 1 || arr[i][j + 1] == 3) {
                        counter++;
                    }
                    if (arr[i + 1][j - 1] == 1 || arr[i + 1][j - 1] == 3) {
                        counter++;
                    }
                    if (arr[i + 1][j] == 1 || arr[i + 1][j] == 3) {
                        counter++;
                    }
                    if (arr[i + 1][j + 1] == 1 || arr[i + 1][j + 1] == 3) {
                        counter++;
                    }
                    //Creates new gen
                    if ((arr[i][j] == 1) && (counter == 2 || counter == 3)) {
                        System.out.println("Survived");
                    } else if (arr[i][j] == 0 && counter == 3) {
                        arr[i][j] = 2;
                    } else if (arr[i][j] == 1 && (counter < 2 || counter > 3)) {
                        arr[i][j] = 3;
                    }
                    //System.out.println(counter);

                }
            }
            for (int i = 1; i < board.getX() - 1; i++) {
                for (int j = 1; j < board.getY() - 1; j++) {
                    if (arr[i][j] == 2) {
                        arr[i][j] = 1;
                    } else if (arr[i][j] == 3) {
                        arr[i][j] = 0;
                    }
                }
            }

        }
    }
    /* This method takes takes an instance of the graphics class as a paramater.
     * Its purpose is to draw the board and the cells
     */

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < board.getX(); i++) {
            for (int j = 0; j < board.getY(); j++) {
                if (arr[i][j] == 0) {
                    g2.setColor(Color.BLACK);
                    g2.drawRect(i * 15, j * 15, 15, 15);
                } else {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(i * 15, j * 15, 15, 15);
                }
            }
        }
        time.start();

    }

    // This method repaints the panel continuously.
    @Override
    public void actionPerformed(ActionEvent e) {
        nextGen();
        repaint();
    }
}

