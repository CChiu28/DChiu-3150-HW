import java.util.Scanner;

public class Main3 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    String word = "";
    boolean palinCheck = true; //Set boolean to true by default
    System.out.print("Enter a word: ");
    word = cin.nextLine();
    word = word.toLowerCase(); //Change all characters to lowercase (ignore case difference)
    //int len = word.length();
    for (int i=0; i<(word.length()/2); i++) {
      if (word.charAt(i)!=word.charAt(word.length()-i-1)) { //Compares left and right half of word by individual characterse
        System.out.print(word+" is not a palindrome");
        palinCheck = false; //Set boolean to false if not palindrome
        break; //Break if characters don't match
      }
    }
    if (palinCheck) //If boolean is true, then it is palindrome
      System.out.print(word+" is a palindrome");
    cin.close();
    System.exit(0);
  }
}
