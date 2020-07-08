
/**
 * Write a description of class WilliamWallace here.
 *
 * @author (Charles Easter)
 * @version (DATE)
 */

import java.awt.*;
import java.util.Arrays;

public class WilliamWallace extends Hex
{

    public WilliamWallace(int ex, int why){ 
        super(ex, why);     
    }

    @Override
    public int[] getPointsX(){
        //4 shapes
        //bottom right
        //A1, B1, C1, {XMax, YMax}
        int A1 = this.getX();
        int B1 = A1 + (Hex.getSize() / 2);
        int C1 = B1 + Hex.getSize();
        int BR = Hex.getXMax();
        //Top Right
        //A2, {XMax, 0}, E2, F2
        int A2 = A1;
        int TR = Hex.getXMax();
        int E2 = Hex.getXMax();
        int F2 = B1;
        //Top Left
        //D3, E3, {0, 0}
        int D3 = Hex.getSize() / 2;
        int E3 = 0;
        int TL = 0;
        //Bottom Left
        //C4, D4, {0, YMax}
        int C4 = 0;
        int D4 = D3;
        int BL = 0;

        int[] arr = {A1, B1, C1, BR, 
                A2, TR, E2, F2, 
                D3, E3, TL, 
                C4, D4, BL};
        return arr;
    }

    @Override
    public int[] getPointsY(){
        //4 shapes
        //bottom right
        //A1, B1, C1, {XMax, YMax}
        int A1 = this.getY();
        int B1 = A1 - (Hex.getHeight() / 2);
        int C1 = B1;
        int BR = Hex.getYMax();
        //Top Right
        //A2, {XMax, 0}, E2, F2
        int A2 = 0;
        int TR = 0;
        int E2 = Hex.getHeight() / 2;
        int F2 = E2;
        //Top Left
        //D3, E3, {0, 0}
        int D3 = 0;
        int E3 = E2;
        int TL = 0;
        //Bottom Left
        //C4, D4, {0, YMax}
        int C4 = B1;
        int D4 = Hex.getYMax();
        int BL = D4;

        int[] arr = {A1, B1, C1, BR, 
                A2, TR, E2, F2, 
                D3, E3, TL, 
                C4, D4, BL};
        return arr;
    }
    
    @Override
    public void draw(){
        Graphics g = Hex.getG();
        int[] x = this.getPointsX();
        int[] y = this.getPointsY();
        int[] x1 = Arrays.copyOfRange(x, 0, 4);
        int[] y1 = Arrays.copyOfRange(y, 0, 4);
        int[] x2 = Arrays.copyOfRange(x, 4, 8);
        int[] y2 = Arrays.copyOfRange(y, 4, 8);
        int[] x3 = Arrays.copyOfRange(x, 8, 11);
        int[] y3 = Arrays.copyOfRange(y, 8, 11);
        int[] x4 = Arrays.copyOfRange(x, 11, 14);
        int[] y4 = Arrays.copyOfRange(y, 11, 14);
        if (this.getShim()) {
            g.fillPolygon(x1, y1, 4);
            g.fillPolygon(x2, y2, 4);
            g.fillPolygon(x3, y3, 3);
            g.fillPolygon(x4, y4, 3);
        } else {
            g.drawPolygon(x1, y1, 4);
            g.drawPolygon(x2, y2, 4);
            g.drawPolygon(x3, y3, 3);
            g.drawPolygon(x4, y4, 3);
        }

    }
}
