package Graphics;

import processing.core.PApplet;

public class CellGridDisplay extends PApplet{

    public CellGrid cg;

    public int psize;
    public int rows;
    public int cols;
    public int cellSize;

    public CellGridDisplay(int psize, int rows, int cols){
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

    // public void mouseClicked(){
    //     System.out.println("x = " + mouseX + ", y = "+ mouseY);
    //     int col = floor(mouseX/(cellSize));
    //     int row = floor(mouseY/(cellSize));
    //     System.out.println(col + ", " + row);
    //     cg.cellAt(row,col).changeColor();
    // }

    
}
