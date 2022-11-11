package ProcessingSwingMerge;

import processing.core.PApplet;

public class TwopappletsMain {
    public static void main(String[] args){
        String[] processingArgs = {"Twopapplets"};
		Twopapplets mySketch = new Twopapplets();
		PApplet.runSketch(processingArgs, mySketch);
    }
}
