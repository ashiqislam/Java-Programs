import java.util.Scanner;
import java.io.*;

public class ValidatorTest 
{
    public static void main(String args[]) throws IOException
    {
        Scanner in = new Scanner(System.in);
        Validator val = new Validator();
        boolean loop = true;

        while(loop = true)
        {
            System.out.print("1. Access account\n");
            System.out.print("2. Exit\n");
            System.out.print("\nPlease enter a numerical option: ");
            int option = in.nextInt();
            while (option != 2 && option != 1)
            {
                System.out.print("\nInvalid entry. Please enter a numerical option of 1 or 2: ");
                option = in.nextInt();
            }

            if (option == 2)
            {
                System.out.print("Thank you for using this program.");
                System.exit(0);
            }

            if (option == 1)
            {

                System.out.print("Please enter an account number: ");

                int number = in.nextInt();
                if (val.isValid(number)) {
                    System.out.println("Successful entry, that number is valid.\n");
                } else {
                    System.out.println("We're sorry, that number is invalid.\n");
                }
            }

        }
    }
}
