
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
    public static int t = 1000;
    Timer timer = new Timer(GraphicsClass.getT(), this);

    public static void setT(int tee){
        GraphicsClass.t = tee;
    }

    public static void setT(String str){
        int tee = Integer.parseInt(str);
        GraphicsClass.setT(tee);
    }

    public static int getT(){
        return GraphicsClass.t;
    }

    public GraphicsClass(){
        timer.start();    
    }

    @Override
    public void actionPerformed(ActionEvent e){
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
                repaint();
                Setup.Grid[j][i].decCount();
            }
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        Hex.setG((Graphics2D) g);

        Hex.getG().setColor(Color.MAGENTA);

        for (int j = 0; j < Hex.getNumRows(); j++) {
            for (int i = 0; i < Hex.getRowLength(); i++) {
                Setup.Grid[j][i].draw();
            }
        }
    }
}
