package CellAutoWindows;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ProcessingSwingMerge.SwingConstructor;
import processing.core.PApplet;
import Helpers.Logging;

public class CellAutoControls {

    public CellAutoRunner car;
    public JTextField ruleField;
    public JPanel panel;
    public CellAutoFullWindow cafw;

    // public void settings() {
    // size(500, 500);
    // }

    // public void setup() {

    // }

    public CellAutoControls(CellAutoRunner cAssign, CellAutoFullWindow cafw) {
        this.car = cAssign;
        this.panel = this.buildPanel();
        this.cafw = cafw;
    }

    // public static void applyRule30() {
    // car.applyRule(30);
    // }

    public void setRule(int newRule) {
        this.ruleField.setText(Integer.toString(newRule));
    }

    public JPanel buildPanel() {
        this.ruleField = new JTextField(3);
        ruleField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                onRuleFieldChange();
            }

            public void removeUpdate(DocumentEvent e) {
                onRuleFieldChange();
            }

            public void insertUpdate(DocumentEvent e) {
                onRuleFieldChange();
            }

            private void onRuleFieldChange() {
                // We have to use invokeLater to avoid weirdness, found this approach in
                // https://stackoverflow.com/a/15206902
                Runnable doRfc = new Runnable() {
                    @Override
                    public void run() {
                        cafw.onRuleChange(Integer.parseInt(ruleField.getText()));
                        // ruleField.requestFocus();
                    }
                };
                SwingUtilities.invokeLater(doRfc);
            }
        });
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
