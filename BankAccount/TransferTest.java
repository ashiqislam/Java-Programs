/**
 * @Ashiq Hoque
 * 
 * Professor Wei
 * Data Structures
 */

import java.util.Scanner;
import java.text.DecimalFormat;
public class TransferTest
{

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
       
        //int variable for program loop
        int input;
        
        //double variable of transfer amount
        double amount;
   
        //Create 2 Account Objects
        BankAccount acct1 = new BankAccount("ACCOUNT 1", 1000);
        BankAccount acct2 = new BankAccount("ACCOUNT 2", 2000);
        
        
        do{
            DecimalFormat df = new DecimalFormat("$0.00");// Currency Formatter
            System.out.println("Enter 1 to transfer from ACCOUNT 1 to ACCOUNT 2");
            System.out.println("Enter 2 to transfer from ACCOUNT 2 to ACCOUNT 1");
            System.out.println("Enter 3 to Quit and View Account Balances");
            input = keyboard.nextInt();
            
            while (input != 1 && input != 2 && input != 3) //INPUT VALIDATION
            {
                System.out.println("Please enter a valid option of 1,2 or 3: ");
                input = keyboard.nextInt();
            }
            
            if(input == 1){ //OPTION 1: TRANSFER FROM ACCOUNT 1 TO ACCOUNT 2
                System.out.println("\nPlease Enter Transfer Amount: ");
                amount = keyboard.nextDouble();
                
                System.out.println("\nYou Transferred " + df.format(amount) + " to " +
                acct2.getName() + " From " + acct1.getName());
                
                //acct1.transfer(acct2,amount); //instance version
                //CALLING OVERLOAD TRANSFER METHOD
                BankAccount.transfer(acct1,acct2,amount);
                
                System.out.println("\nYour New Balances Are: ");
                System.out.println(acct1.getName() + ": " + 
                df.format(acct1.getBalance()));
                System.out.println(acct2.getName() + ": " + 
                df.format(acct2.getBalance()) + "\n");
                
            }
            
            if(input == 2){ //OPTION 2: TRANSFER FROM ACCOUNT 2 TO ACCOUNT 1
                System.out.println("\nPlease Enter Transfer Amount: ");
                amount = keyboard.nextDouble();
                
                System.out.println("\nYou Transferred " + df.format(amount) + " to " +
                acct1.getName() + " From " + acct2.getName());
                
                
                //acct2.transfer(acct1,amount); // instance version
                //CALLING OVERLOAD TRANSFER METHOD
                BankAccount.transfer(acct2,acct1,amount);
                
                
                System.out.println("\nYour New Balances Are: ");
                System.out.println(acct1.getName() + ": " + 
                df.format(acct1.getBalance()));
                System.out.println(acct2.getName() + ": " + 
                df.format(acct2.getBalance()) + "\n");
                
            }
            
             if(input == 3){ //OPTION 3: Prints Balances and Quits Program
                System.out.println("\nThank you for using this System!");
                System.out.println("\nYOUR CURRENT BALANCES ARE: ");
                System.out.println(acct1.getName() + ": " + 
                df.format(acct1.getBalance()));
                System.out.println(acct2.getName() + ": " + 
                df.format(acct2.getBalance()) + "\n");
                
                System.exit(0); // QUITS PROGRAM
                
            }
            
        }while (input == 1 || input == 2);
        
    }
}