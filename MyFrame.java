
/**
 * Write a description of class MyFrame here.
 *
 * @author (Charles Easter)
 * @version (DATE)
 */

import javax.swing.*;

public class MyFrame extends JFrame{
   
   GraphicsClass graphic = new GraphicsClass();
   
   public MyFrame(){
       this.setSize(Hex.getXMax() + 16, Hex.getYMax() + 39);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.add(graphic);
       this.setVisible(true);
    }
}
