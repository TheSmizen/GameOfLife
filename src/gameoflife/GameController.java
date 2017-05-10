package gameoflife;

import graphics.Main;

/**
 * @author Sean Mizen
 * Game of life: Rules based matrix application.
 */
public class GameController {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //-Create Grid class
        //-Create Cell class (For expansion reasons)
        //
        //-Add "Graphics" Package from Arantza
        
        //PetriDish myGrid = new PetriDish();
        int[] dimensions = new int[2];
        dimensions[0] = 10;
        dimensions[1] = 10;
        
        Main gui = new Main();
        
        gui.main(dimensions);
        
    }
    
}
