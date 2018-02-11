import java.util.Scanner;

public class Main2 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int year = 0;
    boolean inputCheck; //Boolean for valid input
    String day = "";
    String[] calendar = //Start at calendar[1] for first month of the year
      {"","January","February","March","April","May","June","July","August","September","October","November","December"};
    int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31}; //Start at int[1] for days per month
    String[] week = {"","sunday","monday","tuesday","wednesday","thursday","friday","saturday"}; //Start at week[1] for first day of week
    int startWeek = 0; //Variable for when the first day of the month starts & to keep track of position in week
    System.out.print("Enter a year: ");
    do {
      if (cin.hasNextInt()) {
        year = cin.nextInt();
        inputCheck = true; //Set true if valid input
      } else {
          System.out.print("Please enter a valid year: ");
          inputCheck = false; //Set false if not valid input
          cin.next();
        }
    } while (!inputCheck); //Loop for valid input if false
    if (((year%4==0)&&(year%100!=0))||(year%400==0)) //Determine if leap year
      days[2] = 29;
    System.out.print("Enter the day the first day of January falls on: ");
    day = cin.next();
    while (!day.toLowerCase().matches("(sunday|monday|tuesday|wednesday|thursday|friday|saturday)")) { //Determine if valid input for week
      System.out.print("Please enter a valid day: ");
      day = cin.next();
    }
    for (int i=1; i<=week.length-1; i++) { //Set start of the week in month
      if (day.compareToIgnoreCase(week[i])==0) { //Ignoring case differences, compare input to day of the week array
        startWeek = i; //Set position of week
        break;
      }
    }
    for (int i=1; i<=calendar.length-1; i++) { //Loop per month
      System.out.printf("%4c%s %d\n", ' ', calendar[i], year);
      System.out.println("Su Mo Tu We Th Fr Sa");
      for (int j=1; j<startWeek; j++) //Insert empty spaces in first week of month according week position
        System.out.printf("%3s", " ");
      for (int k=1; k<=days[i]; k++) { //Output # of days according to month
        System.out.printf("%2d%s", k, " ");
        startWeek++;
        if (startWeek>7) { //If week position is over 7, start new week
          System.out.println("");
          startWeek = 1;
        }
        if (k==days[i]) { //If last day, enter new line for next month
          System.out.println("\n");
        }
      }
    }
    cin.close();
    System.exit(0);
  }
}
