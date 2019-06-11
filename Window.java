package FunctionGraphs;

import FunctionGraphs.ControlPart.ControlPanel;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public static Graph graph = new Graph();
    public static Settings settings = new Settings();
    public static ControlPanel controlPanel = new ControlPanel();

    public Window(){
        super("FunctionGraphs.Graph");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().add(settings, BorderLayout.NORTH);
        getContentPane().add(graph, BorderLayout.WEST);
        getContentPane().add(controlPanel, BorderLayout.EAST);
        pack();
        setVisible(true);
    }
}
