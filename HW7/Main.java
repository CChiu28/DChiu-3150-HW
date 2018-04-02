import java.util.*;

public class Main {
    public static void main(String[] args) {
        StringBuffer input = new StringBuffer();
        for (int i=0; i<args.length; i++)
            input.append(args[i]);
        System.out.print(input);
    }
}

class LookAtMrAlgebraOverHereException extends IllegalArgumentException {
    public LookAtMrAlgebraOverHereException() {}
}

class IllegalOperationException extends IllegalArgumentException {
    public IllegalOperationException() {}
}

class UserIsADumbassException extends IllegalArgumentException {
    public UserIsADumbassException() {}
}