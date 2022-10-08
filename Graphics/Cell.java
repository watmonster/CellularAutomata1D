package Graphics;

import processing.core.PApplet;

public class Cell extends PApplet{

    public int val = 0;

    public void settings(){
        size(500,500);
        fill(255);
        rect(100.0f,100.0f,300.0f,300.0f);
    }

    public void changeColor(){
        if(val == 0){
            fill(0);
            rect(100.0f,100.0f,300.0f,300.0f);
            val = 1;
        }else if(val == 1){
            fill(255);
            rect(100.0f,100.0f,300.0f,300.0f);
            val = 0;
        }
    }

    public void mouseClicked(){
        changeColor();
    }

    public static void main(String[] args){
		String[] processingArgs = {"MySketch"};
		Cell mySketch = new Cell();
		PApplet.runSketch(processingArgs, mySketch);
	}
}
