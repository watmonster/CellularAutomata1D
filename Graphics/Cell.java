package Graphics;

import Helpers.Logging;
import processing.core.PApplet;

public class Cell{

    private PApplet sketch;

    public int state;
    public int sizeInt;
    public int col;
    public int row;

    public Cell(PApplet sketch, int state, int sizeInt, int col, int row){
        this.sketch=sketch;
        this.state=state;
        this.sizeInt = sizeInt;
        this.col = col;
        this.row = row;
    }

    public void setState(int newState){ //BASE 3 TODO
        if(newState == 0 || newState == 1){
            this.state = newState;
        }else{
            Logging.logWithTimeStamp("Invalid state: " + newState);
        }
    }

    public void render(){ //BASE 3 TODO
        if(state==0){
            sketch.fill(255);
        }else{
            sketch.fill(0);
        }
        sketch.rect((float)col*sizeInt,(float)row*sizeInt,(float)sizeInt,(float)sizeInt);
    }

    public void changeColor(){ //BASE 3 TODO
        if(state == 0){
            state = 1;
        }else if(state == 1){
            state = 0;
        }
    }

}
