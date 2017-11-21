/**
 * Chapter 8
 * Programming Challenge 5: Password Verifier
 * The PasswordVerifier class stores data about
 * a user's password.
 */

public class PasswordVerifier
{
    // Constant for minimum password length
    public static final int MIN_PASSWORD_LENGTH = 6;

    /**
     * isValid method
     */

    public static boolean isValid(String str)
    {
        boolean status; // Validity status

        if (str.length() >= MIN_PASSWORD_LENGTH && hasUpperCase(str) && 
        hasLowerCase(str) && hasDigit(str))
            status = true;
        else
            status = false;

        return status;
    }

    /**
     * hasUpperCase method
     */

    private static boolean hasUpperCase(String str)
    {
        boolean status = false; // Validity status

        for (int i = 0; i < str.length(); i++)
        {
            if (Character.isUpperCase(str.charAt(i)))
                status = true;
        }

        return status;
    }

    /**
     * hasLowerCase method
     */

    private static boolean hasLowerCase(String str)
    {
        boolean status = false; // Validity status

        for (int i = 0; i < str.length(); i++)
        {
            if (Character.isLowerCase(str.charAt(i)))
                status = true;
        }

        return status;
    }

    /**
     * hasDigit method
     */

    private static boolean hasDigit(String str)
    {
        boolean status = false; // Validity status

        for (int i = 0; i < str.length(); i++)
        {
            if (Character.isDigit(str.charAt(i)))
                status = true;
        }

        return status;
    }
}