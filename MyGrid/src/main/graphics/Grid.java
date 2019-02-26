package main.graphics;

import javax.swing.JFrame;
import main.lib.*;

public class Grid {

    private final int WIDTH = 720;
    private final int HEIGHT = 720;
    private final int LOCATION = 200;

    private JFrame frame;
    private GridPanel gridPanel;
    private CellSelector cellSelector;

    public Grid() {
        this.gridPanel = new GridPanel();
        this.cellSelector = new CellSelector(gridPanel);
        this.gridPanel.addMouseListener(cellSelector);
        this.frame = new JFrame("Grid");
        this.frame.setSize(WIDTH, HEIGHT);
        this.frame.setLocation(LOCATION, LOCATION);
        this.frame.getContentPane().add(gridPanel);
        this.frame.setVisible(true);
        this.frame.setResizable(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
