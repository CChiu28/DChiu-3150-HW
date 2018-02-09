import java.util.Scanner;

public class Main1 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int height = 0;
    boolean intCheck;
    System.out.print("Enter an integer: ");
    do {
      if (cin.hasNextInt()) {
        height = cin.nextInt();
        intCheck = true;
      } else {
          System.out.print("Please enter a valid integer: ");
          intCheck = false;
          cin.next();
        }
    } while (!intCheck);
    for (int row=1; row<=height; row++) {
      for (int j=1; j<=row; j++) {
        System.out.print(j+" ");
      }
      for (int k=height; k>0; k--) {
        if (row>1)
          System.out.print(k+" ");
      }
      System.out.println();
    }
    //System.out.print(height);
    cin.close();
    System.exit(0);
  }
}
