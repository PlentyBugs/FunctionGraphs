package FunctionGraphs;

import javax.swing.*;
import java.awt.*;

public class Settings extends JMenuBar {

    public Settings(){

        setLayout(new BorderLayout());

        JSlider segmentSlider = new JSlider();
        JLabel textArea = new JLabel("Segment: " + Graph.getSegment());
        segmentSlider.setMinimum(10);
        segmentSlider.setMaximum(150);
        segmentSlider.setValue(Graph.getSegment());
        segmentSlider.addChangeListener(e -> {
            Graph.setSegment(segmentSlider.getValue());
            textArea.setText("Segment: " + segmentSlider.getValue());
            Window.graph.repaint();
        });
        JPanel panel = new JPanel(new BorderLayout());

        panel.add(segmentSlider, BorderLayout.WEST);
        panel.add(textArea, BorderLayout.EAST);

        add(panel, BorderLayout.WEST);

        JLabel labelChooseBackground = new JLabel("Background color: ");
        JButton blackBack = new JButton();
        blackBack.addActionListener(e -> {
            Window.graph.setBackground(Color.black);
            Window.graph.setArrows(Color.green);
            Window.graph.setWeb(Color.gray);
            Window.graph.setNumbers(Color.cyan);
            Window.graph.repaint();
        });
        blackBack.setBackground(Color.black);
        JButton whiteBack = new JButton();
        whiteBack.addActionListener(e -> {
            Window.graph.setBackground(Color.white);
            Window.graph.setArrows(Color.black);
            Window.graph.setWeb(Color.gray);
            Window.graph.setNumbers(Color.BLUE);
            Window.graph.repaint();
        });
        whiteBack.setBackground(Color.white);
        JButton brownBack = new JButton();
        brownBack.addActionListener(e -> {
            Window.graph.setBackground(new Color(210, 87, 0));
            Window.graph.setArrows(Color.green);
            Window.graph.setWeb(Color.yellow);
            Window.graph.setNumbers(Color.cyan);
            Window.graph.repaint();
        });
        brownBack.setBackground(new Color(210, 87, 0));
        JButton lightBrownBack = new JButton();
        lightBrownBack.addActionListener(e -> {
            Window.graph.setBackground(new Color(233, 161, 0));
            Window.graph.setArrows(Color.green);
            Window.graph.setWeb(Color.yellow);
            Window.graph.setNumbers(Color.cyan);
            Window.graph.repaint();
        });
        lightBrownBack.setBackground(new Color(233, 161, 0));

        JPanel backPanel = new JPanel();

        backPanel.add(labelChooseBackground);
        backPanel.add(blackBack);
        backPanel.add(whiteBack);
        backPanel.add(brownBack);
        backPanel.add(lightBrownBack);

        add(backPanel, BorderLayout.EAST);
    }
}
