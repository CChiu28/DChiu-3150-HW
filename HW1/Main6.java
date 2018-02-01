import java.util.Scanner;

public class Main6 {
	public static void main(String[] args) {
		Scanner cin = new Scanner();
		String userInput;
		String splitStr[];
		double centerX1=0, centerY1=0;
		double centerX2=0, centerX2=0;
		double radius1=0, radius2=0;
		System.out.print("Please enter the center coordinates for the first circle: ");
		userInput = cin.hasNextLine();
		for (int i=1; i<=2; i++) {
			while (!userInput.matches("(-?)(\\d+)(,{1})(-?)(\\d+)")) {
				System.out.println("Please enter a valid set of coordinates (ie. x,y):");
				userInput = cin.nextLine();
			}
			splitStr = userInput.split(",");
			if (i==1) {
				centerX1 = Double.parseDouble(splitStr[0]);
				centerY1 = Double.parseDouble(splitStr[1]);
			}
			
		}
	}
}
