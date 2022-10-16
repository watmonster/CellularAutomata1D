package Graphics;

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

    public void render(){
        if(state==0){
            sketch.fill(255);
            //System.out.println("filled white!");
        }else{
            sketch.fill(0);
            //System.out.println("filled black!");
        }
        sketch.rect((float)col*100,(float)row*100,(float)sizeInt,(float)sizeInt);
    }

    public void changeColor(){
        if(state == 0){
            sketch.fill(0);
            sketch.rect((float)col*100,(float)row*100,(float)sizeInt,(float)sizeInt);
            state = 1;
        }else if(state == 1){
            sketch.fill(255);
            sketch.rect((float)col*100,(float)row*100,(float)sizeInt,(float)sizeInt);
            state = 0;
        }
    }

}
