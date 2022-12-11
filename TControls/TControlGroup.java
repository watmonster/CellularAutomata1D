package TControls;

import processing.core.PApplet;
import java.util.ArrayList;

import CellAutoWindows.CellAutoFullWindow;
import Helpers.Base2ToBase10;
import Helpers.Base10ToBase2;
import Helpers.Zeroone;
import Helpers.Logging;

public class TControlGroup extends PApplet { //BASE 3 TODO

    private ArrayList<SingleT> ts = new ArrayList<SingleT>();
    public int cellSize = 40;
    public int tspacing = 10;
    public CellAutoFullWindow cafw;
    public int w;
    public int h;

    public void settings() {
        this.w = 8 * (cellSize * 3 + tspacing) - tspacing;
        this.h = cellSize * 2 + 1;
        Logging.logWithTimeStamp("tcg Width: " + w + ", height: " + h);
        size(w, h);
    }

    public TControlGroup(CellAutoFullWindow cafw) {
        this.cafw = cafw;
        for (int i = 0; i < 8; i++) {
            ts.add(new SingleT(this, i, cellSize, tspacing));
        }
    }

    public void draw() {
        strokeWeight(1);
        stroke(0, 0, 0);
        for (SingleT i : ts) {
            i.renderT();
        }
    }

    public void mouseClicked() {
        System.out.println("Clicked in tcontrolgroup!");
        int tIndex = (int) (mouseX / (cellSize * 3 + tspacing));
        System.out.println(tIndex);
        ts.get(tIndex).click();
        int newRule = getRule();
        cafw.onRuleChange(newRule);
        System.out.println("Finished mouseClicked function in tcontrolgroup!");
    }

    // gets rules from t states
    public int getRule() {
        int[] tStateList = { 0, 0, 0, 0, 0, 0, 0, 0 };
        for (int i = 0; i < 8; i++) {
            tStateList[i] = ts.get(i).cc.state;
        }
        int rule = Base2ToBase10.b2tb10(tStateList);
        return rule;
    }

    public void setRule(int newRule) {
        Logging.logWithTimeStamp("tcg setrule called with new rule: " + newRule);
        String binaryRule = Base10ToBase2.toBinaryString(newRule);
        for (int i = 0; i < 8; i++) {
            ts.get(i).cc.setState(Zeroone.zeroOne(binaryRule.charAt(i)));
        }
    }
}
