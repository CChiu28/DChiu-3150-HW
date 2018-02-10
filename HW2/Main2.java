import java.util.Scanner;
import java.util.Calendar;

public class Main2 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int year = 0;
    boolean inputCheck;
    String day = "";
    String[] calendar = {"","January","February","March","April","May","June","July","August","September","October","November","December"};
    int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    String[] week = new String[] {"","sunday","monday","tuesday","wednesday","thursday","friday","saturday"};
    int startWeek = 0;
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
    if ((year%4==0)&&(year%100!=0)) {
      days[3] = 29;
    } else if (year%400==0)
      days[3] = 29;
    System.out.print("Enter the day the first day of January falls on: ");
    day = cin.next();
    while (!day.toLowerCase().matches("(monday|tuesday|wednesday|thursday|friday|saturday|sunday)")) {
      System.out.print("Please enter a valid day: ");
      day = cin.next();
    }
    for (int i=1; i<=week.length-1; i++) {
      //System.out.println("test "+week[i]+" "+day+" end test");
      if (day.toLowerCase().compareTo(week[i])==0) {
        System.out.println(week[i]);
        startWeek = i;
        break;
      }
    }
    for (int i=1; i<=calendar.length-1; i++) {
      System.out.printf("%4c%s %d\n", ' ', calendar[i], year);
      System.out.println("Su Mo Tu We Th Fr Sa");
      for (int j=startWeek; j<7; j++)
        System.out.printf(" %s", "  ");
      for (int k=1; k<=days[i]; k++)
        System.out.printf("%2d%s", k, " ");
        if ()
    }
  }
}
