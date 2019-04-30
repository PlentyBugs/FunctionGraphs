package FunctionGraphs;

import java.awt.*;

public class FunctionCustom {

    private Function function;
    private Color color;

    public FunctionCustom(Function function, Color color){
        this.function = function;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    @Override
    public String toString(){
        return "Some Function";
    }
}
