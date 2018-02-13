public class MyString {
  char[] charArray;
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
    MyString newSub = new MyString();
    for (int i=charArray[begin]; i<charArray[end]; i++) {
      newSub(charArray[i]);
    }
  }
  public MyString toLowerCase() {
  }
  public MyString toUpperCase() {}
  public boolean equals(MyString s) {}
  public MyString getMyString() {}
  public String toString() {}
  public static MyString valueOf(int i) {}
}
