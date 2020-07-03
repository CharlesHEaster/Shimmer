
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
