import java.util.Scanner;

public class Main2 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int year = 0;
    boolean inputCheck;
    String day;
    String[] week = new String[] {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    System.out.print("Enter a year: ");
    do {
      if (cin.hasNextInt()) {
        year = cin.nextInt();
        inputCheck = true;
      } else {
          System.out.print("Please enter a valid year: ");
          inputCheck = false;
          cin.next();
        }
    } while (!inputCheck);
    System.out.print("Enter the day the first day of January falls on: ");
    do {
      day = cin.nextLine();
    } while (!day.contains);
    System.out.print(day);
  }
}
