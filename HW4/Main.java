import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int combo = 0; //Determiens which combination is being processed
    int totalCombos = 1; //Variable for total number of possible combos
    String row; //Takes user input on # of chars
    System.out.print("Enter how long you want your array to be: ");
    char[][] charArray = new char[cin.nextInt()][];
    int[] counter = new int[charArray.length]; //Counter to check which index each row is at
    // int[] size = new int[charArray.length]; //Keeps track of the size of each row
    for (int i=0; i<charArray.length; i++) { //Loop to determine row and characters for array
      System.out.print("Enter length of row: ");
      charArray[i] = new char[cin.nextInt()]; //Determine length of each row
      System.out.print("Enter characters for this row: ");
      row = cin.next();
      for (int j=0; j<charArray[i].length; j++) //Input chars from string into array
        charArray[i][j] = row.charAt(j);
    }
    System.out.println("Array: ");
    for (int i=0; i<charArray.length; i++) {  //Print user inputted array
      for (int j=0; j<charArray[i].length; j++) {
        System.out.printf("%c%c",charArray[i][j],' ');
      }
      System.out.println();
    }
    System.out.println("------");
    for (int i=0; i<charArray.length; i++) { //Finds total number of combos and keeps track of row length
      totalCombos *= charArray[i].length; //Multiply for total possible combos
      // size[i] = charArray[i].length; //Track length of each row
    }
    char[][] result = new char[totalCombos][charArray.length]; //Array to store combos
    while (combo<totalCombos) { //Ensures combos do not exceed max possible combos
      for (int i=0; i<charArray.length; i++) { //Add new element to current combo according to counter position
        result[combo][i] = charArray[i][counter[i]];
      }
      for (int j=charArray.length-1; j>=0; j--) { //Increment counters accordingly starting at last row
        if (counter[j]+1<charArray[j].length) { //Condition to check if counter increment will go over length of row
          counter[j]++;
          break; //Break out of loop if counter incremented
        }
        counter[j] = 0; //Keep counters at 0 until necessary to increment
      }
      combo++; //Increment to next combo
    }
    for (int i=0; i<result.length; i++) { //Print combos array
      // System.out.print(i+" ");
      for (int j=0; j<result[i].length; j++) {
        System.out.printf("%c%c",result[i][j],' ');
      }
      System.out.println();
    }
    cin.close();
    System.exit(0);
  }
}
