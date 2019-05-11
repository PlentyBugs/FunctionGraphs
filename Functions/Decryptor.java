package FunctionGraphs.Functions;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Stack;

public class Decryptor {

    private FunctionCustom functionCustom;
    private boolean ok;

    public Decryptor(String func, FunctionCustom function){

        Stack<String> brackets = new Stack<>();

        ok = true;

        for(char c : func.toCharArray()){
            if(c == '(')
                brackets.push(String.valueOf(c));
            else if(c == ')' && brackets.size() == 0){
                ok = false;
                break;
            } else if(brackets.size() != 0){
                brackets.pop();
            }
        }
        if(brackets.size() != 0 || !ok) {
            ok = false;
            JFrame frame = new JFrame("Function input error");
            frame.setSize(300, 0);
            frame.setResizable(false);
            frame.setVisible(true);
        }
        if(ok){
            brackets = new Stack<>();
            ArrayList<String> funcs = new ArrayList<>();
            String fun = "";
            for(char c : func.toCharArray()){
                if (c != '(' && c != ')' && c != 'x') {
                    fun += c;
                }
                if(c == '(')
                    brackets.push(String.valueOf(c));
                else if(c == ')' && brackets.size() == 0){
                    ok = false;
                    break;
                } else if(brackets.size() != 0){
                    brackets.pop();
                }
            }
            String finalFun = fun;
            function.setFunction(x -> {
                try {
                    return 100*funcFromString(finalFun, x/100);
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                return x;
            });
            functionCustom = function;

        }
    }

    public boolean isOk(){
        return ok;
    }

    private static double funcFromString(String fx, double arg) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        return (double) Math.class.getMethod(fx, double.class).invoke(null, arg);
    }

    private static Function buildFunction(Function function, String string){
        return function;
    }
}
