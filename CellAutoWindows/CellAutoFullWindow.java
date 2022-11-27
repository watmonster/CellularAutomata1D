package CellAutoWindows;

import javax.swing.JFrame;
import ProcessingSwingMerge.SwingConstructor;
import TControls.TControlGroup;
import processing.core.PApplet;

public class CellAutoFullWindow {
    
    public CellAutoControls cac;
    public TControlGroup tcg;
    public CellAutoRunner car;

    public CellAutoFullWindow(){
        this.car = new CellAutoRunner();  // car.cgdisp
        this.cac = new CellAutoControls(car); //cac.panel
        this.tcg = new TControlGroup(); //already a papplet
    }

    public JFrame buildWindow(){
        JFrame merge1 = SwingConstructor.mergePAppletSwing(car.cgdisp, cac.panel, "East");
        JFrame merge2 = SwingConstructor.mergePAppletSwing(tcg, merge1, "North");
        return merge2;
    }

    public static void main(String[] args){
        CellAutoFullWindow cafw = new CellAutoFullWindow();
        String[] processingArgs1 = {"TControlsMain"};
        PApplet.runSketch(processingArgs1, cafw.tcg);
        JFrame bw = cafw.buildWindow();
        bw.setVisible(true);
        bw.setTitle("BuildWindow");
    }
}
