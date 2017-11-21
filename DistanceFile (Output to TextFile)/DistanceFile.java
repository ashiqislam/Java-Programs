import java.util.Scanner;
import java.io.*;

public class DistanceFile {
    public static void main(String[] args) throws IOException
    {
        int speed = 0,
        hours = 0;

        String fileName;

        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("This program will write a traveled distance report to a file.");

        System.out.print("Please enter the desired file name: ");
        fileName = keyboard.nextLine();
        
        System.out.print("Enter the cureent speed of the vehicle: ");
        speed = keyboard.nextInt();

        while(speed < 0)
        {
            System.out.print("Enter 0 or greater for speed: ");
            speed = keyboard.nextInt();
        }

        System.out.print("Enter the number of hours the vehicle will be driven at that speed: ");
        hours = keyboard.nextInt();

        while(hours < 1)
        {
            System.out.print("Enter 1 or greater for hours: ");
            hours = keyboard.nextInt();
        }


        PrintWriter openedFile = new PrintWriter(fileName + ".txt");

        openedFile.println("Hours" + "             Distance Traveled");
        openedFile.println("------------------------------------");

        int hr = 1;

        while(hours >= 1){
            openedFile.println("  " + hr + "                     " + hr * speed + " MPH");
            hr++;
            hours--;
        }
        openedFile.close();
        
        System.out.print("The distance report file was successfully created.");

    }
}
