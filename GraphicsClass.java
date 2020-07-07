
/**
 * Write a description of class Graphics_Demo here.
 *
 * @author (Charles Easter)
 * @version (DATE)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicsClass extends JPanel implements ActionListener{
    
    

    @Override
    public void actionPerformed(ActionEvent e){
        //TODO   animating stuff (Bro Code vid 4:12)
        //      review and tidy this up.  replace 'this' and 'that'
        for (int j = 0; j < Hex.getNumRows(); j++) {
            for (int i = 0; i < Hex.getRowLength(); i++) {
                if (Setup.Grid[j][i].getCount() == Hex.getPassOn()) {
                    Hex.disperseShim(Setup.Grid, j, i);
                } else if (Setup.Grid[j][i].getCount() == 0) { 
                    if (Hex.getOften()) {
                        Setup.Grid[j][i].giveShim();
                    }
                }
            }
        }

        for (int j = 0; j < Hex.getNumRows(); j++) {
            for (int i = 0; i < Hex.getRowLength(); i++) {
                Setup.Grid[j][i].draw();
                Setup.Grid[j][i].decCount();
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        Hex.setG((Graphics2D) g);
        //Graphics g2D = (Graphics2D) g;

        Hex.getG().setColor(Color.MAGENTA);

        for (int j = 0; j < Hex.getNumRows(); j++) {
            for (int i = 0; i < Hex.getRowLength(); i++) {
                Setup.Grid[j][i].draw();
            }
        }
    }
}
