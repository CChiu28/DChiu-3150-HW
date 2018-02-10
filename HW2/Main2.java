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
    //int[][][] monthGrid = new int[13][5][8];
    String[] week = {"","sunday","monday","tuesday","wednesday","thursday","friday","saturday"};
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
    if (((year%4==0)&&(year%100!=0))||(year%400==0))
      days[2] = 29;
    System.out.print("Enter the day the first day of January falls on: ");
    day = cin.next();
    while (!day.toLowerCase().matches("(sunday|monday|tuesday|wednesday|thursday|friday|saturday)")) {
      System.out.print("Please enter a valid day: ");
      day = cin.next();
    }
    for (int i=1; i<=week.length-1; i++) {
      //System.out.println("test "+week[i]+" "+day+" end test");
      if (day.compareToIgnoreCase(week[i])==0) {
        System.out.println(week[i]+" "+i);
        startWeek = i;
        break;
      }
    }
    // System.out.print(monthGrid.length);
    // for (int months=1; months<monthGrid.length; months++) {
    //   for (int weeks=0; weeks<monthGrid[0].length; weeks++) {
    //     for (int k=1; k<=days[months]; k++) {
    //       if (weeks==0)
    //         monthGrid[months][weeks][k]
    //     }
    //   }
    // }
    for (int i=1; i<=calendar.length-1; i++) {
      System.out.printf("%4c%s %d\n", ' ', calendar[i], year);
      System.out.println("Su Mo Tu We Th Fr Sa");
      for (int j=1; j<startWeek; j++)
        System.out.printf("%s", "   ");
      for (int k=1; k<=days[i]; k++) {
        System.out.printf("%2d%s", k, " ");
        if ((k+startWeek-1)%7==0)
          System.out.println("");
        if (k==days[i]) {
          System.out.println("");
          startWeek = (k+startWeek)%7;
          System.out.println("newstart "+startWeek);
        }
      }
    }
  }
}
