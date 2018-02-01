import java.util.Random;

public class Main3 {
	public static void main(String[] args) {
		Random rand = new Random();
		String months[] = {"0","January","February","March","April","May","June","July","August","September","October","November","December"};
		int month = rand.nextInt(12)+1;
		System.out.print(month+"-"+months[month]);
	}
}
