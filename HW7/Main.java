import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String[] input = new String[args.length]; // New String array for args values
        try {
            if (args.length<3)
                throw new UserIsADumbassException("lolemptyinputlikeyourbrain");
            else {
                input = Arrays.copyOf(args, args.length); // Copy args array into input array
                // System.out.println("Infix "+Arrays.toString(input));
                String[] postfix = new String[in2post(input).length()]; // New postfix array of length of returning postfix expression
                postfix = in2post(input).split(" "); // Populate postfix array by splitting returning expression's values
                // System.out.println("Postfix "+Arrays.toString(postfix));
                System.out.println(calc(postfix)); // Calculate expression and print
            }
        } catch(UserIsADumbassException e) {
            System.exit(0);
        } catch(QuitMashingOnYourKeyboardException e) {
            System.exit(0);
        } catch(AlgebraFailException e) {
            System.exit(0);
        } catch(ArithmeticException e) {
            System.out.println("You destroyed the universe by dividing by 0");
            System.exit(0);
        }
        System.exit(1);
    }

    // Calculation function
    public static double calc(String[] exp) throws ArithmeticException {
        double x = 0; // First value
        double y = 0; // Second value
        Stack<String> calc = new Stack<>(); // Stack for taking expression
        for (String s:exp) { // Enhanced for loop for quicker value copying
            if (checkDigit(s)) // If valid digit, push to stack
                calc.push(s);
            else { // else pop digits and calculate
                y = Double.parseDouble(calc.pop()); // Take second value
                x = Double.parseDouble(calc.pop()); // Take first value
                if (s.equals("*")||s.equals("x")) { // Terminal can break when taking asterisks so replace with 'x'
                    calc.push(Double.toString(x*y)); // Push current calculated result to stack
                } else if (s.equals("/")) {
                    if (y==0) // UNIVERSE IMPLOSION
                        throw new ArithmeticException();
                    else calc.push(Double.toString(x/y));
                } else if (s.equals("+")) {
                    calc.push(Double.toString(x+y));
                } else if (s.equals("-")) {
                    calc.push(Double.toString(x-y));
                } else if (s.equals("%")) {
                    calc.push(Double.toString(x%y));
                } else throw new QuitMashingOnYourKeyboardException("bro lrn2math"); // Throw if operators are invalid
            }
        }
        return Double.parseDouble(calc.pop());
    }

    public static String in2post(String[] s) {
        Stack<Character> operators = new Stack<>(); // Stack for operators
        StringBuffer exp = new StringBuffer(); // StringBuffer for postfix expression
        char paren; // Check for parenthesis
        if (checkOperator(s[0])) // If first input is operator, throw exception
            throw new AlgebraFailException("bruh operators before numbers? wtf?");
        else for (int i=0; i<s.length; i++) { // Begin looping string array for expression
            paren = s[i].charAt(0); // Checking for parenthesis later...
            if (checkDigit(s[i])) { // If ith value is a digit,
                if (i<s.length-1&&checkDigit(s[i+1])) // check the i+1 for digit, throw exception accordingly
                    throw new AlgebraFailException("bruh multiple numbers in a row");
                else exp.append(s[i]+" "); // else append valid digit to stringbuffer
            } else if (paren=='(') { // If ith value is open parenthesis,
                if (i<s.length-1&&checkOperator(s[i+1])) // Check next input for operator, throw exception accordingly
                    throw new AlgebraFailException("operator after open paren");
                else if (i<s.length-1&&s[i+1].charAt(0)==')') // and check for immediate closing parenthesis, throw accordingly
                    throw new QuitMashingOnYourKeyboardException("Empty parenthesis bruh");
                operators.push(s[i].charAt(0)); // else push the parenthesis to stack
            } else if (paren==')') { // If ith value is closing parenthesis
                while (operators.peek()!='(') // Add all operators to stringbuffer until open parenthesis
                    exp.append(operators.pop()+" ");
                operators.pop(); // Get rid of open parenthesis on stack
            } else { // If it's an operator...
                while (!operators.empty()&&(operatorPriority(operators.peek())>operatorPriority(paren))) // Check for existing operators and PEMDAS order
                    exp.append(operators.pop()+" "); // Add higher operator to stringbuffer if valid
                operators.push(paren); // and then push current operator to stack
            }
        }
        while (!operators.empty()) // At end of expression, pop all remaining operators
            exp.append(operators.pop()+" ");
        return exp.toString();
    }

    // Function to check if valid digit
    public static boolean checkDigit(String s) {
        try {
            Integer.parseInt(s); // Checks for valid integer
        } catch(NumberFormatException e) {
            try {
                Double.parseDouble(s); // Checks for valid double if not integer
            } catch(NumberFormatException f) {
                return false; // False if both fail
            }
        }
        return true;
    }

    // Checks for valid operators via regex
    public static boolean checkOperator(String s) {
        if (s.length()==1&&s.matches("^[%*x/+-]"))
            return true;
        else return false;
    }

    // Checks for PEMDAS priority
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