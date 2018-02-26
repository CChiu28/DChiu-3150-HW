public class Main {
  public static void main(String[] args) {
    char[][] test = { 
      {'a','b'},
      {'c','d'},
      {'e','f','g'}};
    int[] counter = new int[test.length];
    int combo = 0;
    int totalCombos = 1;
    int tick = 0;
    for (int i=0; i<test.length; i++)
      totalCombos *= test[i].length;
    while (combo<totalCombos) {
      for (int i=0; i<test.length; i++) {
        System.out.print(test[i][counter[i]]+" ");
        if (i==test.length-1) {
          if (counter[i]==test[i].length-1&&i>=1) {
            counter[i] = 0;
            counter[i-1] += 1;
          } else counter[i] += 1;
        }
      }
      System.out.println();
      combo++;
    }
    // // int check1 = 0;
    // // int check2 = 0;
    // int check3 = 0;
    // // int numCombo = 1;
    // // for (int i=0; i<test.length; i++)
    // //   numCombo *= test[i].length;
    // for (int i=0; i<test[i].length; i++) {
    //   for (int j=0; j<test.length; j++)
    //   System.out.println();
    // }
    // System.out.println("length of row: "+test.length);
    // System.out.println("length of col: "+test[0].length);
  }
}
