
package graphics;

import java.util.Observable;
import gameoflife.PetriDish;
import gameoflife.Cell;


/**
 *
 * @author p0073862, Sean Mizen
 */
public class KModel extends Observable {

    private static final int WIDTH = 600;
   
    private PetriDish grid;
  
    public KModel (int xWidth, int yHeight) {
         grid = new PetriDish(xWidth, yHeight);
    }

    public Cell[][] getShapes() {
        return grid.getGrid();
    }
   
   
    private void sendUpdate() {
        setChanged();
        notifyObservers();
    }

    void move() {
        grid.iterate();
        sendUpdate();
    }
}
