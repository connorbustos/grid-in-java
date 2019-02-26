package main.lib;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Open Source Library
 */

public class CellSelector extends MouseAdapter {

    private GridPanel gridPanel;

    public CellSelector(GridPanel gp) {
        gridPanel = gp;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point p = e.getPoint();
        int col = 0, row = 0;
        double x = gridPanel.PAD + gridPanel.xInc;
        // find column
        for (int j = 0; j < gridPanel.GRID_SIZE; j++) {
            if (p.x < x) {
                col = j;
                break;
            }
            x += gridPanel.xInc;
        }
        // find row
        double y = gridPanel.PAD + gridPanel.yInc;
        for (int j = 0; j < gridPanel.GRID_SIZE; j++) {
            if (p.y < y) {
                row = j;
                break;
            }
            y += gridPanel.yInc;
        }
        gridPanel.toggleCellColor(row, col);
    }
}
