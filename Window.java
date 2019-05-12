package FunctionGraphs;

import FunctionGraphs.ControlPart.ControlPanel;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public static Graph graph = new Graph();
    public static Settings settings = new Settings();
    private JScrollPane scrollGraph = new JScrollPane(graph, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    public static ControlPanel controlPanel = new ControlPanel();

    public Window(){
        super("FunctionGraphs.Graph");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        graph.setScroll(scrollGraph);

        getContentPane().add(settings, BorderLayout.NORTH);
        getContentPane().add(scrollGraph, BorderLayout.WEST);
        getContentPane().add(controlPanel, BorderLayout.EAST);
        pack();
        setVisible(true);
    }
}
