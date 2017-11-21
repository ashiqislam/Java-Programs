
public class ReverseInt {
	
	public static void main(String[] args) {
	int inputNum = 1002;
	int endInt;
	
	if((inputNum <= 999999999)&&(inputNum > 0 ))
	{
	   System.out.print("Your number reversed is: ");

	   do
	   {
	      endInt = inputNum % 10; //to get the last digit of the number
	      inputNum /= 10;
	      System.out.print(endInt);
	   }
	   while(inputNum != 0);
	 System.out.println("");

	}
	 else
	   System.out.println("You used an incorrect number of integers.\n");

	System.out.println("Program end");
	}

}
