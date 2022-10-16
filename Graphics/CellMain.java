package Graphics;

import processing.core.PApplet;

public class CellMain extends PApplet{

    private Cell cell = new Cell(this,0,100);

    public void settings(){
        size(cell.sizeInt,cell.sizeInt);
    }

    public void draw(){
        cell.render();
    }

    public void mouseClicked(){
        cell.changeColor();
    }

    public static void main(String[] args){
		String[] processingArgs = {"MySketch"};
		CellMain mySketch = new CellMain();
		PApplet.runSketch(processingArgs, mySketch);
	}
}
