
package graphics;
/**
 *
 * @author p0073862, Sean Mizen
 */
public class Main {
    public static void main(int[] args){
        KModel model = new KModel(args[0],args[1]);
        KView view = new KView(model,args[0],args[1]);
        KController controller = new KController(model, view);
        view.setController(controller);
        model.addObserver(view);
        view.update(model, null);
    }
}
