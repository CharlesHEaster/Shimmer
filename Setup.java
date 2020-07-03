
/**
 * Write a description of class Setup here.
 *
 * @author (Charles Easter)
 * @version (DATE)
 */
import javax.swing.JOptionPane;
public class Setup
{
    public static Hex[][] Grid;
    public static void main(){
        //Ask for all the variables
        Hex.setSize(JOptionPane.showInputDialog("What size do you want the hexs?"));
        Hex.setXMax(JOptionPane.showInputDialog("Width of grid?"));
        Hex.setYMax(JOptionPane.showInputDialog("Height of grid?"));
        // Hex.setLikely(JOptionPane.showInputDialog("How likely one hex is to see it's neighbor's shimmer \n(X out of 1000, higher number more likely)"));
        // Hex.setOften(JOptionPane.showInputDialog("How often an idle hex is to start a shimmer.\n(X out of 1000, higher number more often)"));
        Hex.setDelay(JOptionPane.showInputDialog("How long a hex will not shimmer after it has shimmered."));
        Hex.setOnTime(JOptionPane.showInputDialog("How long a hex will stay on once it's shimmered."));
        Hex.setPassOn(JOptionPane.showInputDialog("How long a hex will wait until it passes it's shimmer"));


        //build grid
        Grid = new Hex[Hex.getNumRows()][Hex.getRowLength()];
        for (int j = 0; j < Hex.getNumRows(); j++) {
            for (int i = 0; i < Hex.getRowLength(); i++) {
                int x = (j * Hex.getColOffset()) + (i * (Hex.getWidth() + Hex.getSize()));
                x = x % Hex.getXMax();
                int y = (j + 1) * Hex.getRowOffset();
                //System.out.print("Grid[" + j + "][" + i + "] ");
                int type = Hex.decernHex(x, y);
                if (type == 0){
                    Grid[j][i] = new Hex(x, y);
                //    System.out.println("Hex");
                } else if (type == 1){
                    Grid[j][i] = new VertSplitHex(x, y);
                //    System.out.println("Vert");
                } else if (type == 2){
                    Grid[j][i] = new WilliamWallace(x, y);
                //    System.out.println("WW");
                } else if (type == 3){
                    Grid[j][i] = new HorzSplitHex(x, y);
                //    System.out.println("Horz");
                } else {
                    System.out.println("Grid[" + j + "][" + i + "] x:" + x + " y:" + y + " YMax:" + Hex.getYMax()); 
                }

                if (type != 4){

                    //System.out.println("Grid[" + j + "][" + i + "]: " + Grid[j][i].toString()); 
                }
            }
            //System.out.println("-----------------------------------------------"); 
        }
    }
}
