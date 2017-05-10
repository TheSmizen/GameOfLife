
package graphics;

import gameoflife.Cell;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author p0073862, Sean Mizen
 */
public class KPanel extends JPanel {

    private final int cellSize;
    private final int width;
    private final int height;
    private static final Color OUTSIDE_COLOR = Color.WHITE;
    private KModel model;
    private java.awt.Shape clipShape;
   

    public KPanel(KModel model, int cellSize,int xWidth, int yHeight) {
        this.cellSize = cellSize;
        this.width = xWidth * cellSize;
        this.height = yHeight * cellSize;
        this.model = model;
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
       
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(OUTSIDE_COLOR);
        g2.fillRect(0, 0, width, height);
        
        drawRoom(g2);
        
    }

    private void drawRoom(Graphics2D g2) {
        
        int x,y;
        x = 0;
        for (Cell[] cellArray:model.getShapes()){
            y = 0;
            for (Cell c : cellArray) {

                switch (c.getState()){
                    case 0:
                        g2.setColor(new Color(250,250,250));
                        g2.fillRect(x*cellSize,y*cellSize, cellSize-1, cellSize-1);
                        break;
                    case 1:
                        g2.setColor(new Color(0, 200, 0));
                        g2.fillRect(x*cellSize,y*cellSize, cellSize-1, cellSize-1);
                        //g2.fillRect(x,y, cellSize/2, cellSize/2);
                        break;
                }
                    
                y++;
                
            }
            
            x++;
            
        }
            
    }
    
}


