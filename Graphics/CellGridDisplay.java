package Graphics;

import Helpers.Logging;
import processing.core.PApplet;

public class CellGridDisplay extends PApplet{

    public CellGrid cg;

    public int psize;
    public int rows;
    public int cols;
    public int cellSize;

    public CellGridDisplay(int psize, int rows, int cols, int cellSize){
        this.psize = psize;
        this.rows = rows;
        this.cols = cols;
        this.cellSize = cellSize;
        System.out.println("cell size: " + this.cellSize);
        this.cg = new CellGrid(this,this.rows,this.cols,cellSize);
    }

    public void settings(){
        size(psize,psize);
        Logging.logWithTimeStamp("cgdisp width: " + this.width + " , height: " + this.height);
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
