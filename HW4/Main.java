public class Main {
  public static void main(String[] args) {
    char[][] test = { 
      {'T','t'},
      {'E','e'},
      {'S','s'},
      {'T','t'}};
    for (int i=0; i<test.length; i++) {
      for (int j=0; j<test[0].length; j++) {
        System.out.print(test[i][0]+" "+test[i][j]+"\n");
      }
    }
    System.out.println("length of row: "+test.length);
    System.out.println("length of col: "+test[0].length);
  }
}
