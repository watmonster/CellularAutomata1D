package CellAutoWindows;

import java.util.ArrayList;
import java.util.Arrays;

import Graphics.CellGrid;
import Graphics.CellGridDisplay;
import Helpers.Base10ToBase2;
import Helpers.Logging;
import processing.core.PApplet;
import Helpers.Zeroone;

public class CellAutoRunner {

    public CellGridDisplay cgdisp;
    public static int numrows = 101;
    //public int displaysize;
    // public static int rule = 30;
    public int cellSize = 7;
    public static ArrayList<Integer> onecols = new ArrayList<Integer>(Arrays.asList(50));

    public CellAutoRunner() {
        String[] processingArgs = { "CellAutoRunner" };
        cgdisp = new CellGridDisplay(numrows*cellSize + 1, numrows, numrows, cellSize);
        PApplet.runSketch(processingArgs, cgdisp);
    }

    public static int pythmod(int num, int mod) {
        // handle mods of negative numbers like python does, not like java
        if (num < 0) {
            return (num % mod) + mod;
        } else {
            return num % mod;
        }
    }

    public static int calcVal(CellGrid cg, int row, int col, int ruleNum) {
        int valL = cg.cellAt(row - 1, pythmod(col - 1, numrows)).state;
        int valC = cg.cellAt(row - 1, pythmod(col, numrows)).state;
        int valR = cg.cellAt(row - 1, pythmod(col + 1, numrows)).state;
        String ruleStr = Base10ToBase2.toBinaryString(ruleNum);
        if (valL == 1 && valC == 1 && valR == 1) {
            return Zeroone.zeroOne(ruleStr.charAt(0));
        } else if (valL == 1 && valC == 1 && valR == 0) {
            return Zeroone.zeroOne(ruleStr.charAt(1));
        } else if (valL == 1 && valC == 0 && valR == 1) {
            return Zeroone.zeroOne(ruleStr.charAt(2));
        } else if (valL == 1 && valC == 0 && valR == 0) {
            return Zeroone.zeroOne(ruleStr.charAt(3));
        } else if (valL == 0 && valC == 1 && valR == 1) {
            return Zeroone.zeroOne(ruleStr.charAt(4));
        } else if (valL == 0 && valC == 1 && valR == 0) {
            return Zeroone.zeroOne(ruleStr.charAt(5));
        } else if (valL == 0 && valC == 0 && valR == 1) {
            return Zeroone.zeroOne(ruleStr.charAt(6));
        } else {
            return Zeroone.zeroOne(ruleStr.charAt(7));
        }
    }

    public void applyRule(int ruleNum) {
        Logging.logWithTimeStamp("applyrule called with rule " + ruleNum);

        // make a CellGrid
        for (int row = 0; row < numrows; row++) {
            for (int col = 0; col < numrows; col++) {
                cgdisp.cg.cellAt(row, col).setState(0);
            }
        }

        // make the middle top cell black
        // mySketch.cg.cellAt(0,numrows/2).changeColor();
        for (Integer i : onecols) {
            cgdisp.cg.cellAt(0, i).changeColor();
        }

        // apply a rule to the first row to make the second row
        for (int row = 1; row < numrows; row++) {
            for (int col = 0; col < numrows; col++) {
                if (calcVal(cgdisp.cg, row, col, ruleNum) == 1) {
                    cgdisp.cg.cellAt(row, col).changeColor();
                }
            }
        }
        // for rownum = 0 rownum < numrows rownum ++
        // apply the rule to row rownum to make row rownum+1
    }

}
