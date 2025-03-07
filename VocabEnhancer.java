import java.util.ArrayList;
import java.util.Scanner;

public class VocabEnhancer {

  /**
   * Traverses ArrayList of feelings and returns a new ArrayList that replaces
   * specific feeling words with enhanced synonyms
   *
   * ArrayList argument will have one or more words
   * Returned String will have one or more words
   *
   * @param    feelings - ArrayList of words to traverse and enhanve vocabulary
   * @return   String of the words from the new feelings ArrayList
   */
  public String enhanceVocabulary(ArrayList<String> feelings) {

    ArrayList<String> boring = FileReader.toStringList("boring.txt");
    ArrayList<String> advanced = FileReader.toStringList("advanced.txt");

    String current = "";

    for (int i=0; i<feelings.size(); i++) {
      current = feelings.get(i);

      if (isPrimitiveFeeling(current, boring)) {
        String advancedWord = returnAdvanced(current, boring, advanced);
        feelings.remove(i);
        feelings.add(i, advancedWord);
      }
      
    }
    
    String feeling = "";
    for (int i=0; i<feelings.size(); i++) {
      String word = feelings.get(i);
      feeling += word + " ";
    }
    return feeling;
  }


  /**
   * Traverses ArrayList of "boring" words and returns true if the 
   * word in the argument is equal to one of the boring words
   *
   * String and ArrayList must have at least one letter/word
   * Returned value will be true or false
   *
   * @param    word - singular word from the ArrayList of feelings
   *           boring - ArrayList of "boring" feelings
   * @return   ArrayList of input ArrayList with enhanced vocabulary
   */
  public boolean isPrimitiveFeeling(String word, ArrayList<String> boring) {
    for (int i=0; i<boring.size(); i++) {
      if (word.equals(boring.get(i))) {
        return true;
      }
    }
    return false;
  }

  /**
   * Finds the index value of the specific "boring" word and returns the advanced
   * synonym by using the same index
   *
   * String and ArrayList argument will have one or more letters/words
   * Returned String will have at least one letter
   *
   * @param    word - specified String from ArrayList of feelings
   *           boring - ArrayList of "boring" words
   *           advanced - ArrayList of advanced synonyms of "boring" words
   * @return   String of advanced word from the index of word from boring
   */
  public String returnAdvanced(String word, ArrayList<String> boring, ArrayList<String> advanced) {
    String advancedWord = "";
    for (int i=0; i<boring.size(); i++) {
      if (word.equals(boring.get(i))) {
        advancedWord = advanced.get(i);
      }
    }
    return advancedWord;
  }

 /**
   * Separates the words in a statement by adding the the substring of the start
   * of a word to the space to an ArrayList
   *
   * String will have one or more letters/words
   * Returned ArrayList will have at least one word
   *
   * @param    statement - 
   * @return   String of advanced word from the index of word from boring
   */
  public ArrayList<String> separateWords(String statement) {
 
    ArrayList<String> result = new ArrayList<String>();
    int space = statement.indexOf(" ");
    
    while (space != -1) {
      String currentWord = statement.substring(0, space);
      result.add(currentWord);

      statement = statement.substring(space+1);
      space = statement.indexOf(" ");
    }
    return result;
  }

 /**
   * Runs methods depending on user input
   *
   */
  public void prompt() {

   Scanner input = new Scanner(System.in);

    System.out.println("How are you feeling?");
    String statement = input.nextLine() + " ";

    ArrayList<String> feelings = separateWords(statement);
    System.out.println("Would this better explain what you're feeling? y/n");
    System.out.println("\n" + enhanceVocabulary(feelings));

    String yesOrNo = input.nextLine();

    if (yesOrNo.equals("y") || yesOrNo.equals("yes")) {
      System.out.println("Thank you for sharing");
    } else {
      System.out.println("Please use words to describe your feelings. Type 'Enter'");
      input.nextLine();
      prompt();
    }
  }
  
}