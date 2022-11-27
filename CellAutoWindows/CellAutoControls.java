package CellAutoWindows;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ProcessingSwingMerge.SwingConstructor;
import processing.core.PApplet;
import Helpers.Logging;

public class CellAutoControls {

    public CellAutoRunner car;
    public JTextField ruleField;
    public JPanel panel;

    // public void settings() {
    // size(500, 500);
    // }

    // public void setup() {

    // }

    public CellAutoControls(CellAutoRunner cAssign) {
        this.car = cAssign;
        this.panel = this.buildPanel();
    }

    // public static void applyRule30() {
    // car.applyRule(30);
    // }

    public void setRule(int newRule){
        this.ruleField.setText(Integer.toString(newRule));
    }

    public JPanel buildPanel() {
        this.ruleField = new JTextField(3);
        JPanel desc_added = SwingConstructor.list_col(new JLabel("Rule number: "), ruleField);
        JButton applyRuleButton = new JButton("Apply Rule");
        applyRuleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Logging.logWithTimeStamp("Button pressed");
                car.applyRule(Integer.parseInt(ruleField.getText()));
            }
        });
        JPanel prompt = SwingConstructor.list_row(desc_added, applyRuleButton);
        Dimension size_prompt = prompt.getPreferredSize();
        size_prompt.width = 150;
        prompt.setPreferredSize(size_prompt);
        return prompt;
    }
}
