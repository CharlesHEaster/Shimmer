
/**
 * Thanks /u/GioVoi for the advise
 *
 * @author (Charles Easter)
 *
 */
import javax.swing.JOptionPane;
import java.awt.*;

public class Setup
{
    public static Hex[][] Grid;
    private static boolean isGridOn;

    public static void setGridOn(boolean grid){
        Setup.isGridOn = grid;
    }

    public static void setGridOn(int grid){
        Setup.isGridOn = grid == 0;
    }

    public static boolean getGridOn(){
        return Setup.isGridOn;
    }

    public static void main(){
        //Ask for all the variables
        int demo = JOptionPane.showConfirmDialog(null, "Would you like to see a demonstration?", 
                "Demo?",JOptionPane.YES_NO_OPTION);
        boolean isDemo = demo == 0;

        if (isDemo){
            SetupDemo();
        } else {
        	SetupLive();             
        }
        BuildGrid();
    }
    
    public static void SetupDemo() {
    	Setup.setGridOn(false);
        Hex.setSize(10);
        Hex.setXMax(Setup.getScreenWidth() - 100);
        Hex.setYMax(Setup.getScreenHeight() - 100);
        GraphicsClass.setT(10);
        Hex.setLikely(800);
        Hex.setOften(10);
        Hex.setDelay(90);
        Hex.setOnTime(10);
        Hex.setPassOn(3);
    }
    
    public static void SetupLive() {
    	Setup.askGridOn();
        Setup.askSize();
        Setup.askXMax();
        Setup.askYMax();
        Setup.askT();
        Setup.askLikely();
        Setup.askOften();
        Setup.askDelay();
        Setup.askOnTime();
        Setup.askPassOn();  
    }
    
    public static void BuildGrid() {
    	Grid = new Hex[Hex.getNumRows()][Hex.getRowLength()];
        for (int j = 0; j < Hex.getNumRows(); j++) {
            for (int i = 0; i < Hex.getRowLength(); i++) {
                int x = (j * Hex.getColOffset()) + (i * (Hex.getWidth() + Hex.getSize()));
                x = x % Hex.getXMax();
                int y = (j + 1) * Hex.getRowOffset();
                Grid[j][i] = Hex.decernHex(x, y);
            }

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

    //ask user for variables
    public static void askGridOn(){
        Setup.setGridOn(JOptionPane.showConfirmDialog(null, "Would you like to see the grid?", 
                "Grid On?",JOptionPane.YES_NO_OPTION));
    }

    public static void askSize(){
        Hex.setSize(JOptionPane.showInputDialog("What size do you want the hexs?", "10"));
    }

    public static void askXMax(){
        int width = Setup.getScreenWidth() - 100;
        Hex.setXMax(JOptionPane.showInputDialog("What width would you like the grid, in pixels?", width));
    }

    public static void askYMax(){
        int height = Setup.getScreenHeight() - 100;
        Hex.setYMax(JOptionPane.showInputDialog("What height would you like the grid, in pixels?", height));
    }

    public static void askLikely(){
        Hex.setLikely(JOptionPane.showInputDialog("How likely one hex is to see it's neighbor's shimmer \n(X out of 1000, higher number more likely)", "800"));
    }

    public static void askOften(){
        Hex.setOften(JOptionPane.showInputDialog("How often will an idle hex start a shimmer.\n(X out of 1,000,000, higher number more often)", "10"));
    }

    public static void askDelay(){
        Hex.setDelay(JOptionPane.showInputDialog("How many frames a hex will not shimmer after it has shimmered.", "90"));
    }

    public static void askOnTime(){
        Hex.setOnTime(JOptionPane.showInputDialog("How many frames a hex will stay on once it's shimmered.", "10"));
    }

    public static void askPassOn(){
        Hex.setPassOn(JOptionPane.showInputDialog("How many frames a hex will wait until it passes it's shimmer", "3"));
    }

    public static void askT(){
        GraphicsClass.setT(JOptionPane.showInputDialog("How long will each frame be on screen, in milliSeconds", "10"));
    }
}
