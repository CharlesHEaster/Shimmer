
/**
 * Write a description of class hex here.
 *
 * @author (Charles Easter)
 * @version (DATE)
 */

import java.awt.*;
import javax.swing.*;
import java.util.Arrays;

abstract public class Hex
{
    private int Count;
    private int x;
    private int y;
    private static int Size, Height, Width; //size of one side determines height and width of hex.
    private static int XMax, YMax; // max coordinate values are modulated according to hex height and width
    private static int Likely;// how likely one hex is to see anothers shimmer out of 1000, higher number more likely
    private static int Often; //how likely they are to shimmer if left alone out of 1000, higher number more often
    private static int Delay; //how long they will not shimmer after they have shimmered
    private static int OnTime; // how long they stay on shimmer
    private static int PassOn; // the count of the timer when they try to pass on the shimmer
    private static int RowOffset, ColOffset; //row and col offsets are determined by height and fractions of width
    private static Graphics G;
    // count starts at 0.  when shim is passed count jumps to delay + ontime.  then count ticks down every frame.
    // when count < delay shim turns off.
    // when count is 0 it can recieve shim again

    public static Hex decernHex(int ex, int why){        //this logic path is just sloppy.  im sorry
        int x = ex;
        int y = why;
        //if the full hex is on the screen horzontally AND Vertically = normal hex 
        if (x <= Hex.getXMax() - Hex.getWidth() && y < Hex.getYMax()) {
            return new NormHex(x, y);
        // else if X is towards the rigth edge of the screen...
        } else if ( x > Hex.getXMax() - Hex.getWidth()) {
            //if Y is NOT on the bottom edge = VertSplitHex
            if (y < Hex.getYMax() - (Hex.getHeight() / 2)) {
                return new VertSplitHex(x, y);
            // else it must be VertSplit AND HorzSplit = William Wallace
            } else {
                return new WilliamWallace(x, y);
            }
        //Process of elimation...  HorzSplit
        } else {
            return new HorzSplitHex(x, y);
        } 

    }

    public Hex(int ex, int why){
        this.setX(ex);
        this.setY(why);
        this.setCount(0);
    }

    public int getX(){
        return this.x;
    }

    public void setX(int ex){
        this.x = ex;
    }

    public int getY(){
        return this.y;
    }

    public void setY(int why){
        this.y = why;
    }

    public int[] getLocation(){
        int[] arr = {this.getX(), this.getY()};
        return arr;
    }    

    public void setLocation(int x, int y){
        this.setX(x);
        this.setY(y);
    }

    public void setLocation(int[] arr){
        this.setX(arr[0]);
        this.setY(arr[1]);
    }

    public int getCount() {
        return this.Count;
    }

    public void setCount(int c){
        this.Count = c;
    }

    public void decCount(){
        if (this.getCount() > 0) {
            this.Count--;
        }
    }

    public boolean getShim(){
        return this.getCount() > Hex.getDelay();
    }

    public void giveShim(){
        if (this.getCount() == 0 && Hex.getLikely()) {
            this.setCount(Hex.getOnTime() + Hex.getDelay());
        }
    }

    public static void setXMax(String str){
        int xma = Integer.parseInt(str);
        Hex.setXMax(xma);
    }

    public static void setXMax(int xma){
        XMax = XMax < 1300 ? XMax : 1300; 
        XMax = xma - (xma % (Hex.getWidth() + Hex.getSize()));
    }

    public static void setYMax(String str){
        int yma = Integer.parseInt(str);
        Hex.setYMax(yma);
    }

    public static void setYMax(int yma){
        YMax = YMax < 750 ? YMax : 750;
        YMax = yma - (yma % Hex.getHeight()); 
    }

    public static void setSize(String str){
        int d = Integer.parseInt(str);
        Hex.setSize(d);
    }

    public static void setSize(int hs){
        Size = hs;
        Size = Size == 5 ? 6: Size;
        Height = (int)(Size * 1.732);
        Height = (Height / 2) * 2;
        Width = (int)(2 * Size);
        RowOffset = (int)(Height / 2);
        ColOffset = (int)(Size * 1.5);
    }

    public static void setLikely(int li){
        Likely = li;  
    }

    public static void setLikely(String str){
        Likely = Integer.parseInt(str);
    }

    public static void setOften(int oft){
        Often = oft;  
    }

