import java.util.Random;

// enum Month {
// 	January, February, March, April, June, July, August, September, November, December;
// }
public class Main3 {
	public static void main(String[] args) {
		Random rand = new Random();
		int month = rand.nextInt(12);
		System.out.println(month);
	}
}
