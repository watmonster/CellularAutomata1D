package TControls;

import Helpers.Logging;
import processing.core.PApplet;

public class ClickableCell{

    private PApplet sketch;

    public int state;
    public int sizeInt;
    public int col;
    public int row;
    public int xoffset;
    public int yoffset;

    public ClickableCell(PApplet sketch, int state, int sizeInt, int col, int row, int xoffset, int yoffset){
        this.sketch=sketch;
        this.state=state;
        this.sizeInt = sizeInt;
        this.col = col;
        this.row = row;
        this.xoffset = xoffset;
        this.yoffset = yoffset;
    }

    public void setState(int newState){
        if(newState == 0 || newState == 1){
            this.state = newState;
        }else{
            Logging.logWithTimeStamp("Invalid state: " + newState);
        }
    }

    public void render(){
        if(state==0){
            sketch.fill(255);
            //System.out.println("filled white!");
        }else{
            sketch.fill(0);
            //System.out.println("filled black!");
        }
        sketch.rect((float)col*sizeInt+xoffset,(float)row*sizeInt+yoffset,(float)sizeInt,(float)sizeInt);
    }

    public void mc(){
        this.changeColor();
    }

    public void changeColor(){
        if(state == 0){
            state = 1;
        }else if(state == 1){
            state = 0;
        }
    }

}
