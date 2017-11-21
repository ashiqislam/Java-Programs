import java.util.Scanner;
import java.util.regex.*;

public class LetterCountExample {

    /**
     * @param args
     */
    public static void main(String[] args) {

        //Initialize Class
        LetterCounter test = new LetterCounter();
        //Sets letter to be compared
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a letter to be counted: ");
        String s0 = keyboard.nextLine();
        test.Letter = s0.charAt(0);
        while(!s0.matches(".*[a-zA-Z]+.*") || s0.length() > 1){
            System.out.println("Invalid Entry! Please enter a single letter to be counted: ");
            s0 = keyboard.nextLine();
            test.Letter = s0.charAt(0);
        }
        
        System.out.println("Please enter a string/word: ");
        String s1 = keyboard.nextLine();
        //Prints the comparison 
        //'%c' == test.Letter;
        //%s == test.DoCount;
        System.out.printf("The number of times the letter '%c' is repeated in the string is: %s", test.Letter, test.doCount(s1));

    }

}
