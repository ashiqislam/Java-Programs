import java.util.Scanner;

/**
 * Chapter 8
 * Programming Challenge 5: Password Verifier
 * This program demonstrates the PasswordVerifier class.
 */

public class PasswordDemo
{
   public static void main(String[] args)
   {
      String input;  // To hold input

      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
      
      // Get a password.      
      System.out.print("Enter a password: ");
      input = keyboard.nextLine();
      
      // Check the password.
      if (!PasswordVerifier.isValid(input))
         System.out.println("Invalid password.");
      else
         System.out.println("Valid password.");
   }
}