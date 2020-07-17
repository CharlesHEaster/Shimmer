
/**
 * Write a description of class NormHex here.
 *
 * @author (Charles Easter)
 * @version (DATE)
 */

import java.awt.*;
import java.util.Arrays;

public class NormHex extends Hex
{
    public NormHex(int ex, int why){ 
        super(ex, why);     
    }

    @Override
    public int[] getPointsX(){
        int A = this.getX();
        int B = A + (Hex.getSize() / 2);
        int C = B + Hex.getSize();
        int D = A + Hex.getWidth();
        int E = C;
        int F = B;
        int[] arr = {A, B, C, D, E, F};
        return arr;
    }

    @Override
    public int[] getPointsY(){
        int A = this.getY();
        int B = A - (Hex.getHeight() / 2);
        int C = B;
        int D = A;
        int E = A + (Hex.getHeight() / 2);
        int F = E;
        int[] arr = {A, B, C, D, E, F};
        return arr;
    }

    @Override
    public void draw(){
        Graphics g = Hex.getG();
        int[] x = this.getPointsX();
        int[] y = this.getPointsY();
        if (this.getShim()) {
            g.fillPolygon(x, y, 6);
        } else if (Setup.getGridOn()){
            g.drawPolygon(x, y, 6);
        }

    }
}
