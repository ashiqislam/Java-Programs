import java.util.Scanner;
import java.util.Random;

public class RandomClassTutorial 
{
    public static void main (String[] args)
    {
        System.out.println("Hello World");
        int number;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input a number: ");
        number = keyboard.nextInt();
        System.out.println("The value you entered was: " + number);
        Random generator2 = new Random();
        int dice1 = generator2.nextInt(6)+1;
        int dice2 = generator2.nextInt(6)+1;
        System.out.println("Value of dice 1: " + dice1);
        System.out.println("Value of dice 2: " + dice2);
        int totaldiceValues = dice1 + dice2;
        System.out.println("You rolled a " + dice1 + " and a " + dice2 + ". \nThe total " +
        "of these rolls is: " + totaldiceValues);

        System.out.println("Enter a temperature: ");
        int temp = keyboard.nextInt();
        if (temp >= 100)
        {
            System.out.println("The water is boiling.");
        } else if (temp >= 80) {
            System.out.println("The water is almost boiling.");
        } else {
            System.out.println("The water is not boiling yet.");

        }
        System.out.println("FIGHTING EXCERSISE \n");
        System.out.println("Attack Points of the Monster: ");
        int monsterAttack = keyboard.nextInt();

        System.out.println("Defense Points of the Monster: ");
        int monsterDefense = keyboard.nextInt();

        System.out.println("Damage of Monster: ");
        int monsterDamage = keyboard.nextInt();

        System.out.println("Life Points of the Monster: ");
        int monsterLife = keyboard.nextInt();

        System.out.println("Your Attack Points: ");
        int myAttack = keyboard.nextInt();

        System.out.println("Your Defense Points: ");
        int myDefense = keyboard.nextInt();

        System.out.println("Your Damage: ");
        int myDamage = keyboard.nextInt();

        System.out.println("Your Life Points: ");
        int myLP = keyboard.nextInt();

        Random generator = new Random();
        boolean attacker = generator.nextBoolean();
        if (attacker) {
            System.out.println("You attack");
            int dice = generator.nextInt(6)+1 + generator.nextInt(6)+1;
            int attackValue = myAttack + dice;
            System.out.println("Rolled Values: "+ dice);
            System.out.println("Your attack value: " +attackValue);
            if (attackValue > monsterDefense)
            {
                System.out.println("Your attack was successful.");
                monsterLife = monsterLife - myDamage;
                System.out.println("Monsters remaining Life Points: " + monsterLife);
            } else {
                System.out.println("Your attack was not succesful.");
            }

        } else {
            System.out.println("Monster attacks.");
            int dice = generator.nextInt(6)+1 + generator.nextInt(6)+1;
            int attackValue = monsterAttack + dice;
            System.out.println("Rolled Values Total: "+ dice);
            System.out.println("Monster attack value: " +attackValue);
            if (attackValue > myDefense)
            {
                System.out.println("Monster attack was successful.");
                monsterLife = monsterLife - myDamage;
                System.out.println("Your remaining Life Points: " + myLP);
            } else {
                System.out.println("Monster attack was not succesful.");
            }
        }
    }
}
