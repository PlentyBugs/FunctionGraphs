package FunctionGraphs.Functions;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class Decryptor {

    private FunctionCustom functionCustom;

    public Decryptor(String func, FunctionCustom function){

        Stack<String> brackets = new Stack<>();

        for(char c : func.toCharArray()){
            if(c == '(')
                brackets.push(String.valueOf(c));
            else if(c == ')' && brackets.size() == 0){
                JFrame frame = new JFrame("Function input error");
                frame.setSize(300, 0);
                frame.setResizable(false);
                frame.setVisible(true);
                break;
            } else {
                brackets.pop();
            }
        }

        function.setFunction(x -> x*Math.sin(Math.log(x)));
        functionCustom = function;
    }

    public FunctionCustom getFunctionCustom() {
        return functionCustom;
    }
}
