import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    char[][] test = { 
      {'a','b'},
      {'c','d'},
      {'e','f'}};
    // int[] counter = new int[test.length]; //Counter to check which index each row is at
    // int[] size = new int[test.length]; //Keeps track of the size of each row
    // int combo = 0; //Determiens which combination is being processed
    // int totalCombos = 1; //Variable for total number of possible combos
    System.out.print("Enter how long you want your array to be: ");
    char[][] charArray = new char[cin.nextInt()][];
    String row = "";
    for (int i=0; i<charArray.length; i++) {
      System.out.print("Enter length of row: ");
      charArray[i] = new char[cin.nextInt()];
      System.out.print("Enter characters for this row: ");
      row = cin.nextLine();
      cin.next();
      charArray[i] = row.toCharArray();
    }
    System.out.println("Array:");
    for (int i=0; i<charArray.length; i++) { //Print combos array
      for (int j=0; j<charArray[i].length; j++) {
        System.out.print(charArray[i][j]+" ");
      }
      System.out.println();
    }
    // for (int i=0; i<test.length; i++) { //Finds total number of combos and keeps track of row length
    //   totalCombos *= test[i].length; //Multiply for total possible combos
    //   size[i] = test[i].length; //Track length of each row
    // }
    // char[][] result = new char[totalCombos][test.length]; //Array to store combos
    // while (combo<totalCombos) { //Ensures combos do not exceed max possible combos
    //   for (int i=0; i<test.length; i++) { //Add new element to current combo according to counter
    //     result[combo][i] = test[i][counter[i]];
    //   }
    //   for (int j=test.length-1; j>=0; j--) { //Increment counters accordingly starting at last row
    //     if (counter[j]+1<size[j]) { //Condition to check if counter increment will go over length of row
    //       ++counter[j];
    //       break;
    //     }
    //     counter[j] = 0; //Keep counters at 0 until necessary to increment
    //   }
    //   combo++; //Increment to next combo
    // }
    // for (int i=0; i<result.length; i++) { //Print combos array
    //   for (int j=0; j<result[i].length; j++) {
    //     System.out.print(result[i][j]+" ");
    //   }
    //   System.out.println();
    // }
    cin.close();
    System.exit(0);
  }
}
