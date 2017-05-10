
package graphics;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author p0073862
 */
public class KView implements Observer {

    private JFrame frame;
    private KModel model;
    private KController controller;
    private KPanel panel;
    private JButton moveBtn;

    public KView(KModel model,int xWidth, int yHeight) {
        this.model = model;
        frame = new JFrame("Life");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        JPanel buttonPanel = makeButtonPanel();
        contentPane.add(buttonPanel);
        panel = new KPanel(model, 80, xWidth, yHeight);
        frame.add(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setController(KController controller) {
        this.controller = controller;
    }

    @Override
    public void update(Observable o, Object arg) {
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    private JPanel makeButtonPanel(){
        JPanel result = new JPanel();
        result.setLayout(new BoxLayout(result, BoxLayout.X_AXIS));
       
      
        /*
        resetBtn = new JButton("Reset");
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                controller.reset();
            }
        });

        result.add(resetBtn);*/
        
        moveBtn = new JButton("Move");
        moveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   controller.move();
               
            }
        });
        result.add(moveBtn);
        
        /*
        but1Btn = new JButton("Load");
        but1Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.load();
            }
                catch (FileNotFoundException ep) {
                    
                }
            }
        });
        
        result.add(but1Btn);
        but2Btn = new JButton("Save");
        result.add(but2Btn);
        but2Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                controller.save();
                }
                catch (FileNotFoundException ex) {
                        
                        }
            }
        });*/

        result.add(Box.createHorizontalGlue());

        return result;
    }
}
