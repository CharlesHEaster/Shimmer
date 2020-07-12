
/**
 * Write a description of class Setup here.
 *
 * @author (Charles Easter)
 * @version (DATE)
 */
import javax.swing.JOptionPane;
import java.awt.*;

public class Setup
{
    public static Hex[][] Grid;
    private static boolean gridOn;
    
    public static void setGridOn(boolean grid){
        Setup.gridOn = grid;
    }
    
    public static void setGridOn(int grid){
        Setup.gridOn = grid == 0 ? true: false;
    }
    
    public static boolean getGridOn(){
        return Setup.gridOn;
    }

    public static void main(){
        //Ask for all the variables
        int $demo = JOptionPane.showConfirmDialog(null, "Would you like to see a demonstration?", 
                "Demo?",JOptionPane.YES_NO_OPTION);
        boolean demo = $demo == 0 ? true: false;

        if (demo){
            Setup.setGridOn(false);
            Hex.setSize(10);
            Hex.setXMax(Setup.getScreenWidth() - 100);
            Hex.setYMax(Setup.getScreenHeight() - 100);
            Hex.setLikely(800);
            Hex.setOften(10);
            Hex.setDelay(90);
            Hex.setOnTime(10);
            Hex.setPassOn(3);
        } else {
            Setup.setGridOn(JOptionPane.showConfirmDialog(null, "Would you like to see the grid?", 
                    "Grid On?",JOptionPane.YES_NO_OPTION));
            Hex.setSize(JOptionPane.showInputDialog("What size do you want the hexs?\n(Demo used 10)"));
            int width = Setup.getScreenWidth() - 100;
            Hex.setXMax(JOptionPane.showInputDialog("What width would you like the grid, in pixels?\n(Demo used " + width + ")"));
            int height = Setup.getScreenHeight() - 100;
            Hex.setYMax(JOptionPane.showInputDialog("What height would you like the grid, in pixels?\n(Demo used " + height + ")"));
            Hex.setLikely(JOptionPane.showInputDialog("How likely one hex is to see it's neighbor's shimmer \n(X out of 1000, higher number more likely)\n(Demo used 800)"));
            Hex.setOften(JOptionPane.showInputDialog("How often will an idle hex start a shimmer.\n(X out of 1,000,000, higher number more often)\n(Demo used 10)"));
            Hex.setDelay(JOptionPane.showInputDialog("How long a hex will not shimmer after it has shimmered.\n(Demo used 90)"));
            Hex.setOnTime(JOptionPane.showInputDialog("How long a hex will stay on once it's shimmered.\n(Demo used 10)"));
            Hex.setPassOn(JOptionPane.showInputDialog("How long a hex will wait until it passes it's shimmer\n(Demo used 3)"));
        }
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
        Setup.Grid[Hex.getNumRows() / 2][Hex.getRowLength() / 2].giveShim();
    }

    public static int getScreenWidth() {
        try {
            return Toolkit.getDefaultToolkit().getScreenSize().width;
        } catch (Throwable t) {
            return 800;
        }
    }

    public static int getScreenHeight() {
        try {
            return Toolkit.getDefaultToolkit().getScreenSize().height;
        } catch (Throwable t) {
            return 800;
        }
    }
}
