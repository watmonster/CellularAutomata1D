package CellAutoWindows;

import java.util.ArrayList;
import java.util.Arrays;

import Graphics.CellGrid;
import Graphics.CellGridDisplay;
import Helpers.Base10ToBase2;
import processing.core.PApplet;

public class CellAutoRunner {

    public static int displaysize = 1000;
    public static int numrows = 101;
    // public static int rule = 30;
    public static ArrayList<Integer> onecols = new ArrayList<Integer>(Arrays.asList(50));
    public CellGridDisplay cgdisp;
    
    public CellAutoRunner(){
        String[] processingArgs = {"MySketch"};
		cgdisp = new CellGridDisplay(displaysize,numrows,numrows);
		PApplet.runSketch(processingArgs, cgdisp);
    }

    public static int pythmod(int num, int mod){
        //handle mods of negative numbers like python does, not like java
        if(num<0){
            return (num % mod) + mod;
        }else{
            return num%mod;
        }
    }

    public static int zeroOne(char zo){
        if(zo == '0'){
            return 0;
        }else{
            return 1;
        }
    }

    public static int calcVal(CellGrid cg, int row,int col, int ruleNum){
        int valL = cg.cellAt(row-1,pythmod(col-1, numrows)).state;
        int valC = cg.cellAt(row-1,pythmod(col, numrows)).state;
        int valR = cg.cellAt(row-1,pythmod(col+1, numrows)).state;
        String ruleStr = Base10ToBase2.toBinaryString(ruleNum);
        if(valL == 1 && valC == 1 && valR == 1){
            return zeroOne(ruleStr.charAt(0));
        }else if(valL == 1 && valC == 1 && valR == 0){
            return zeroOne(ruleStr.charAt(1));
        }else if(valL == 1 && valC == 0 && valR == 1){
            return zeroOne(ruleStr.charAt(2));
        }else if(valL == 1 && valC == 0 && valR == 0){
            return zeroOne(ruleStr.charAt(3));
        }else if(valL == 0 && valC == 1 && valR == 1){
            return zeroOne(ruleStr.charAt(4));
        }else if(valL == 0 && valC == 1 && valR == 0){
            return zeroOne(ruleStr.charAt(5));
        }else if(valL == 0 && valC == 0 && valR == 1){
            return zeroOne(ruleStr.charAt(6));
        }else{
            return zeroOne(ruleStr.charAt(7));
        }
    }

    public void applyRule(int ruleNum) {

        //make a CellGrid
		

        //make the middle top cell black
        //mySketch.cg.cellAt(0,numrows/2).changeColor();
        for(Integer i : onecols){
            cgdisp.cg.cellAt(0,i).changeColor();
        }

        //apply a rule to the first row to make the second row
        for(int row = 1; row < numrows; row++){
            for(int col = 0; col < numrows; col++){
                if(calcVal(cgdisp.cg, row,col, ruleNum) == 1){
                    cgdisp.cg.cellAt(row,col).changeColor();
                }
            }
        }
        //for rownum = 0 rownum < numrows rownum ++
        //apply the rule to row rownum to make row rownum+1
    }
}
