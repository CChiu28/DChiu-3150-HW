import java.util.*;

final class MyString {
  private char[] charArray; //Charact array as private variable

  public MyString(char[] chars) { //Constructor
    this.charArray = chars; //Copy chars argument into this instance
  }

  public char charAt(int index) {
    char[] temp = charArray; 
    if ((index>=temp.length)||(index<0)) //Check if index is out of array bounds
      return 0;
    else return temp[index]; //Returns char at index if within bounds
  }

  public int length() {
    return this.charArray.length; //Return length of this instance's array
  }

  public MyString substring(int begin, int end) {
    if (end<begin)
      return this;
    char[] temp = new char[end-begin]; //Create temp array with length of end-begin args
    for (int i=begin; i<end; i++)
      temp[i-begin] = this.charArray[i]; //Copy elements starting from 'begin' to 'end'
    return new MyString(temp); //Returns the copied elements as new MyString
  }

  public MyString toLowerCase() {
    char[] temp = new char[this.charArray.length]; //New temp array of same length
    for (int i=0; i<this.charArray.length; i++)
      temp[i] = Character.toLowerCase(this.charArray[i]); //Change each element to lowercase
    return new MyString(temp); //Return temp array as new MyString
  }

  public MyString toUpperCase() {
    char[] temp = new char[this.charArray.length];
    for (int i=0; i<this.charArray.length; i++)
      temp[i] = Character.toUpperCase(this.charArray[i]); //Change each element to uppercasse
    return new MyString(temp); //Return tempa rrayas new MyString
  }

  public int compareTo(MyString s) {
    char[] temp = this.charArray;
    int length = Math.min(s.length(), temp.length); //Takes the lesser of two lengths
    if (s.length()!=temp.length)
      return (s.length()-temp.length); //If lengths are different, return difference between them
    for (int i=0; i<length; i++) { //Loop through the shorter length to avoid out-of-bounds
      if (s.charAt(i)!=temp[i])
        return (s.charAt(i)-temp[i]); //If characters are different, return difference between them
    }
    return 0; //Return 0 if everything ends up being the same
  }

  public MyString getMyString() {
    char[] temp = this.charArray; //Copies current instance and returns it as new MyString
    return new MyString(temp);
  }

  public String toString() {
    String temp = new String(this.charArray); //Copies contents of this instance's array into a new String
    return temp;
  }

// Consulted https://www.geeksforgeeks.org/collections-reverse-java-examples/ on how to
// reverse a list and the Character class api to convert ints to chars as well as
// https://www.javatpoint.com/java-int-to-char
  public static MyString valueOf(int i) {
    List<Character> toChars = new ArrayList<Character>();
    int dig = 0;
    while (i>0) {
      dig = i%10; //Takes remainder of the arg
      i = i/10; //Removes right most digit
      toChars.add(Character.forDigit(dig, 10)); //Adds remainder to list
    }
    Collections.reverse(toChars); //Reverse the list after all digits taken
    char[] temp = new char[toChars.size()]; //Declare char array of same size
    for (int j=0; j<toChars.size(); j++)
      temp[j] = toChars.get(j); //Copy elements from list to char array
    return new MyString(temp); //Return char array in new MyString
  }
}