package ProcessingSwingTest;
//from: https://discourse.processing.org/t/how-to-use-swing-components-with-processing-3-3-6/36219

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.lang.reflect.*;
import processing.core.PApplet;

class SwingConstructor {
    public static PApplet genericPapplet;

    public static void setPApplet(PApplet p) {
        genericPapplet = p;
    }

    public static int offset = 15;

    public static ActionListener callMethodOnClick(String method) {
        final String parse = method;
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Method functions = genericPapplet.getClass().getMethod(parse, new Class[] {});
                    functions.invoke(genericPapplet, new Object[] {});
                } catch (Exception exc) {
                }
            }
        };
    }

    public static void callMethodOnClick(AbstractButton button, String method) {
        button.addActionListener(callMethodOnClick(method));
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

    public static JFrame merge(Container content, String where) {
        PApplet programm = genericPapplet;
        // Create new Window with Swing components
        JFrame window = new JFrame();
        window.add(content);

        // Transfer the Window
        JFrame mainFrame = (JFrame) ((processing.awt.PSurfaceAWT.SmoothCanvas) programm.getSurface().getNative())
                .getFrame();
        Container processing_content = mainFrame.getContentPane();
        processing_content.setPreferredSize(new Dimension(programm.width, programm.height));
        window.add(processing_content, where);

        // Get rid of evidence
        mainFrame.setVisible(false);
        window.setSize(new Dimension(programm.width + content.getPreferredSize().width,
                Math.max(programm.height, content.getPreferredSize().height)));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return window;
    }
}