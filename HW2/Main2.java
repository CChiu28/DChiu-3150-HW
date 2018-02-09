import java.util.Scanner;

public class Main2 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int year = 0;
    boolean inputCheck;
    String day = "";
    String[] calendar = {"","January","February","March","April","May","June","July","August","September","October","November","December"};
    int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
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
    if ((year%4)==0)
      days[3] = 29;
    System.out.print("Enter the day the first day of January falls on: ");
    cin.next();
    day = cin.nextLine();
    while (!day.toLowerCase().matches("(monday|tuesday|wednesday|thursday|friday|saturday|sunday)")) {
      System.out.print("Please enter a valid day: ");
      day = cin.nextLine();
    }
  }
}
