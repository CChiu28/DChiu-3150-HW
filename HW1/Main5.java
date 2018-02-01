import java.math.*;
import java.util.Scanner;

//https://www.ocpsoft.org/opensource/guide-to-regular-expressions-in-java-part-1/
//	https://www.tutorialspoint.com/java/java_string_matches.htm
public class Main5 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    String userInput;
    String splitStr[];
    double a1=0,a2=0;
    double b1=0,b2=0;
    double c1=0,c2=0;
    double side1=0, side2=0, side3=0;
    for (int i=1; i<=3; i++) {
    	System.out.print("Enter coordinates for point "+ i +" - (ie. x,y): ");
        userInput = cin.nextLine();
        while (!userInput.matches("(-?)(\\d+)(,{1})(-?)(\\d+)")) {
        	System.out.println("Please enter a valid set of coordinates (ie. x,y):");
        	userInput = cin.nextLine();
        }
        splitStr = userInput.split(",");
       	if (i==1) {
       		a1 = Double.parseDouble(splitStr[0]);
       		a2 = Double.parseDouble(splitStr[1]);
       	} else if (i==2) {
       		b1 = Double.parseDouble(splitStr[0]);
       		b2 = Double.parseDouble(splitStr[1]);
       	} else if (i==3) {
       		c1 = Double.parseDouble(splitStr[0]);
       		c2 = Double.parseDouble(splitStr[1]);
       	}
    }
    System.out.println("A: "+a1+","+a2);
    System.out.println("B: "+b1+","+b2);
    System.out.println("C: "+c1+","+c2);
    side1 = Math.sqrt(Math.pow((b1-a1),2)+Math.pow((b2-a2),2));
    side2 = Math.sqrt(Math.pow((c1-b1),2)+Math.pow((c2-b2),2));
    side3 = Math.sqrt(Math.pow((c1-a1),2)+Math.pow((c2-a2),2));
    System.out.println("Side1: "+side1);
    System.out.println("Side2: "+side2);
    System.out.println("Side3: "+side3);
    if (((side1+side2)>side3)&&((side2+side3)>side1)&&((side1+side3)>side2))
    	System.out.println("This is a real triangle");
    else System.out.println("This is a fake triangle");
    cin.close();
    System.exit(0);
  }
}
