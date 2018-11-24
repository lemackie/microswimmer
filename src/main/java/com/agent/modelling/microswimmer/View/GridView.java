package com.agent.modelling.microswimmer.View;

import com.agent.modelling.microswimmer.Constants.Constants;
import com.agent.modelling.microswimmer.Grid.Grid;
import com.agent.modelling.microswimmer.Models.Microswimmer;

import java.awt.*;
import java.util.LinkedHashMap;
import javax.swing.*;

public class GridView extends JFrame {

    private static final Color emptyColor = Color.white;
    private static final Color unknownColor = Color.gray;
    private static final Color collisionColor = Color.red;
    private static final Color microswimmerColor = Color.blue;

    private final String STEP = "Step: ";
    private final String numberOfMicroswimmers = "Total Microswimmers: ";
    private Grid grid;
    private JLabel stepLabel, microswimmerCount;
    private JGridPanel gridPanel;
    private Map<Class, Color> colors;

    public GridView(int gridHeight, int gridWidth){

        colors = new LinkedHashMap<>();
        setTitle("Microswimmer Simulation");
        stepLabel = new JLabel(STEP, JLabel.CENTER);
        microswimmerCount = new JLabel(numberOfMicroswimmers, JLabel.CENTER);
        setLocation(100, 50);
        gridPanel = new JGridPanel(gridHeight, gridWidth);

        Container contents = getContentPane();
        contents.add(stepLabel, BorderLayout.NORTH);
        contents.add(gridPanel, BorderLayout.CENTER);
        contents.add(microswimmerCount, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public void setColor(Class Microswimmer, Color color)
    {
        colors.put(, color);
    }

    private Color getColor()
    {
        Color color = colors.get();
        if (color = null){
            return unknownColor;
        }
        else {
            return color;
        }
    }

    public void Status(int step, Grid grid)
    {
        if(!isVisible()){
            setVisible(true);
        }
        stepLabel.setText(STEP + step);
        JGridPanel.preparePaint();

        for(int row = 0; row < Constants.DEFAULT_GRID_HEIGHT; row++){
            for(int col =0; col< Constants.DEFAULT_GRID_WIDTH; col++){
                if(microswimmerCount! = null)
                {
                    JGridPanel.draw(color,row,getColor());
                }
                else{
                    JGridPanel.draw(color,row,emptyColor);
                }
                
            }
        }
    }

}

