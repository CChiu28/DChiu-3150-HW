import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String[] input = new String[args.length];
        // char[] cArray = args[].toCharArray();
        try {
            if (args.length==0)
                System.out.println("Empty");
            else for (int i=0; i<args.length; i++) {
                // if (args[i].matches("\\p{Alpha}")) {
                //     System.out.println(checkDigit(args[i]));
                //     throw new AlgebraFailException("Enter a real number kthx");
                // } else if (i>0&&checkDigit(args[i])&&checkDigit(args[i-1])) {
                //     throw new AlgebraFailException("bruh you entered 2 numbers in a row");
                // } else if (i>0&&checkOperator(args[i])&&checkOperator(args[i-1])) {
                //     throw new AlgebraFailException("bruh you entered 2 operators in a row");
                // } else if (i==0&&checkOperator(args[i]))
                //     throw new UserIsADumbassException("Bruh you forgot a number");
                input[i] = args[i];
            }
        } catch(AlgebraFailException e) {
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println(Arrays.toString(input));
        try {
            String[] postfix = new String[postfix(input).length()];
            postfix = postfix(input).split(" ");
            System.out.println(Arrays.toString(postfix));
            System.out.println(calc(postfix));
        } catch(UserIsADumbassException e) {
            System.out.println("At least try to math correctly");
            // e.printStackTrace();
            System.exit(0);
        } catch(QuitMashingOnYourKeyboardException e) {
            System.out.println("bruh...");
            // e.printStackTrace();
            System.exit(0);
        } catch(AlgebraFailException e) {
            // e.printStackTrace();
            System.exit(0);
        }
        System.exit(1);
    }

    public static double calc(String[] exp) {
        double x = 0;
        double y = 0;
        double result = 0;
        Stack<String> calc = new Stack<>();
        for (String s:exp) {
            if (checkDigit(s))
                calc.push(s);
            else {
                y = Double.parseDouble(calc.pop());
                x = Double.parseDouble(calc.pop());
                if (s.equals("*")||s.equals("x")) {
                    calc.push(Double.toString(x*y));
                } else if (s.equals("/")) {
                    if (y==0)
                        throw new ArithmeticException("You destroyed the universe by dividing by 0");
                    else calc.push(Double.toString(x/y));
                } else if (s.equals("+")) {
                    calc.push(Double.toString(x+y));
                } else if (s.equals("-")) {
                    calc.push(Double.toString(x-y));
                } else if (s.equals("%")) {
                    calc.push(Double.toString(x%y));
                } else throw new QuitMashingOnYourKeyboardException("bro lrn2math");
            }
        }
        return Double.parseDouble(calc.pop());
    }

    public static String postfix(String[] s) throws RuntimeException {
        Stack<Character> operators = new Stack<>();
        StringBuffer exp = new StringBuffer();
        char paren;
        double result = 0;
        if (s.length==0||s.length==1||s.length==2)
            throw new UserIsADumbassException();
        else if (checkOperator(s[0]))
            throw new AlgebraFailException("bruh operators before numbers? wtf?");
        else for (int i=0; i<s.length; i++) {
            paren = s[i].charAt(0);
            if (checkDigit(s[i])) {
                if (i<s.length-1&&checkDigit(s[i+1]))
                    throw new AlgebraFailException("bruh multiple numbers in a row");
                else exp.append(s[i]+" ");
                //System.out.println(s[i]+" is good");
            } else if (paren=='(') {
                if (i<s.length-1&&checkOperator(s[i+1]))
                    throw new AlgebraFailException("operator after open paren");
                operators.push(s[i].charAt(0));
                //System.out.println(paren+" found");
            } else if (paren==')') {
                //System.out.println(paren+" found");
                while (operators.peek()!='(')
                    exp.append(operators.pop()+" ");
                if (operators.peek()!='(')
                    throw new QuitMashingOnYourKeyboardException("bruh...double open parens?");
                else operators.pop();
            } else {
                while (!operators.empty()&&(operatorPriority(operators.peek())>operatorPriority(paren)))
                    exp.append(operators.pop()+" ");
                operators.push(paren);
            }
        }
        // System.out.println("operators "+operators.toString());
        while (!operators.empty())
            exp.append(operators.pop()+" ");
        // System.out.println("digs "+exp.toString());
        // System.out.println(result);
        return exp.toString();
    }

    public static boolean checkDigit(String s) {
        boolean isDigit = true;
        for (int i=0; i<s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                isDigit = false;
            }
        }
        return isDigit;
    }

    public static boolean checkOperator(String s) {
        if (s.length()==1&&s.matches("^[%*x/+-]"))
            return true;
        else return false;
    }

    public static int operatorPriority(char op) {
        if (op=='+'||op=='-')
            return 1;
        else if (op=='*'||op=='/'||op=='%'||op=='x')
            return 2;
        else return 0;
    }
}

class AlgebraFailException extends IllegalArgumentException {
    public AlgebraFailException() {}
    public AlgebraFailException(String s) {
        System.out.println(s);
    }
}

class QuitMashingOnYourKeyboardException extends IllegalArgumentException {
    public QuitMashingOnYourKeyboardException() {}
    public QuitMashingOnYourKeyboardException(String s) {
        System.out.println(s);
    }
}

class UserIsADumbassException extends IllegalArgumentException {
    public UserIsADumbassException() {}
    public UserIsADumbassException(String s) {
        System.out.println(s);
    }
}