
package gameoflife;

/**
 *
 * @author Sean Mizen
 */
public class Cell extends Object{
    
    private int state;
    
    public Cell(int state){
        this.state = state;
    }
    
    public void iterate(int adjacency){
        if(this.state == 0){//Cell is dead.
            if(adjacency == 3){
                this.toggle();
            }
        }
        else{//Cell is alive!
             //Will live only if there are 2 or 3 adjacent living cells.
            if((adjacency < 2) || (4 < adjacency)){
                this.toggle();
            }
        }
    }
    
    public Cell Clone() throws CloneNotSupportedException{
        
        return this;
        
    }
    
    public void toggle(){
        this.state = (this.state + 1)%2;
    }
    
    public int getState(){
        return this.state;
    }
    
    public void setState(int newState){
        this.state = newState;
    }
    
}
