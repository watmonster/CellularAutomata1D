package ProcessingSwingMerge;
//from: https://discourse.processing.org/t/how-to-use-swing-components-with-processing-3-3-6/36219

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.lang.reflect.*;
import processing.core.PApplet;

public class SwingConstructor {
    public static PApplet genericPapplet;

    public static void setPApplet(PApplet p) {
        genericPapplet = p;
    }

    public static int offset = 15;

    public static ActionListener callMethodOnClick(String method, PApplet pa) {
        final String parse = method;
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Method functions = pa.getClass().getMethod(parse, new Class[] {});
                    functions.invoke(pa, new Object[] {});
                } catch (Exception exc) {
                }
            }
        };
    }

    public static void callMethodOnClick(AbstractButton button, String method, PApplet pa) {
        button.addActionListener(callMethodOnClick(method, pa));
    }

    public static JPanel list_col(Container... c) {
        JPanel ret = new JPanel();
        // ret.setLayout(new BoxLayout(ret, BoxLayout.X_AXIS));
        int w = 0;
        int h = 0;
        for (Container i : c) {
            ret.add(i);
            Dimension d = i.getPreferredSize();
            w += d.width + offset;
            h = Math.max(h, d.height);
        }
        h = offset;
        ret.setPreferredSize(new Dimension(w, h));
        return ret;
    }

    public static JPanel list_row(Container... c) {
        JPanel ret = new JPanel();
        ret.setLayout(new BoxLayout(ret, BoxLayout.Y_AXIS));
        int w = 0;
        int h = 0;
        for (Container i : c) {
            ret.add(i);
            Dimension d = i.getPreferredSize();
            h += d.height + offset;
            w = Math.max(h, d.width);
        }
        ret.setPreferredSize(new Dimension(w, h));
        return ret;
    }

    public static JScrollPane scrollable(Container content) {
        return new JScrollPane(content);
    }

    public static JScrollPane scrollable(Container content, int w, int h) {
        JScrollPane ret = new JScrollPane(content);
        ret.setPreferredSize(new Dimension(w, h));
        return ret;
    }

    //public static JFrame merge(Container swingContent, String where) {
        //PApplet programm = genericPapplet;
    public static JFrame mergePAppletSwing(PApplet programm, Container swingContent, String where) {

        // Get a Container of the PApplet
        // JFrame mainFrame = (JFrame) ((processing.awt.PSurfaceAWT.SmoothCanvas) programm.getSurface().getNative())
        //         .getFrame();
        // Container processing_content = mainFrame.getContentPane();
        // processing_content.setPreferredSize(new Dimension(programm.width, programm.height));

        Container processing_content = getPAppletContent(programm);

        // Create new Window
        JFrame window = new JFrame();

        // add swingContent
        window.add(swingContent);
        // add swingContent
        window.add(processing_content, where);

        // Get rid of evidence
        //mainFrame.setVisible(false);
        window.setSize(new Dimension(programm.width + swingContent.getPreferredSize().width,
                Math.max(programm.height, swingContent.getPreferredSize().height)));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return window;
    }

    public static Container getPAppletContent(PApplet p){
        JFrame mainFrame = (JFrame) ((processing.awt.PSurfaceAWT.SmoothCanvas) p.getSurface().getNative())
                .getFrame();
        Container processing_content = mainFrame.getContentPane();
        processing_content.setPreferredSize(new Dimension(p.width, p.height));
        mainFrame.setVisible(false);
        return processing_content;
    }

    public static JFrame mergePAppletPApplet(PApplet p1, PApplet p2, String where) {

        // Get a Container of the PApplet
        JFrame mainFrame = (JFrame) ((processing.awt.PSurfaceAWT.SmoothCanvas) p1.getSurface().getNative())
                .getFrame();
        Container processing_content = mainFrame.getContentPane();
        processing_content.setPreferredSize(new Dimension(p1.width, p1.height));

        JFrame mainFrame2 = (JFrame) ((processing.awt.PSurfaceAWT.SmoothCanvas) p2.getSurface().getNative())
                .getFrame();
        Container processing_content2 = mainFrame2.getContentPane();
        processing_content2.setPreferredSize(new Dimension(p2.width, p2.height));

        // Create new Window
        JFrame window = new JFrame();

        // // add swingContent
        // window.add(swingContent);
        // // add swingContent
        // window.add(processing_content, where);

        // // Get rid of evidence
        // mainFrame.setVisible(false);
        // window.setSize(new Dimension(p1.width + swingContent.getPreferredSize().width,
        //         Math.max(p1.height, swingContent.getPreferredSize().height)));
        // window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return window;
    }
}