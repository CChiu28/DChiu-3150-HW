public class Main {
  public static void main(String[] args) {
    char[] array = {'T','E','S','T','l','o','w','e','r'};
    MyString test = new MyString(array);
    char[] array2 = {'h','e','l','l','o'};
    MyString test2 = new MyString(array2);
    System.out.print(test.toString());
    System.out.println("\ntest length "+test.length());
    System.out.print(test2.toString());
    System.out.println("\ntest2 length "+test2.length());
    MyString lowercase = test.toLowerCase();
    System.out.print(lowercase.toString());
    MyString uppercase = test2.toUpperCase();
    System.out.print(uppercase.toString());
    System.out.print("\n"+test.toString());
  }
}
