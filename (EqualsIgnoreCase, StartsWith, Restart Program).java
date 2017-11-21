import java.util.Scanner;
import java.util.*;

public class Loops{
    
    public static void main(String[] args) {
      String restart;
        do {
            Scanner inputz = new Scanner(System.in);
            char c;
            System.out.println("Please enter a letter: ");
            c = inputz.next().toUpperCase().charAt(0);
            System.out.println("You entered " + c);
            
            System.out.println("Do you want to restart the program? Enter the letter Y to restart:");
            System.out.println("Enter the Letter E to Exit"); 
            restart = inputz.next();
            
            if (restart.toUpperCase().startsWith("E"))
            {
                System.exit(0);
            }
            
            while (!restart.toUpperCase().startsWith("Y"))
            {
                System.out.println("Invalid entry, Please try again: ");
                restart = inputz.next();
            }

        }while (restart.toUpperCase().startsWith("Y"));
    }
}
