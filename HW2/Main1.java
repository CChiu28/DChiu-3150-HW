import java.util.Scanner;

public class Main1 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int height = 0; //Height of the pyramid
    boolean intCheck; //Check for valid user input
    System.out.print("Enter an integer: ");
    do { //Ask for user input through loop according to state of boolean
      if (cin.hasNextInt()) {
        height = cin.nextInt();
        intCheck = true; //Set true if valid user input
      } else {
          System.out.print("Please enter a valid integer: ");
          intCheck = false; //Set false if invalid input
          cin.next();
        }
    } while (!intCheck); //Loop if invalid input
    for (int row=1; row<=height; row++) { //Loop per level in pyramid
      for (int i=height; i>=row; i--) {
        System.out.printf("%2s", " "); //Insert empty spaces according to level in pyramid
      }
      for (int j=1; j<=row; j++) {
        System.out.printf("%d%s", j, " "); //Output left half of pyramid levle
      }
      for (int k=row-1; k>0; k--) {
          System.out.printf("%d%s", k, " "); //Output right half of pyramid level
      }
      System.out.println(); //Next level of pyramid
    }
    cin.close();
    System.exit(0);
  }
}
