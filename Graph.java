package FunctionGraphs;

import FunctionGraphs.Functions.FunctionCustom;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Graph extends JPanel {

    private int width = 720;
    private int height = 720;
    private final double STEP = 0.01;
    private static ArrayList<FunctionCustom> functions = new ArrayList<>();
    private final Color BACKGROUND = Color.black;

    public Graph(){
        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setBackground(BACKGROUND);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.green);

        graphics2D.drawLine(width/2, 0, width/2, height);
        graphics2D.drawLine(0, height/2, width, height/2);
        graphics2D.drawLine(width/2 - 5, 5, width/2, 0);
        graphics2D.drawLine(width/2, 0, width/2+5,  5);
        graphics2D.drawLine(width - 5, height/2 - 5, width, height/2);
        graphics2D.drawLine(width, height/2, width-5, height/2+5);

        graphics2D.setColor(Color.gray);
        for(int x = width/2 + 50; x < width; x += 50){
            Line2D line2D = new Line2D.Double(x, 0, x, height);
            Line2D line2D2 = new Line2D.Double(0, x, width, x);
            graphics2D.draw(line2D);
            graphics2D.draw(line2D2);
        }
        for(int x = width/2 - 50; x > 0; x -= 50){
            Line2D line2D = new Line2D.Double(x, 0, x, height);
            Line2D line2D2 = new Line2D.Double(0, x, width, x);
            graphics2D.draw(line2D);
            graphics2D.draw(line2D2);
        }

        for(FunctionCustom function : functions){
            graphics2D.setColor(function.getColor());
            for(double x = -width/2.0; x < width/2; x += STEP){
                double y = height/2.0 - function.getFunction().getY(x);
                Line2D line2D = new Line2D.Double(x + width/2.0, y, x + width/2.0, y);
                graphics2D.draw(line2D);
            }
        }
    }

    public static void addFunction(FunctionCustom function){
        functions.add(function);
    }

    public static void removeFunction(FunctionCustom function){
        functions.remove(function);
    }

    public static ArrayList<FunctionCustom> getFunctions() {
        return functions;
    }
}
