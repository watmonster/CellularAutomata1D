package Graphics;

import processing.core.PApplet;

public class CellMain extends PApplet{

    private CellGrid cg;

    public int psize;
    public int rows;
    public int cols;

    public CellMain(int psize, int rows, int cols){
        this.psize = psize;
        this.rows = rows;
        this.cols = cols;
        this.cg = new CellGrid(this,this.rows,this.cols,(int)psize/rows);
    }

    public void settings(){
        size(psize,psize);
    }

    public void draw(){
        cg.render();
    }

    public void mouseClicked(){
        System.out.println("x = " + mouseX + ", y = "+ mouseY);
        int col = floor(mouseX/100);
        int row = floor(mouseY/100);
        System.out.println(col + ", " + row);
        cg.cellAt(row,col).changeColor();
    }

    public static void main(String[] args){
		String[] processingArgs = {"MySketch"};
		CellMain mySketch = new CellMain(1000,10,10);
		PApplet.runSketch(processingArgs, mySketch);
	}
}
