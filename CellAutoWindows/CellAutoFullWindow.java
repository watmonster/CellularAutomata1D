package CellAutoWindows;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ProcessingSwingMerge.SwingConstructor;
import TControls.TControlGroup;
import processing.core.PApplet;
import Helpers.Logging;

public class CellAutoFullWindow {

    public CellAutoControls cac;
    public TControlGroup tcg;
    public CellAutoRunner car;
    public int ruleNum;

    public CellAutoFullWindow() {
        this.car = new CellAutoRunner(); // car.cgdisp
        this.cac = new CellAutoControls(car, this); // cac.panel
        this.tcg = new TControlGroup(this); // already a papplet
    }

    public void onRuleChange(int newRule) {
        if (newRule != this.ruleNum) {
            Logging.logWithTimeStamp("onrulechange called with new rule: " + newRule);
            this.ruleNum = newRule;
            tcg.setRule(this.ruleNum);
            cac.setRule(this.ruleNum);
        }else{
            Logging.logWithTimeStamp("onrulechange called with old rule: " + newRule);
        }
    }

    public JFrame buildWindow() {
        Container cgdispcontainer = SwingConstructor.getPAppletContent(car.cgdisp);
        JPanel merge1 = new JPanel();
        merge1.setLayout(new BoxLayout(merge1, BoxLayout.X_AXIS));
        merge1.add(cac.panel);
        merge1.add(cgdispcontainer);
        int w = car.cgdisp.width + cac.panel.getPreferredSize().width;
        int h = car.cgdisp.height;
        merge1.setSize(new Dimension(w,h));
        Container tcgcontainer = SwingConstructor.getPAppletContent(tcg);
        JPanel merge2 = new JPanel();
        merge2.setLayout(new BoxLayout(merge2, BoxLayout.Y_AXIS));
        merge2.add(tcgcontainer);
        merge2.add(merge1);
        int w2 = Math.max(tcg.width, merge1.getPreferredSize().width);
        int h2 = tcg.height + merge1.getPreferredSize().height;
        merge2.setSize(new Dimension(w2, h2));
        JFrame merge3 = new JFrame();
        merge3.add(merge2);
        merge3.setSize(new Dimension(w2, h2+80));
        return merge3;
    }

    public static void main(String[] args) {
        CellAutoFullWindow cafw = new CellAutoFullWindow();
        String[] processingArgs1 = { "TControlsMain" };
        PApplet.runSketch(processingArgs1, cafw.tcg);
        JFrame bw = cafw.buildWindow();
        bw.setVisible(true);
        bw.setTitle("BuildWindow");
    }
}
