package Graphics;

import java.util.ArrayList;
import processing.core.PApplet;

public class CellGrid {
    private ArrayList<ArrayList<Cell>> cells = new ArrayList<ArrayList<Cell>>();

    private PApplet sketch;

    public int rows;
    public int cols;
    public int cellSize;
    
    public CellGrid(PApplet sketch, int rows, int cols, int cellSize){
        this.rows = rows;
        this.cols=cols;
        this.cellSize = cellSize;
        this.sketch = sketch;

        for(int i = 0; i < this.rows; i++){
            cells.add(new ArrayList<Cell>());
            for(int j = 0; j < this.cols; j++){
                cells.get(i).add(new Cell(sketch,0,cellSize,j,i));
            }
        }
    }

    public Cell cellAt(int row,int col){
        return cells.get(row).get(col);
    }

    public void render(){
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.cols; j++){
                cells.get(i).get(j).render();
            }
        }
    }
}
