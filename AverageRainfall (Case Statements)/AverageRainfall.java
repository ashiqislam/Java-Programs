import java.util.Scanner;
import java.text.*;

public class AverageRainfall {
    public static void main(String[] args) {
        int years;												// Variable to hold the amount of years
        final int MONTHS = 12; 									// Constant to hold the amount of months in a year
        int totalMonths = 0;									// Months accumulator variable
        double monthlyRain;										// Holds the amount of rain in inches for each month
        double totalRainfall = 0;								// Holds the total rainfall
        NumberFormat df = DecimalFormat.getInstance();		    // Decimal formating
        df.setMaximumFractionDigits(2);			

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt user for the number of years
        System.out.println("Enter the number of years: ");
        years = input.nextInt();
        
        while (years <1)
        {
            System.out.print("Invalid entry, Enter 1 or greater: ");
            years=input.nextInt();
        }
        

        System.out.println("Enter the rainfall amount for each month ");
        // Construct for-loop for each year
        for(int i=1; i <= years; i++){
            for(int j=1; j<MONTHS+1; j++){
                switch(j){
                    case 1:
                    System.out.print("\nYear " + i + " January: ");
                    break;
                    case 2:
                    System.out.print("Year " + i + " February: ");
                    break;
                    case 3:
                    System.out.print("Year " + i + " March: ");
                    break;
                    case 4: 
                    System.out.print("Year " + i + " April: ");
                    break;
                    case 5:
                    System.out.print("Year " + i + " May: ");
                    break;
                    case 6:
                    System.out.print("Year " + i + " June: ");
                    break;
                    case 7:
                    System.out.print("Year " + i + " July: ");
                    break;
                    case 8:
                    System.out.print("Year " + i + " August: ");
                    break;
                    case 9:
                    System.out.print("Year " + i + " September: ");
                    break;
                    case 10:
                    System.out.print("Year " + i + " October: ");
                    break;
                    case 11:
                    System.out.print("Year " + i + " November: ");
                    break;
                    case 12:
                    System.out.print("Year " + i + " December: ");
                }
                monthlyRain = input.nextDouble();
                
                while (monthlyRain <0)
                {
                    System.out.print("Invalid entry, Enter 0 or greater: ");
                    monthlyRain = input.nextDouble();
                }

                totalRainfall += monthlyRain;
            }
            totalMonths += MONTHS;
        }

        double avgRainfall = totalRainfall/totalMonths;		// Holds the average rainfall

        // Display rainfall data
        System.out.println("\nTotal Months: " + totalMonths + "\nTotal Rainfall: " + df.format(totalRainfall) + " inches" +
            "\nAverage Rainfall: " + df.format(avgRainfall) + " inches");
    }
}