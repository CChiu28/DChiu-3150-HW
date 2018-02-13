public class MyString {
  char[] charArray= new char[];
  public MyString(char[] chars) {
    for (int i=0; i<chars.length; i++) {
      charArray[i] = chars[i];
    }
  }
  public char charAt(int index) {
    return charArray[index];
  }
  public int length() {
    return charArray.length;
  }
  public MyString substring(int begin, int end) {

  }
  public MyString toLowerCase() {}
  public MyString toUpperCase() {}
  public boolean equals(MyString s) {}
  public MyString getMyString() {}
  public String toString() {}
  public static MyString valueOf(int i) {}
}
