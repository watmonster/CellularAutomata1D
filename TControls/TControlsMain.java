package TControls;

import processing.core.PApplet;
import java.util.ArrayList;
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

    }

    public static void main(String[] args) {
        String[] processingArgs = {"TControlsMain"};
        TControlsMain tcm = new TControlsMain();
        PApplet.runSketch(processingArgs, tcm);
    }
}
