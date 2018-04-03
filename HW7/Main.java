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
                if (Character.isAlphabetic(args[i].charAt(0))) {
                    throw new LookAtMrAlgebraOverHereException();
                }
                input[i] = args[i];
            }
        } catch(LookAtMrAlgebraOverHereException e) {
            System.out.println("Enter a real number kthx");
            System.exit(1);
        }
        System.out.println(Arrays.toString(input));
        try {
            calc(input);
        } catch(RuntimeException e) {}
        System.exit(1);
    }

    public static void calc(String[] s) throws RuntimeException {

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