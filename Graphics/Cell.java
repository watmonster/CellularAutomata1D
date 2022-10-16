package Graphics;

import processing.core.PApplet;

public class Cell{

    private PApplet sketch;

    public int state;
    public int sizeInt;

    public Cell(PApplet sketch, int state, int sizeInt){
        this.sketch=sketch;
        this.state=state;
        this.sizeInt = sizeInt;
    }

    public void render(){
        if(state==0){
            sketch.fill(255);
            System.out.println("filled white!");
        }else{
            sketch.fill(0);
            System.out.println("filled black!");
        }
        sketch.rect(0.0f,0.0f,(float)sizeInt,(float)sizeInt);
    }

    public void changeColor(){
        if(state == 0){
            sketch.fill(0);
            sketch.rect(0.0f,0.0f,(float)sizeInt,(float)sizeInt);
            state = 1;
        }else if(state == 1){
            sketch.fill(255);
            sketch.rect(100.0f,100.0f,(float)sizeInt,(float)sizeInt);
            state = 0;
        }
    }

}
