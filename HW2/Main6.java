
// Set Scanner delimiter to empty string ""
// It will tokenize each individual character


import java.util.Scanner;

public class Main6 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    String test = "";
    System.out.print("test: ");
    test = cin.nextLine();
    Scanner delimit = new Scanner(test).useDelimiter(""); //Empty delimiter to tokenize individual characters
    while (delimit.hasNext()) {
      System.out.println(delimit.next());
    }
  }
}
