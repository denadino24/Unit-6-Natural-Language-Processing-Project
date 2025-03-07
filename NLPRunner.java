import java.util.ArrayList;
import java.util.Scanner;

public class NLPRunner {
  public static void main(String[] args) {


    ArrayList<String> boring = FileReader.toStringList("boring.txt");
    ArrayList<String> advanced = FileReader.toStringList("advanced.txt");
    
    

    VocabEnhancer enhancer = new VocabEnhancer();

    enhancer.prompt();
    

    
    

    
  }
}