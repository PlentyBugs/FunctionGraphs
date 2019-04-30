package FunctionGraphs;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private Graph graph = new Graph();
    private JScrollPane scrollGraph = new JScrollPane(graph, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    private ControlPanel controlPanel = new ControlPanel();

    public Window(){
        super("FunctionGraphs.Graph");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().add(scrollGraph, BorderLayout.WEST);
        getContentPane().add(controlPanel, BorderLayout.EAST);
        pack();
        setVisible(true);
        drawWindow();
    }

    private void drawWindow(){
    }
}
