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
                if (!checkDigit(args[i])&&!checkOperator(args[i])) {
                    System.out.println(checkDigit(args[i]));
                    throw new LookAtMrAlgebraOverHereException("Enter a real number kthx");
                } else if (i>0&&checkDigit(args[i])&&checkDigit(args[i-1]))
                    throw new LookAtMrAlgebraOverHereException("bruh you entered 2 numbers in a row");
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
            return x/y;
        } else if (op.equals("+")) {
            return x+y;
        } else if (op.equals("-")) {
            return x-y;
        } else throw new IllegalOperationException();
    }

    public static double postfix(String[] s) throws RuntimeException {
        Stack<String> operators = new Stack<>();
        StringBuffer operands = new StringBuffer();
        double result = 0;
        for (int i=0; i<s.length; i++) {
            // if (checkDigit(s[i])) {
            //     operands.append(s[i]);
            // } else if (checkOperator(s[i])) {
            //     operators.push(s[i]);
            // }
            if (s[i].equals("(")) {
                for (int j=i; j<s.length; j++) {
                    if (s[j].equals(")")) {
                        String[] temp = new String[j-i];
                        temp = Arrays.copyOfRange(s, i+1, j);
                        System.out.println(Arrays.toString(temp));
                        result = postfix(temp);
                    }
                }
            }
            if (s[i].matches("{1}[%()*/+-]")) {
                result = calc(s[i-1],s[i],s[i+1]);
            }
        }
        System.out.println("digs "+operands);
        System.out.println("operators "+operators.toString());
        System.out.println(result);
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
        if (s.matches("{1}[%()*/+-]"))
            return true;
        else return false;
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