package TControls;

import Helpers.Logging;
import processing.core.PApplet;

public class ClickableCell {

    private PApplet sketch;

    public int state;
    public int cellSize;
    public int col;
    public int row;
    public int xoffset;
    public int yoffset;

    public ClickableCell(PApplet sketch, int state, int cellSize, int col, int row, int xoffset, int yoffset) {
        this.sketch = sketch;
        this.state = state;
        this.cellSize = cellSize;
        this.col = col;
        this.row = row;
        this.xoffset = xoffset;
        this.yoffset = yoffset;
    }

    public void setState(int newState) { //BASE 3 TODO
        if (newState == 0 || newState == 1) {
            this.state = newState;
        } else {
            Logging.logWithTimeStamp("Invalid state: " + newState);
        }
    }

    public void render() { //BASE 3 TODO
        if (state == 0) {
            sketch.fill(255);
        } else {
            sketch.fill(0);
        }
        sketch.rect((float) col * cellSize + xoffset, (float) row * cellSize + yoffset, (float) cellSize,
                (float) cellSize);
    }

    public void mc() { //BASE 3 TODO
        this.changeColor();
    }

    public void changeColor() { //BASE 3 TODO
        if (state == 0) {
            state = 1;
        } else if (state == 1) {
            state = 0;
        }
    }

}
