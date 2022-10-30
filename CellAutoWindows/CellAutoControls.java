package CellAutoWindows;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ProcessingSwingMerge.SwingConstructor;
import processing.core.PApplet;

public class CellAutoControls {

    public static CellAutoRunner car;
    public static JTextField ruleField;

    // public void settings() {
    // size(500, 500);
    // }

    // public void setup() {
        
    // }

    public static void main(String[] args) {
        car = new CellAutoRunner();
        SwingConstructor.setPApplet(car.cgdisp);
        ruleField = new JTextField(3);
        JPanel desc_added = SwingConstructor.list_col(new JLabel("Rule number: "), ruleField);
        JButton applyRuleButton = new JButton("Apply Rule");
        SwingConstructor.callMethodOnClick(applyRuleButton, "applyRule30");
        JPanel prompt = SwingConstructor.list_row(desc_added, applyRuleButton);
        Dimension size_prompt = prompt.getPreferredSize();
        size_prompt.width = 150;
        prompt.setPreferredSize(size_prompt);
        JFrame mainWindow = SwingConstructor.merge(SwingConstructor.scrollable(prompt, 190, car.cgdisp.height), "East");
        mainWindow.setVisible(true);
        mainWindow.setTitle("Example");
        car.applyRule(30);
    }
}
