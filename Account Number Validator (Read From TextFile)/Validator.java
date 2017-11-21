/**
 * The Validator class provides a method to 
 * validate account numbers.
 */
import java.util.Scanner; 
import java.io.File;
import java.io.FileNotFoundException;

public class Validator
{
    // Array of valid numbers

    int[] valid = Validator ("AccountNumbers.txt");

    /*
     * This method will take int parameter representing the name of the given filename above. It will copy the
     * contents into an array of ints.
     * 
     * @param String filename
     * @return int[]
     * 
     * Assuming that there is one int(word) per line in the file
     */

    public static int[] Validator(String filename) {
        int ctr = 0;
        //begin Step 1:
        // Count how many lines are in the files
        try { 
            Scanner s1 = new Scanner(new File(filename));
            while(s1.hasNextLine()) {
                ctr = ctr + 1;
                s1.next();
            }

            //begin Step 2:
            //Create the array of ints and copy the elements in
            int[] valid = new int[ctr];

            Scanner s2 = new Scanner(new File(filename));
            for (int i =0; i < ctr; i = i + 1) 
            {
                valid[i] = s2.nextInt();
            }
            return valid;

        }
        catch (FileNotFoundException e) {
        }
        return null; 
    }

    public boolean isValid(int number)
    {
        boolean found = false;  // Flag
        int index = 0;          // Array index

        while (!found && index < valid.length)
        {
            if (valid[index] == number)
                found = true;
            else
                index++;
        }

        return found;
    }
}
