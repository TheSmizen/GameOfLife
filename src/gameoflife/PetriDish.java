
package gameoflife;

/**
 *
 * @author Sean Mizen
 */
public class PetriDish {
    
    //private ArrayList<ArrayList<Cell>> grid;
    private final boolean toroidal;
    private final int width;
    private final int height;
    private Cell[][] grid;

    public PetriDish(){
        
        toroidal = false;
        width = 10;
        height = 10;
        grid = createGrid(10,10);
        setTestScenario();
        
    }
    public PetriDish(int xWidth, int yHeight){
        
        toroidal = false;
        width = xWidth;
        height = yHeight;
        grid = createGrid(width, height);
        setTestScenario();

    }
    
    private Cell[][] createGrid(int xWidth, int yHeight){
        
        Cell[][] newGrid = new Cell[xWidth][yHeight];
        
        for(int i = 0; i < xWidth; i++){
            for(int j = 0; j < yHeight; j++){
                newGrid[i][j] = new Cell(0);
            }
        }
        

        return newGrid;
        
    }
    
    private void setTestScenario(){
        this.grid[1][1].toggle();
        this.grid[2][1].toggle();
        this.grid[1][2].toggle();
        this.grid[2][2].toggle();
        this.grid[5][5].toggle();
        this.grid[5][6].toggle();
        this.grid[5][7].toggle();
    }
    
    public Cell[][] getGrid(){
        return grid;
    }
    
    public int[] getDimensions(){
        int[] returnArray = new int[2];
        returnArray[0] = grid.length;
        returnArray[1] = grid[0].length;
        return returnArray;
    }
    
    /**
     * Method which displays attributes of an entity for reading on the command line.
     * @return Integer count of adjacent living cells
     */
    private int adjacentCount(int x, int y){
        
        int adjacencyCount = 0;
        
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if (!((i == 0) && (j == 0))){
                    adjacencyCount += getCellState(x+i,y+j);
                }
            }
        }
        
        return adjacencyCount;

    }
    
    
    private Cell[][] cloneGrid(Cell[][] oldGrid){
        Cell[][] newGrid = new Cell[oldGrid.length][oldGrid[0].length];
        
        for(int i = 0; i <oldGrid.length; i++){
            for(int j = 0; j < oldGrid[0].length; j++){
                newGrid[i][j] = new Cell(oldGrid[i][j].getState());
            }
        }
        
        return newGrid;
    }
    
    
    /**
     * Method which iterates all cells in the grid.
     */
    public void iterate(){
        
        Cell[][] newGrid = cloneGrid(grid);
        int adjacencyCount;
        for(int x = 0; x < grid.length; x++){
            
            for(int y = 0; y < grid[0].length; y++){
                
                adjacencyCount = adjacentCount(x,y);
                
                newGrid[x][y].iterate(adjacencyCount);
                
            }
            
        }
        
        this.grid = newGrid;
        
    }
    
    /**
     * Method which returns true or false
     * @return Integer 0 or 1 for dead or alive respectively.
     */
    public int getCellState(int x,int y){
        
        if((x < 0) || (y < 0)){
            return 0;
        }
        if(x >= this.grid[0].length){
            return 0;
        }
        if(y >= this.grid.length){
            return 0;
        }
        
        return this.grid[x][y].getState();
        
    }
    
}
