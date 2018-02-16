final class MyString {
  private char[] charArray;

  public MyString(char[] chars) {
    this.charArray = chars;
  }

  public char charAt(int index) {
    char[] temp = charArray;
    return temp[index];
  }

  public int length() {
    return this.charArray.length;
  }

  public MyString substring(int begin, int end) {
    char[] temp = new char[end-begin];
    for (int i=begin; i<end; i++) {
      temp[i-begin] = this.charArray[begin];
    }
    return new MyString(temp);
  }

  public MyString toLowerCase() {
    char[] temp = new char[this.charArray.length];
    for (int i=0; i<this.charArray.length; i++)
      temp[i] = Character.toLowerCase(this.charArray[i]);
    return new MyString(temp);
  }

  public MyString toUpperCase() {
    char[] temp = new char[this.charArray.length];
    for (int i=0; i<this.charArray.length; i++)
      temp[i] = Character.toUpperCase(this.charArray[i]);
    return new MyString(temp);
  }

  public boolean equals(MyString s) {
    if (s.length()==this.charArray.length) {
      for (int i=0; i<s.length(); i++) {
        if (s.charAt(i)!=this.charArray[i])
          return false;
      }
      return true;
    } else return false;
  }

  public MyString getMyString() {
    char[] temp = this.charArray;
    return new MyString(temp);
  }

  public String toString() {
    String temp = new String(this.charArray);
    return temp;
  }

  public static MyString valueOf(int i) {
    
    return new MyString(i);
  }
}