    public static void setOften(String str){
        Often = Integer.parseInt(str);
    }

    public static void setDelay(int de){
        Delay = de;  
    }

    public static void setDelay(String str){
        Delay = Integer.parseInt(str);
    }

    public static void setOnTime(int OT){
        OnTime = OT;  
    }

    public static void setOnTime(String str){
        OnTime = Integer.parseInt(str);
    }

    public static void setPassOn(int pa){
        Hex.PassOn = pa;
        Hex.PassOn = (Hex.getOnTime() + Hex.getDelay()) - Hex.PassOn;
    }

    public static void setPassOn(String str){
        setPassOn(Integer.parseInt(str));
    }

    public static int getXMax(){
        return XMax;  
    }

    public static int getYMax(){
        return YMax;  
    }

    public static int getSize(){
        return Size;  
    }

    public static boolean getLikely(){
        int random = (int)((Math.random() * 1000) + 1);
        return random < Likely;  
    }

    public static int getDelay(){
        return Delay;  
    }

    public static boolean getOften(){
        int random = (int)(Math.random() * 1000000 + 1);
        return random < Often;  
    }

    public static int getOnTime(){
        return OnTime;  
    }

    public static int getPassOn(){
        return PassOn;  
    }

    public static int getRowOffset(){
        return RowOffset;  
    }

    public static int getColOffset(){
        return ColOffset;  
    }

    public static int getHeight(){
        return Height;  
    }

    public static int getWidth(){
        return Width;  
    }

    public static int getRowLength(){
        return (int)(Hex.getXMax() / (Hex.getWidth() + Hex.getSize()));
    }

    public static int getNumRows(){
        return Hex.getYMax() / (Hex.getHeight() / 2);
    }

    public String toString() {
        String str = "Location [x: " + this.getX() + " y: " + this.getY() + "] Count: " + this.getCount();
        return str;        
    }

    public static String toStringStatic(){

        return "--=Static Variables=--\n   XMax:" + XMax +
        "\n   YMax:" + YMax +
        "\n   Size:" + Size +
        "\n   Height:" + Height +
        "\n   Width:" + Width +
        "\n   Likely:" + Likely +
        "\n   Often:" + Often +
        "\n   Delay:" + Delay +
        "\n   OnTime:" + OnTime +
        "\n   PassOn:" + PassOn +
        "\n   RowOffset:" + RowOffset +
        "\n   ColOffset:" + ColOffset;

    }

    abstract public int[] getPointsX();

    abstract public int[] getPointsY();

    public static void setG(Graphics g) {
        Hex.G = g;
    }
    
    public static Graphics getG(){
        return Hex.G;
    }
    
    abstract public void draw();

    public static void disperseShim(Hex[][] arr, int jay, int eye) {
        int j = jay;
        int i = eye;
        int jmod = arr.length;
        int imod = arr[0].length;
        int[] jarr = new int[6];
        int[] iarr = new int[6];
        //Up Left
        jarr[0] = j - 1;
        iarr[0] = i;
        //Up
        jarr[1] = j - 2;
        iarr[1] = i + 1;
        // Up Right
        jarr[2] = j - 1;
        iarr[2] = i + 1;
        // Down Right
        jarr[3] = j + 1;
        iarr[3] = i;
        // Down
        jarr[4] = j + 2;
        iarr[4] = i - 1;
        // Down Left
        jarr[5] = j + 1;
        iarr[5] = i - 1;

        for (int p = 0; p < 6; p++){
            jarr[p] = jarr[p] < 0 ? jarr[p] + jmod: jarr[p];
            jarr[p] = jarr[p] >= jmod ? jarr[p] - jmod: jarr[p];
        }
        for (int p = 0; p < 6; p++){
            iarr[p] = iarr[p] < 0 ? iarr[p] + imod: iarr[p];
            iarr[p] = iarr[p] >= imod ? iarr[p] - imod: iarr[p];
        }

        arr[jarr[0]][iarr[0]].giveShim();
        arr[jarr[1]][iarr[1]].giveShim();
        arr[jarr[2]][iarr[2]].giveShim();
        arr[jarr[3]][iarr[3]].giveShim();
        arr[jarr[4]][iarr[4]].giveShim();
        arr[jarr[5]][iarr[5]].giveShim();
    }

}
