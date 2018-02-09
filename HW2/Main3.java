import java.util.Scanner;

public class Main3 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    String word;
    boolean palinCheck = true;
    System.out.print("Enter a word: ");
    word = cin.nextLine();
    word = word.toLowerCase();
    int len = word.length();
    for (int i=0; i<(len/2); i++) {
      if (word.charAt(i)!=word.charAt(len-i-1)) {
        System.out.print(word+" is not a palindrome");
        palinCheck = false;
        break;
      }
    }
    if (palinCheck)
      System.out.print(word+" is a palindrome");
  }
}
