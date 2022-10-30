package CellAutoWindows;

import ProcessingSwingMerge.SwingConstructor;

public class CellAutoControls {

    public static CellAutoRunner car;

    public static void main(String[] args){
        car = new CellAutoRunner();
        car.applyRule(30);
    }
}
