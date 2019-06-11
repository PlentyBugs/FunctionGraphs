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

    private static int segment = 30;
    private final Color BACKGROUND = Color.black;
    private Color arrows = Color.green;
    private Color web = Color.gray;
    private Color numbers = Color.cyan;

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
        graphics2D.setFont(new Font("TimesRoman", Font.PLAIN, (int)(segment/2.5)));
        graphics2D.setColor(arrows);

        graphics2D.setStroke(new BasicStroke(2));

        graphics2D.drawLine(width/2, 0, width/2, height);
        graphics2D.drawLine(0, height/2, width, height/2);
        graphics2D.drawLine(width/2 - 5, 5, width/2, 0);
        graphics2D.drawLine(width/2, 0, width/2+5,  5);
        graphics2D.drawLine(width - 5, height/2 - 5, width, height/2);
        graphics2D.drawLine(width, height/2, width-5, height/2+5);

        graphics2D.setStroke(new BasicStroke(1));

        for(int x = width/2 + segment; x < width; x += segment){
            graphics2D.setColor(web);
            Line2D line2D = new Line2D.Double(x, 0, x, height);
            Line2D line2D2 = new Line2D.Double(0, x, width, x);
            graphics2D.draw(line2D);
            graphics2D.draw(line2D2);
            graphics2D.setColor(numbers);
            graphics2D.drawString(Integer.toString(x - width/2), x, height/2+segment/2);
            graphics2D.drawString(Integer.toString(-x + height/2), width/2, x);
        }
        graphics2D.drawString("0", width/2, height/2+segment/2);
        for(int x = width/2 - segment; x > 0; x -= segment){
            graphics2D.setColor(web);
            Line2D line2D = new Line2D.Double(x, 0, x, height);
            Line2D line2D2 = new Line2D.Double(0, x, width, x);
            graphics2D.draw(line2D);
            graphics2D.draw(line2D2);
            graphics2D.setColor(numbers);
            graphics2D.drawString(Integer.toString(x - width/2), x, height/2+segment/2);
            graphics2D.drawString(Integer.toString(-x + height/2), width/2, x);
        }

        for(FunctionCustom function : functions){
            graphics2D.setColor(function.getColor());
            for(double x = -(width*3)/2.0; x < (width*3)/2; x += STEP){
                double y = height/2.0 - function.getFunction().getY((x)/segment)*segment;
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

    public void setScroll(JScrollPane scrollGraph) {
        scrollGraph.setPreferredSize(new Dimension(width, height));
        scrollGraph.setMinimumSize(new Dimension(width, height));
        scrollGraph.setMaximumSize(new Dimension(width, height));
    }

    public static void setSegment(int segment) {
        Graph.segment = segment;
    }

    public static int getSegment() {
        return segment;
    }

    public void setArrows(Color arrows) {
        this.arrows = arrows;
    }

    public void setWeb(Color web) {
        this.web = web;
    }

    public void setNumbers(Color numbers) {
        this.numbers = numbers;
    }
}
