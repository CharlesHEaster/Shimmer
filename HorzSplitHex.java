
/**
 * Write a description of class HorzSplitHex here.
 *
 * @author (Charles Easter)
 * @version (DATE)
 */

import java.awt.*;
import java.util.Arrays;

public class HorzSplitHex extends Hex
{
    public HorzSplitHex(int ex, int why){ 
        super(ex, why);     
    }

    @Override
    public int[] getPointsX(){
        int A1 = this.getX();
        int A2 = A1;
        int B = A1 + (Hex.getSize() / 2);
        int C = B + Hex.getSize();
        int D1 = A1 + Hex.getWidth();
        int D2 = D1;
        int E2 = C;
        int F2 = B;

        int[] arr = {A1, B, C, D1, A2, D2, E2, F2};
        return arr;
    }

    @Override
    public int[] getPointsY(){
        int A1 = this.getY();
        int A2 = 0;
        int B1 = A1 - (Hex.getHeight() / 2);
        int C1 = B1;
        int D1 = A1;
        int D2 = 0;
        int E2 = Hex.getHeight() / 2;
        int F2 = E2;

        int[] arr = {A1, B1, C1, D1, A2, D2, E2, F2};
        return arr;
    }

    @Override
    public void draw(Graphics g){
        int[] x = this.getPointsX();
        int[] y = this.getPointsY();
        int[] x1 = Arrays.copyOfRange(x, 0, 4);
        int[] x2 = Arrays.copyOfRange(x, 4, 8);
        int[] y1 = Arrays.copyOfRange(y, 0, 4);
        int[] y2 = Arrays.copyOfRange(y, 4, 8);
        if (this.getShim()) {
            g.fillPolygon(x1, y1, 4);
            g.fillPolygon(x2, y2, 4);
        } else {
            g.drawPolygon(x1, y1, 4);
            g.drawPolygon(x2, y2, 4);
        }

    }
}
