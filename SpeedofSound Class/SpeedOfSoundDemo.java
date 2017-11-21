import java.util.Scanner;

public class SpeedOfSoundDemo
{
       public static void main(String[] args)
    {
        SpeedOfSoundDemo.runProgram();
    }
    
    public static void runProgram(){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("1. Air");
        System.out.println("2. Water");
        System.out.println("3. Steel");
        System.out.println("4. Quit");
        System.out.print("Please choose an option between 1-4 (inclusive): ");
        char choice = keyboard.next().charAt(0);
        //if(choice != '1' && choice != '2' && choice != '3' && choice != '4')
        //{
            //System.out.println("g");
        //}

        double distance;

        switch (choice)
        {
            case '1':
            System.out.print("\nEnter the distance sound wave will travel: ");
            distance = keyboard.nextDouble();
            SpeedOfSound sound1 = new SpeedOfSound(distance);
            System.out.print("\nThe time is " + sound1.getTimeInAir()+ " seconds.");
            break;

            case '2':
            System.out.print("\nEnter the distance sound wave will travel: ");
            distance = keyboard.nextDouble();
            SpeedOfSound sound2 = new SpeedOfSound(distance);
            System.out.print("\nThe time is " + sound2.getTimeInWater() + " seconds.");
            break;

            case '3':
            System.out.print("\nEnter the distance sound wave will travel: ");
            distance = keyboard.nextDouble();
            SpeedOfSound sound3 = new SpeedOfSound(distance);
            System.out.print("\nThe time is " + sound3.getTimeInSteel() + " seconds.");
            break;

            case '4':
            System.out.print("Goodbye.");
            System.exit(0);
            break;

            default:
            System.out.println("\nInvalid entry.");
            SpeedOfSoundDemo.runProgram();
        }
    }
}
