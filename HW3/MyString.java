public class MyString {
  char[] charArray;
  int index=0;
  public MyString(char[] chars) {
    this.charArray = chars;
  }
  public char charAt(int index) {
    return charArray[index];
  }
  public int length() {
    return this.charArray.length;
  }
  public MyString substring(int begin, int end) {
    char[] temp = new char[end-begin];
    for (int i=begin; i<end; i++) {
      temp[i-begin] = this.charArray[begin];
    }
    return MyString(temp);
  }
  public MyString toLowerCase() {
  }
  public MyString toUpperCase() {}
  public boolean equals(MyString s) {}
  public MyString getMyString() {}
  public String toString() {}
  public static MyString valueOf(int i) {}
}
