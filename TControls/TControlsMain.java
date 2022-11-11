package TControls;

import processing.core.PApplet;
import java.util.ArrayList;
import Helpers.Base2ToBase10;
//import java.util.Arrays;

public class TControlsMain extends PApplet{

    //private SingleT s0,s1,s2,s3,s4,s5,s6,s7;
    private ArrayList<SingleT> ts = new ArrayList<SingleT>();
    public int cellSize = 50;
    public int tspacing = 10;

    public void settings(){
        size(8*(cellSize*3 + tspacing)-tspacing,cellSize*2);
    }

    public TControlsMain(){
        for(int i = 0; i < 8; i++){
            ts.add(new SingleT(this,i, cellSize, tspacing));
        }
    }

    public void draw(){
        for(SingleT i : ts){
            i.renderT();
        }
    }

    public void mouseClicked(){
        //System.out.println(mouseX + ", " + mouseY);
        int tIndex = (int)(mouseX/(cellSize*3 + tspacing));
        System.out.println(tIndex);
        ts.get(tIndex).click();

        ruleify();
    }

    public void ruleify(){
        int[] tStateList = {0,0,0,0,0,0,0,0};
        for(int i = 0; i < 8; i++){
            tStateList[i] = ts.get(i).cc.state;
        }
        int rule = Base2ToBase10.b2tb10(tStateList);
        System.out.println(rule);
    }

    public static void main(String[] args) {
        String[] processingArgs = {"TControlsMain"};
        TControlsMain tcm = new TControlsMain();
        PApplet.runSketch(processingArgs, tcm);
    }
}
