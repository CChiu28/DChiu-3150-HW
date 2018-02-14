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
    for (int i=0; i<this.charArray.length; i++)
      this.charArray[i] = this.charArray[i].toLowerCase();
  }
  public MyString toUpperCase() {
    for (int i=0; i<this.charArray.length; i++)
      this.charArray[i] = this.charArray[i].toUpperCase();
  }
  public boolean equals(MyString s) {}
  public MyString getMyString() {}
  public String toString() {}
  public static MyString valueOf(int i) {}
}
