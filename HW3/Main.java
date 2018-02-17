public class Main {
  public static void main(String[] args) {
    char[] array = {'T','E','S','T','l','o','w','e','r'};
    MyString test = new MyString(array);
    char[] array2 = {'h','e','l','l','o'};
    MyString test2 = new MyString(array2);
    MyString test3 = new MyString(array);
    MyString test4 = test3.valueOf('4');
    String test5 = test2.toString();
    System.out.println(test.toString());
    System.out.println("test length "+test.length());
    System.out.println(test5);
    System.out.println("test2 length "+test2.length());
    MyString lowercase = test.toLowerCase();
    System.out.println(lowercase.toString());
    MyString uppercase = test2.toUpperCase();
    System.out.println(uppercase.toString());
    System.out.println(test.toString());
    System.out.println(test4);
    System.out.println(test3.valueOf(2));
    if (test.compareTo(test3)==0)
      System.out.println("yes");
  }
}
