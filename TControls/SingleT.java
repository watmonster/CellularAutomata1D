package TControls;

import processing.core.PApplet;
import Graphics.Cell;
import java.util.ArrayList;
import java.util.Arrays;

public class SingleT extends PApplet{

    public int ruleInput = 3; //num 0-7 which represents the top 3 cells of the T
    public int ruleOutput;//num 0-1 which represents the bottom cell of the T
    private ClickableCell cc = new ClickableCell(this,0,50,1,1);
    private Cell c0 = new Cell(this,ruleInputSet(ruleInput).get(0),50,0,0);
    private Cell c1 = new Cell(this,ruleInputSet(ruleInput).get(1),50,1,0);
    private Cell c2 = new Cell(this,ruleInputSet(ruleInput).get(2),50,2,0);

    public void settings(){
        size(150,100);
    }

    public ArrayList<Integer> ruleInputSet(int ri){
        if(ri == 0){
            return new ArrayList<Integer>(Arrays.asList(1,1,1));
        }else if(ri == 1){
            return new ArrayList<Integer>(Arrays.asList(1,1,0));
        }else if(ri == 2){
            return new ArrayList<Integer>(Arrays.asList(1,0,1));
        }else if(ri == 3){
            return new ArrayList<Integer>(Arrays.asList(1,0,0));
        }else if(ri == 4){
            return new ArrayList<Integer>(Arrays.asList(0,1,1));
        }else if(ri == 5){
            return new ArrayList<Integer>(Arrays.asList(0,1,0));
        }else if(ri == 6){
            return new ArrayList<Integer>(Arrays.asList(0,0,1));
        }else{
            return new ArrayList<Integer>(Arrays.asList(0,0,0));
        }
    }

    public void mouseClicked(){
        cc.mc();
    }

    public static void runthething(){
        String[] processingArgs = {"SingleT"};
		SingleT singleT = new SingleT();
		PApplet.runSketch(processingArgs,singleT);
    }

    public void draw(){
        cc.render();
        c0.render();
        c1.render();
        c2.render();
    }

    public static void main(String[] args){
        runthething();
    }
}
