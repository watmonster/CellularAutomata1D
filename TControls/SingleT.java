package TControls;

import processing.core.PApplet;
//import Graphics.Cell;
import java.util.ArrayList;
import java.util.Arrays;

public class SingleT {

    public int ruleInput; // num 0-7 which represents the top 3 cells of the T
    public int ruleOutput = 0;// num 0-1 which represents the bottom cell of the T
    public int cellSize;
    public int tspacing;
    public ClickableCell cc;
    private ClickableCell c0;
    private ClickableCell c1;
    private ClickableCell c2;
    private PApplet sketch;

    public SingleT(PApplet sketch, int ruleInput, int cellSize, int tspacing) {
        this.ruleInput = ruleInput;
        this.sketch = sketch;
        this.cellSize = cellSize;
        this.tspacing = tspacing;
        int xoffset = ruleInput * (cellSize * 3 + tspacing);
        this.cc = new ClickableCell(this.sketch, 0, this.cellSize, 1, 1, xoffset, 0);
        this.c0 = new ClickableCell(this.sketch, ruleInputSet(ruleInput).get(0), this.cellSize, 0, 0, xoffset, 0);
        this.c1 = new ClickableCell(this.sketch, ruleInputSet(ruleInput).get(1), this.cellSize, 1, 0, xoffset, 0);
        this.c2 = new ClickableCell(this.sketch, ruleInputSet(ruleInput).get(2), this.cellSize, 2, 0, xoffset, 0);
    }

    public ArrayList<Integer> ruleInputSet(int ri) { //BASE 3 TODO
        if (ri == 0) {
            return new ArrayList<Integer>(Arrays.asList(1, 1, 1));
        } else if (ri == 1) {
            return new ArrayList<Integer>(Arrays.asList(1, 1, 0));
        } else if (ri == 2) {
            return new ArrayList<Integer>(Arrays.asList(1, 0, 1));
        } else if (ri == 3) {
            return new ArrayList<Integer>(Arrays.asList(1, 0, 0));
        } else if (ri == 4) {
            return new ArrayList<Integer>(Arrays.asList(0, 1, 1));
        } else if (ri == 5) {
            return new ArrayList<Integer>(Arrays.asList(0, 1, 0));
        } else if (ri == 6) {
            return new ArrayList<Integer>(Arrays.asList(0, 0, 1));
        } else {
            return new ArrayList<Integer>(Arrays.asList(0, 0, 0));
        }
    }

    public void click() {
        cc.mc();
    }

    public void renderT() {
        cc.render();
        c0.render();
        c1.render();
        c2.render();
    }
}
