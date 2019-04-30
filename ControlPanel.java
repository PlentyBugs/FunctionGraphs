package FunctionGraphs;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    private int width = 360;
    private int height = 720;

    public ControlPanel(){
        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
    }
}
