// I gathered information on how to check for specific input from keyboard and how split strings
// from the following sites:
// https://www.ocpsoft.org/opensource/guide-to-regular-expressions-in-java-part-1/
// https://www.tutorialspoint.com/java/java_string_matches.htm
import java.util.Scanner;
import java.math.*;

public class Main6 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String userInput;
		String splitStr[];
		double centerX1=0, centerY1=0;
		double centerX2=0, centerY2=0;
		double radius1=0, radius2=0;
		double distance=0;
		for (int i=1; i<=2; i++) {
			System.out.print("Please enter the center coordinates for circle "+i+" (ie. x,y): ");
			userInput = cin.nextLine();
			while (!userInput.matches("(-?)(\\d+)(,{1})(-?)(\\d+)")) {
				System.out.println("Please enter a valid set of coordinates (ie. x,y):");
				userInput = cin.nextLine();
			}
			splitStr = userInput.split(",");
			if (i==1) {
				centerX1 = Double.parseDouble(splitStr[0]);
				centerY1 = Double.parseDouble(splitStr[1]);
			} else if (i==2) {
				centerX2 = Double.parseDouble(splitStr[0]);
				centerY2 = Double.parseDouble(splitStr[1]);
			}
			System.out.print("Enter a radius: ");
			if (i==1)
				radius1 = cin.nextDouble();
			else if (i==2)
				radius2 = cin.nextDouble();
			cin.nextLine();
		}
		distance = Math.sqrt(Math.pow((centerX2-centerX1),2)+Math.pow((centerY2-centerY1),2));
		System.out.println("Distance between two centers: "+distance);
		if (radius1==(distance/2)&&radius2==(distance/2))
			System.out.println("The circles are touching");
		else if (distance>(radius1+radius2))
			System.out.println("The circles are separated");
		else if (radius1>=(distance+radius2)||radius2>=(distance+radius1))
			System.out.println("One circle is within the other");
		else if (distance<(radius1+radius2))
			System.out.println("The circles overlap");
		cin.close();
		System.exit(0);
	}
}
