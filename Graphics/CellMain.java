package Graphics;

import processing.core.PApplet;

public class CellMain extends PApplet{

    private CellGrid cg;

    public int psize;
    public int rows;
    public int cols;
    public int cellSize;

    public CellMain(int psize, int rows, int cols){
        this.psize = psize;
        this.rows = rows;
        this.cols = cols;
        this.cellSize = (int)psize/rows;
        this.cg = new CellGrid(this,this.rows,this.cols,cellSize);
    }

    public void settings(){
        size(psize,psize);
    }

    public void draw(){
        cg.render();
    }

    public void mouseClicked(){
        System.out.println("x = " + mouseX + ", y = "+ mouseY);
        int col = floor(mouseX/(cellSize));
        int row = floor(mouseY/(cellSize));
        System.out.println(col + ", " + row);
        cg.cellAt(row,col).changeColor();
    }

    public static void main(String[] args){
		String[] processingArgs = {"MySketch"};
		CellMain mySketch = new CellMain(1000,17,17);
		PApplet.runSketch(processingArgs, mySketch);
	}
}
