package Graphics;

import processing.core.PApplet;
import java.util.ArrayList;

public class CellMain extends PApplet{

    private ArrayList<Cell> cells = new ArrayList<Cell>();

    public void settings(){
        cells.add(new Cell(this,0,100,0,0));
        cells.add(new Cell(this,0,100,1,0));
        size(cells.get(0).sizeInt*cells.size(),cells.get(0).sizeInt);
    }

    public void draw(){
        for(Cell c: cells){
            c.render();
        }
    }

    public void mouseClicked(){
        System.out.println("x = " + mouseX + ", y = "+ mouseY);
        int col = floor(mouseX/100);
        System.out.println(col);
        cells.get(col).changeColor();
    }

    public static void main(String[] args){
		String[] processingArgs = {"MySketch"};
		CellMain mySketch = new CellMain();
		PApplet.runSketch(processingArgs, mySketch);
	}
}
