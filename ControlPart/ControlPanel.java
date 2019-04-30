package FunctionGraphs.ControlPart;

import FunctionGraphs.FunctionCustom;
import FunctionGraphs.Graph;
import FunctionGraphs.Window;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    private int width = 360;
    private int height = 720;
    private JPanel functions = new JPanel(new GridBagLayout());
    private JScrollPane scrollPane = new JScrollPane(functions);
    private JPanel newFunction = new JPanel(new BorderLayout());
    private JTextArea func = new JTextArea();
    private JButton add = new JButton("Add");

    public ControlPanel(){
        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));

        add.addActionListener(e -> {
            Graph.addFunction(new FunctionCustom(x -> x, Color.red));
            Window.graph.repaint();
            drawWindow();
        });

        scrollPane.setPreferredSize(new Dimension(width-20, 3*height/4));
        scrollPane.setMinimumSize(new Dimension(width-20, 3*height/4));
        scrollPane.setMaximumSize(new Dimension(width-20, 3*height/4));

        newFunction.setPreferredSize(new Dimension(width-20, height/4));
        newFunction.setMinimumSize(new Dimension(width-20, height/4));
        newFunction.setMaximumSize(new Dimension(width-20, height/4));

        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("y(x) = ");

        panel.add(label, BorderLayout.WEST);
        panel.add(func, BorderLayout.EAST);

        func.setPreferredSize(new Dimension(width-60, height/4 - 40));
        func.setMinimumSize(new Dimension(width-60, height/4 - 40));
        func.setMaximumSize(new Dimension(width-60, height/4 - 40));

        newFunction.add(panel, BorderLayout.NORTH);
        newFunction.add(add, BorderLayout.SOUTH);

        add(scrollPane, BorderLayout.NORTH);
        add(newFunction, BorderLayout.SOUTH);
        drawWindow();
    }

    public void drawWindow(){
        functions.removeAll();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.NORTH;

        for(FunctionCustom function : Graph.getFunctions()){
            functions.add(new FunctionControlPart(function), constraints);
            constraints.gridy ++;
        }

        repaint();
        revalidate();
    }
}
