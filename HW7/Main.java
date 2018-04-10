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
                if (args[i].matches("\\p{Alpha}")) {
                    System.out.println(checkDigit(args[i]));
                    throw new LookAtMrAlgebraOverHereException("Enter a real number kthx");
                } else if (i>0&&checkDigit(args[i])&&checkDigit(args[i-1])) {
                    throw new LookAtMrAlgebraOverHereException("bruh you entered 2 numbers in a row");
                } else if (i>0&&checkOperator(args[i])&&checkOperator(args[i-1]))
                    throw new LookAtMrAlgebraOverHereException("bruh you entered 2 operators in a row");
                input[i] = args[i];
            }
        } catch(LookAtMrAlgebraOverHereException e) {
            System.exit(1);
        }
        System.out.println(Arrays.toString(input));
        try {
            postfix(input);
        } catch(RuntimeException e) {}
        System.exit(1);
    }

    public static double calc(String a, String op, String b) throws RuntimeException {
        double x = Double.parseDouble(a);
        double y = Double.parseDouble(b);
        if (op.equals("*")) {
            return x*y;
        } else if (op.equals("/")) {
            if (y==0)
                throw new ArithmeticException("You destroyed the universe by dividing by 0");
            else return x/y;
        } else if (op.equals("+")) {
            return x+y;
        } else if (op.equals("-")) {
            return x-y;
        } else if (op.equals("%")) {
            return x%y;
        } else throw new IllegalOperationException("bro lrn2math");
    }

    public static double postfix(String[] s) throws RuntimeException {
        Stack<Character> operators = new Stack<>();
        StringBuffer exp = new StringBuffer();
        char paren;
        double result = 0;
        for (int i=0; i<s.length; i++) {
            paren = s[i].charAt(0);
            if (checkDigit(s[i])) {
                exp.append(s[i]+" ");
                //System.out.println(s[i]+" is good");
            } else if (paren=='(') {
                operators.push(s[i].charAt(0));
                //System.out.println(paren+" found");
            } else if (paren==')') {
                //System.out.println(paren+" found");
                while (operators.peek()!='(')
                    exp.append(operators.pop()+" ");
                operators.pop();
            } else {
                while (!operators.empty()&&(operatorPriority(operators.peek())>operatorPriority(paren)))
                    exp.append(operators.pop()+" ");
                operators.push(paren);
            }
        }
        // System.out.println("operators "+operators.toString());
        while (!operators.empty())
            exp.append(operators.pop()+" ");
        System.out.println("digs "+exp.toString());
        // System.out.println(result);
        return result;
    }

    public static boolean checkDigit(String s) {
        for (int i=0; i<s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkOperator(String s) {
        if (s.length()==1&&s.matches("^[%*/+-]"))
            return true;
        else return false;
    }

    public static int operatorPriority(char op) {
        if (op=='+'||op=='-')
            return 1;
        else if (op=='*'||op=='/'||op=='%')
            return 2;
        else return 0;
    }
}

class LookAtMrAlgebraOverHereException extends IllegalArgumentException {
    public LookAtMrAlgebraOverHereException() {}
    public LookAtMrAlgebraOverHereException(String s) {
        System.out.println(s);
    }
}

class IllegalOperationException extends IllegalArgumentException {
    public IllegalOperationException() {}
    public IllegalOperationException(String s) {
        System.out.println(s);
    }
}

class UserIsADumbassException extends IllegalArgumentException {
    public UserIsADumbassException() {}
    public UserIsADumbassException(String s) {
        System.out.println(s);
    }
}