import java.util.Scanner;

public class Main5 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in); //Scanner to take user input
    System.out.print("Test the comma delimiter: ");
    String test = cin.nextLine();
    Scanner delimit = new Scanner(test).useDelimiter(","); //Scanner to take String using new delimiter
    while (delimit.hasNext())
      System.out.println(delimit.next());
  }
}
