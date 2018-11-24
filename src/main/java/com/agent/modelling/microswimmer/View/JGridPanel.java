package com.agent.modelling.microswimmer.View;

import static com.agent.modelling.microswimmer.Constants.Constants.DEFAULT_GRID_HEIGHT;
import static com.agent.modelling.microswimmer.Constants.Constants.DEFAULT_GRID_WIDTH;


import javax.swing.*;
import java.awt.*;

public class JGridPanel extends JPanel {
    private final int GRID_VIEW_SCALING_FACTOR = 6;

    private int gridWidth, gridHeight;
    private int xScale, yScale;
    Dimension size;
    private Graphics graphics;
    private Image gridImage;

    public JGridPanel(int height, int width){
        gridHeight = height;
        gridWidth = width;
        size = new Dimension(0,0);
    }

    public Dimension getPreferredSize(){
        return new Dimension(gridWidth * GRID_VIEW_SCALING_FACTOR, gridHeight * GRID_VIEW_SCALING_FACTOR);
    }

    public void preparePaint(){
        if(! size.equals(getSize())){
            size = getSize();
            gridImage = this.createImage(size.width, size.height);
            graphics = gridImage.getGraphics();

            xScale = size.width / gridWidth;

            if(xScale < 1){
                xScale = GRID_VIEW_SCALING_FACTOR;
            }

            yScale = size.height / gridHeight;

            if(yScale < 1){
                yScale = GRID_VIEW_SCALING_FACTOR;
            }
        }
    }

    public void draw(int x, int y, Color color){
        graphics.setColor(color);
        graphics.fillRect(x * xScale, y * yScale, xScale - 1, yScale - 1);
    }

    public void paint(Graphics graphic){
        Dimension currentSize = getSize();
        if(gridImage != null){
            if(size.equals(currentSize)){
                graphics.drawImage(gridImage, 0, 0 ,null);
            }
        }else{
            graphic.drawImage(gridImage, 0, 0, currentSize.width, currentSize.height, null);
        }
    }
}
