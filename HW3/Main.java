public class Main {
  public static void main(String[] args) {
    char[] array = {'t','e','s','t'};
    MyString test = new MyString(array);
    for (int i=0; i<test.length(); i++)
      System.out.print(test.charAt(i));
  }
}
