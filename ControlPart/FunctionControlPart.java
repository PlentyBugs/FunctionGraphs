package FunctionGraphs.ControlPart;

import FunctionGraphs.Functions.FunctionCustom;
import FunctionGraphs.Graph;
import FunctionGraphs.Window;

import javax.swing.*;
import java.awt.*;

public class FunctionControlPart extends JPanel {

    public FunctionControlPart(FunctionCustom function){
        setPreferredSize(new Dimension(300, 30));
        setMinimumSize(new Dimension(300, 30));
        setMaximumSize(new Dimension(300, 30));

        JLabel fun = new JLabel(String.valueOf(function));
        JComboBox<String> colors = new JComboBox<>(new String[]{"Cyan", "Red", "Blue", "Magenta", "Orange", "Yellow", "Pink"});
        colors.addActionListener(e -> {
            Color color = Color.red;
            switch (colors.getItemAt(colors.getSelectedIndex())){
                case "Cyan": color = Color.cyan; break;
                case "Red": color = Color.red; break;
                case "Blue": color = Color.blue; break;
                case "Magenta": color = Color.magenta; break;
                case "Orange": color = Color.orange; break;
                case "Yellow": color = Color.yellow; break;
                case "Pink": color = Color.pink; break;
            }
            function.setColor(color);
            Window.graph.repaint();
        });
        JButton remove = new JButton("X");
        remove.addActionListener(e -> {
            Graph.removeFunction(function);
            Window.graph.repaint();
            Window.controlPanel.drawWindow();
        });

        add(fun, BorderLayout.WEST);
        add(colors, BorderLayout.CENTER);
        add(remove, BorderLayout.EAST);
    }
}
