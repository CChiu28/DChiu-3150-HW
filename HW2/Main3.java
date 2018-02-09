import java.util.Scanner;

public class Main3 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    String word;
    char[] chArray;
    System.out.print("Enter a word: ");
    word = cin.nextLine();
    int len = word.length();
    for (int i=0; i<(len/2); i++) {
      if (word.charAt[i]!=word.charAt[len-1])
        System.out.print(word+" is not a palindrome");
      else System.out.print(word+" is a palindrome");
    }
  }
}
