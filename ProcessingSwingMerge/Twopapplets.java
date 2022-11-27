package ProcessingSwingMerge;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import processing.core.PApplet;

public class Twopapplets extends PApplet {

    public JTextField props[] = new JTextField[11];
    public String outputs[] = new String[props.length];
    public int outputsInt[] = new int[props.length];

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        // Sets the PApple (Processing program) to use for the Window maker. DO NOT USE
        // IN ANOTHER CLASS!
        //SwingConstructor.setPApplet(this);

        for (int i = 0; i < props.length; i++) {
            props[i] = new JTextField(10);
        }

        JPanel description_added[] = new JPanel[props.length];

        // Joins components vertically
        description_added[0] = SwingConstructor.list_col(new JLabel("x:"), props[0]);
        description_added[1] = SwingConstructor.list_col(new JLabel("y:"), props[1]);
        description_added[2] = SwingConstructor.list_col(new JLabel("r1:"), props[2]);
        description_added[3] = SwingConstructor.list_col(new JLabel("r2:"), props[3]);
        description_added[4] = SwingConstructor.list_col(new JLabel("r:"), props[4]);
        description_added[5] = SwingConstructor.list_col(new JLabel("g:"), props[5]);
        description_added[6] = SwingConstructor.list_col(new JLabel("b:"), props[6]);
        description_added[7] = SwingConstructor.list_col(new JLabel("r:"), props[7]);
        description_added[8] = SwingConstructor.list_col(new JLabel("g:"), props[8]);
        description_added[9] = SwingConstructor.list_col(new JLabel("b:"), props[9]);
        description_added[10] = SwingConstructor.list_col(new JLabel("w:"), props[10]);
        JButton resetButton = new JButton("Reset");
        // Adds the method reset to the button
        SwingConstructor.callMethodOnClick(resetButton, "reset", this);

        // Joins components horizonaly
        JPanel prompt = SwingConstructor.list_row(
                new JLabel("Setting:"),
                description_added[0],
                description_added[1],
                description_added[2],
                description_added[3],
                SwingConstructor.list_col(new JLabel("Color inside:")),
                description_added[4],
                description_added[5],
                description_added[6],
                SwingConstructor.list_col(new JLabel("Outside line:")),
                description_added[7],
                description_added[8],
                description_added[9],
                description_added[10],
                resetButton);

        // Fiddling about with the dimensions
        Dimension size_prompt = prompt.getPreferredSize();
        size_prompt.width = 150;
        prompt.setPreferredSize(size_prompt);

        // Adds the contents of the processing window to the right (East)
        //JFrame mw1 = SwingConstructor.mergePAppletSwing(this, SwingConstructor.scrollable(prompt, 190, height), "East");
        //JFrame mainWindow = SwingConstructor.mergePAppletSwing(this, mw1, "East"); //the bad part

        JFrame mw1 = SwingConstructor.mergePAppletPApplet(this, this, "East"); //doesn't quite work because we're merging a papplet with itself but it works ENOUGH

        mw1.setVisible(true);
        mw1.setTitle("Example");
        reset();
    }

    public void draw() {
        background(255);
        updateOutputsInt();
        strokeWeight(outputsInt[10]);
        stroke(outputsInt[7], outputsInt[8], outputsInt[9]);
        fill(outputsInt[4], outputsInt[5], outputsInt[6]);
        ellipse(outputsInt[0], outputsInt[1], outputsInt[2], outputsInt[3]);
    }

    public void reset() {
        props[0].setText("" + (width / 2));
        props[1].setText("" + (height / 2));
        props[2].setText("30");
        props[3].setText("20");
        props[4].setText("255");
        props[5].setText("255");
        props[6].setText("255");
        props[7].setText("0");
        props[8].setText("0");
        props[9].setText("0");
        props[10].setText("1");
    }

    public void updateOutputsInt() {
        // check whether any output has changed
        for (int i = 0; i < props.length; i++) {
            if (outputs[i] == null || !(outputs[i].equals(props[i].getText()))) {
                outputs[i] = props[i].getText();
                try {
                    outputsInt[i] = Integer.parseInt(outputs[i]);
                } catch (java.lang.NumberFormatException e) {
                    System.out.println("Can't parse input as integer: " + "\"" + outputs[i] + "\"");
                }
            }
        }
    }
}