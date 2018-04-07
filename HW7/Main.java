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
            calc(input);
        } catch(RuntimeException e) {}
        System.exit(1);
    }

    public static void calc(String[] s) throws RuntimeException {
        double result = 0;
    }

    public static void postfix(String[] s) throws RuntimeException {
        Stack operators = new Stack<>();
        StringBuffer operands = new StringBuffer();
        for (int i=0; i<s.length; i++) {
            
        }
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
}

class UserIsADumbassException extends IllegalArgumentException {
    public UserIsADumbassException() {}
}