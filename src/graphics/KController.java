
package graphics;

/**
 *
 * @author Sean Mizen
 */
public class KController {

    private KModel model;
    private KView view;

    public KController(KModel model, KView view){
        this.model = model;
        this.view = view;
    }

   
    void move() {
        model.move();
    }
    
}
