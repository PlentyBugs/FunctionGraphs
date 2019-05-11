package FunctionGraphs.Functions;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

public class ParserFunc {

    public static Function parseFunc(String strPrev){
        Stack<String> ops = new Stack<>();
        Stack<Function> func = new Stack<>();

        String str = "";

        for(char c : strPrev.toCharArray()){
            if(c != ' ')
                str += c;
        }

        while(str.length() != 0){
            String s = "";
            boolean isFunc = false;
            int counter = 0;
            for(char c : str.toCharArray()){
                if(c != '(' && c != ')' && c != '+' && c != '-' && c != '*' && c != '/' && c != '^' && c != 'x'
                        && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8' && c != '9' && c != '0'){
                    s += c;
                    counter ++;
                    isFunc = true;
                } else
                    break;
            }

            String st = str.substring(0, 1);

            if(st.equals("(")){
                str = str.substring(1);
            } else if(st.equals("+")){
                ops.push(st);
                str = str.substring(1);
            } else if(st.equals("-")){
                ops.push(st);
                str = str.substring(1);
            } else if(st.equals("*")){
                ops.push(st);
                str = str.substring(1);
            } else if(st.equals("/")){
                ops.push(st);
                str = str.substring(1);
            } else if(st.equals("^")){
                ops.push(st);
                str = str.substring(1);
            } else if(isFunc){
                ops.push(s);
                str = str.substring(counter);
            } else if(st.equals(")")){
                str = str.substring(1);
                String op = ops.pop();
                Function function = func.pop();
                Function f;

                if      (op.equals("+")){
                    Function fu = func.pop();
                    f = x -> fu.getY(x) + function.getY(x);
                }
                else if (op.equals("-")){
                    Function fu = func.pop();
                    f = x -> fu.getY(x) - function.getY(x);
                }
                else if (op.equals("*")){
                    Function fu = func.pop();
                    f = x -> fu.getY(x) * function.getY(x);
                }
                else if (op.equals("/")){
                    Function fu = func.pop();
                    f = x -> fu.getY(x) / function.getY(x);
                }
                else if (op.equals("^")){
                    Function fu = func.pop();
                    f = x -> Math.pow(fu.getY(x), function.getY(x));
                }
                else
                    f = x -> funcFromString(op, function.getY(x));
                func.push(f);
            } else if(st.equals("x")){
                func.push(x -> x);
                str = str.substring(1);
            } else {
                s = "";
                counter = 0;
                for(char c : str.toCharArray()){
                    if(c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0'){
                        s += c;
                        counter ++;
                    } else
                        break;
                }
                String finalS = s;
                func.push(x -> Double.parseDouble(finalS));
                str = str.substring(counter);
            }
        }

        return func.pop();
    }

    private static double funcFromString(String fx, double arg) {
        try {
            return (double) Math.class.getMethod(fx, double.class).invoke(null, arg);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
