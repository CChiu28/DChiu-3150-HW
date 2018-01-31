import java.math.*;
import java.util.Scanner;

public class Main2 {
  public static void main(String[] args) {
	  Scanner cin = new Scanner(System.in);
	  System.out.print("Enter a radius: ");
	  while(cin.hasNextDouble()) {
		  double radius = cin.nextDouble();
		  System.out.println("Area: "+Math.PI*Math.pow(radius, 2));
		  System.out.print("Enter a radius: ");
	  }
	  cin.close();
  }
}