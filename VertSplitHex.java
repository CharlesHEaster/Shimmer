
/**
 * Write a description of class VertSplitHex here.
 *
 * @author (Charles Easter)
 * @version (DATE)
 */

import java.awt.*;
import java.util.Arrays;

public class VertSplitHex extends Hex
{
    public VertSplitHex(int ex, int why){ 
        super(ex, why);    
    }

    @Override
    public int[] getPointsX(){
        int A1 = this.getX();
        int B1 = A1 + (Hex.getSize() / 2);
        int C1 = B1 + Hex.getSize();
        int C2 = 0;
        int D2 = Hex.getSize() / 2;
        int E2 = 0;
        int E1 = C1;
        int F1 = B1;

        int[] arr = {A1, B1, C1, E1, F1, C2, D2, E2};
        return arr;
    }

    @Override
    public int[] getPointsY(){
        int A1 = this.getY();
        int B1 = A1 - (Hex.getHeight() / 2);
        int C1 = B1;
        int C2 = B1;
        int D2 = A1;
        int E2 = A1 + (Hex.getHeight() / 2);
        int E1 = E2;
        int F1 = E1;

        int[] arr = {A1, B1, C1, E1, F1, C2, D2, E2};
        return arr;
    }

    @Override
    public void draw(){
        Graphics g = Hex.getG();
        int[] x = this.getPointsX();
        int[] y = this.getPointsY();
        int[] x1 = Arrays.copyOfRange(x, 0, 5);
        int[] x2 = Arrays.copyOfRange(x, 5, 8);
        int[] y1 = Arrays.copyOfRange(y, 0, 5);
        int[] y2 = Arrays.copyOfRange(y, 5, 8);
        if (this.getShim()) {
            g.fillPolygon(x1, y1, 5);
            g.fillPolygon(x2, y2, 3);
        } else if (Setup.getGridOn()){
            g.drawPolygon(x1, y1, 5);
            g.drawPolygon(x2, y2, 3);
        }

    }
}
