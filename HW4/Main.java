public class Main {
  public static void main(String[] args) {
    char[][] test = { 
      {'a','b'},
      {'c','d'},
      {'e','f'}};
    // int check1 = 0;
    // int check2 = 0;
    int check3 = 0;
    for (int i=0; i<test.length; i++) {
      for (int j=1; j<test[0].length; j++) {
        for (int l=0; l<test[0].length; l++) {
          System.out.print(test[i][0]+" "+test[j][0]);
          if (check3==0) {
            System.out.print(" "+test[j][check3]);
            check3++;
          } else if (check3==1) {
            System.out.print(" "+test[j][check3]);
            check3 = 0;
          }
        }
      }
      System.out.println();
    }
    System.out.println("length of row: "+test.length);
    System.out.println("length of col: "+test[0].length);
  }
}
