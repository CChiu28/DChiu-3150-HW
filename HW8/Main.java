import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File root = new File(args[0]);
        if (!root.exists())
            throw new IllegalArgumentException("No dir here");
        else {
            System.out.println(Arrays.toString(root.list()));
            StringBuffer tree = new StringBuffer();
            
        }
    }
}