
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
        //      sort out random number
        //      figure how to bring in g for draw
        for (int j = 0; j < Hex.getNumRows(); j++) {
            for (int i = 0; i < Hex.getRowLength(); i++) {
                // if (Setup.Grid[j][i].getCount() > this && 
                    // Setup.Grid[j][i].getCount() < that) {
                    // Hex.disperseShim(Setup.Grid, j, i);
                // } else if (Setup.Grid[j][i].getCount() == 0) { 
                    // if (Hex.getOften()) {
                        // Setup.Grid[j][i].giveShim();
                    // }
                // }
            }
        }

        for (int j = 0; j < Hex.getNumRows(); j++) {
            for (int i = 0; i < Hex.getRowLength(); i++) {
                //Setup.Grid[j][i].draw(g);
                Setup.Grid[j][i].decCount();
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        Graphics g2D = (Graphics2D) g;

        g2D.setColor(Color.MAGENTA);

        for (int j = 0; j < Hex.getNumRows(); j++) {
            for (int i = 0; i < Hex.getRowLength(); i++) {
                Setup.Grid[j][i].draw(g2D);
            }
        }
    }
}
