import java.math.*;
import java.util.Scanner;
// use string.split
public class Main5 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    String userInput;
    String splitStr[];
    int a1=0,a2=0;
    int b1=0,b2=0;
    int c1=0,c2=0;
    for (int i=1; i<=3; i++) {
    	System.out.print("Enter coordinates for point "+ i +" - ie. x,y: ");
        userInput = cin.nextLine();
        splitStr = userInput.split(",");
        if (i==1) {
        	a1 = Integer.parseInt(splitStr[0]);
        	a2 = Integer.parseInt(splitStr[1]);
        } else if (i==2) {
        	b1 = Integer.parseInt(splitStr[0]);
        	b2 = Integer.parseInt(splitStr[1]);
        } else if (i==3) {
        	c1 = Integer.parseInt(splitStr[0]);
        	c2 = Integer.parseInt(splitStr[1]);
        }
    }
    System.out.println("A: "+a1+","+a2);
    System.out.println("B: "+b1+","+b2);
    System.out.println("C: "+c1+","+c2);

//    System.out.println(userInput);
//    System.out.println(splitStr[0]);
//    System.out.println(splitStr[1]);
//    System.out.println(a1);
//    System.out.println(a2);
    cin.close();
  }
}
