package main.lib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 * Open Source Library
 */

public class GridPanel extends JPanel {
    
    double xInc, yInc;
    protected final int GRID_SIZE = 25;
    protected final int DRAW = 0,
            FILL = 1,
            PAD = 20;
    int[][] cells;

    private Color colorWhenPressed = Color.MAGENTA;
    
    public GridPanel() {
        initCells();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        double w = getWidth();
        double h = getHeight();
        xInc = (w - 2 * PAD) / GRID_SIZE;
        yInc = (h - 2 * PAD) / GRID_SIZE;
        // row lines
        double x1 = PAD, y1 = PAD, x2 = w - PAD, y2 = h - PAD;
        for (int j = 0; j <= GRID_SIZE; j++) {
            g2.draw(new Line2D.Double(x1, y1, x2, y1));
            y1 += yInc;
        }
        // col lines
        y1 = PAD;
        for (int j = 0; j <= GRID_SIZE; j++) {
            g2.draw(new Line2D.Double(x1, y1, x1, y2));
            x1 += xInc;
        }
        // fill cells
        g2.setPaint(colorWhenPressed);
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                if (cells[row][col] == FILL) {
                    x1 = PAD + col * xInc + 1;
                    y1 = PAD + row * yInc + 1;
                    g2.fill(new Rectangle2D.Double(x1, y1, xInc - 1, yInc - 1));
                }
            }
        }
    }

    public void toggleCellColor(int row, int col) {
        int mode = DRAW;
        if (cells[row][col] == DRAW) {
            mode = FILL;
        }
        cells[row][col] = mode;
        repaint();
    }

    private void initCells() {
        cells = new int[GRID_SIZE][GRID_SIZE];
        for (int[] cell : cells) {
            for (int col = 0; col < cells[0].length; col++) {
                cell[col] = DRAW;
            }
        }
//        for (int row = 0; row < cells.length; row++) {
//            for (int col = 0; col < cells[0].length; col++) {
//                cells[row][col] = DRAW;
//            }
//        }
    }
}
