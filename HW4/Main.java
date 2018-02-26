import java.util.Arrays;
public class Main {
  public static void main(String[] args) {
    char[][] test = { 
      {'a','b','h','i'},
      {'c','d'},
      {'e','f','g'}};
    int[] counter = new int[test.length];
    int combo=0;
    int totalCombos = 1;
    int tick = 1;
    for (int i=0; i<test.length; i++)
      totalCombos *= test[i].length;
    char[][] result = new char[totalCombos][test.length];
    while (combo<totalCombos) {
      for (int i=0; i<test.length; i++) {
        result[combo][i] = test[i][counter[i]];
      }
      for (int j=test[0].length-1; j>=0; j--) {
        counter[j] += 1;
      }
      combo++;
    }
    for (int i=0; i<result.length; i++) {
      for (int j=0; j<result[i].length; j++) {
        System.out.print(result[i][j]+" ");
      }
      System.out.println();
    }
  }
}
