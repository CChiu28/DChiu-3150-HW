public class Main {
  public static void main(String[] args) {
    char[] Hello = {'H','e','l','l','o'};
    char[] hello = {'h','e','l','l','o'};
    char[] alphaCase = {'U','P','P','E','R','l','o','w','e','r'};
    MyString HelloString = new MyString(Hello);
    MyString helloString = new MyString(hello);
    MyString caseString = new MyString(alphaCase);
    System.out.println("HelloString consists of: "+HelloString.getMyString());
    System.out.println("Character at 4th index is: "+HelloString.charAt(4));
    System.out.println("Length of HelloString is: "+HelloString.length());
    System.out.println("Substring of HelloString at 0th and 3rd indices is: "+HelloString.substring(0,4));
    System.out.println("This is all lowercase: "+caseString.toLowerCase());
    System.out.println("This is all uppercase: "+caseString.toUpperCase());
    System.out.println("Comparing "+HelloString+" and "+helloString+" results in "+HelloString.compareTo(helloString));
    String test = HelloString.toString();
    System.out.println("This is a string: "+test);
    char[] empty = new char[1];
    MyString emptyString = new MyString(empty);
    System.out.println("The value of int 234 in MyString is "+emptyString.valueOf(234));
  }
}
