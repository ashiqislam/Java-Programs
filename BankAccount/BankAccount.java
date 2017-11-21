/**
 * @Ashiq Hoque
 * 
 * Professor Wei
 * Data Structures
 */

public class BankAccount {
    
    private String name; // the account name
    private double balance;  // the balance
    
    public BankAccount()
    {}
    
    public BankAccount(String name, double balance)
    {
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount)  
    {
        balance = balance + amount;
                    
    }

    public void withdraw(double amount) 
    {
        balance = balance - amount;
         
    }

    public String getName()  
    {
        return name;      
    }

    public double getBalance()  
    {
        return balance;         
    }

    //TRANSFER METHOD BY CALLING DEPOSIT AND WITHDRAW METHODS
    public void transfer(BankAccount acct, double amount)
    {
        acct.deposit(amount);   
        this.withdraw(amount);           
    }
    
    //TRANSFER METHOD OVERLOAD
    public static void transfer(BankAccount acct1, BankAccount acct2, double amount)
	{
		acct1.transfer(acct2, amount);
	}
}