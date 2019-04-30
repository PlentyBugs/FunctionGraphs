package FunctionGraphs;

public class Main {
    public static void main(String[] args){
        new Window();
        Graph.addFunction(x -> Math.sqrt(350*350 - x*x));
        Graph.addFunction(x -> -Math.sqrt(350*350 - x*x));
    }
}