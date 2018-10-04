import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Copyright © Ashiq Islam & Gianna Storione 2018
 * 
 * PLAYFAIR CIPHER SOLVER
 * 
 * @author Ashiq Islam
 * @author Gianna Storione
 *
 */

public class PlayfairDemo {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String keyword = "";
		String message = "";
		char answer = '\0';

		System.out.println("------------------------");
		System.out.println("PLAYFAIR ENCODER/DECODER");
		System.out.println("------------------------");

		System.out.println("\nPlease enter the Keyword: ");
		keyword = sc.nextLine();
		while(keyword.length() > 25) {
			System.out.println("\nKeyword cannot be more than 25 characters. Please re-enter Keyword: ");
			keyword = sc.nextLine();
		}

		Playfair obj = new Playfair(keyword);

		System.out.println("\nWould you like to (E)ncrypt or (D)crypt? Enter E to Encrypt or D for Decrypt: ");
		answer = (sc.next()).toUpperCase().charAt(0);
		sc.nextLine();
		while(answer != 'E' && answer != 'D') {
			System.out.println("Sorry. Invalid Entry. Please enter E to Encrypt or D to Decrypt: ");
			answer = (sc.next()).toUpperCase().charAt(0);
		}
		if(answer == 'E') {
			obj.generateKey();

			FileReader fr = new FileReader("plaintext.txt"); 

			int i; 
			while ((i=fr.read()) != -1) 
			{
				message += (char) i;

			}
			fr.close();

			obj.Encrypt(message);

			File file = new File("out1.txt");
			file.createNewFile();	
			FileWriter writer = new FileWriter(file); 
			writer.write(obj.getEncryption()); 
			writer.flush();
			writer.close();

			System.out.println("\nEncrypted file successfully created in Project Directory!! (out1.txt)");

		} else if (answer == 'D') {
			obj.generateKey();

			FileReader fr = new FileReader("ciphertext.txt"); 

			int i; 
			while ((i=fr.read()) != -1) 
			{
				message += (char) i;

			}
			fr.close();

			obj.Decrypt(message);

			File file = new File("out2.txt");
			file.createNewFile();
			FileWriter writer = new FileWriter(file); 
			writer.write(obj.getDecryption()); 
			writer.flush();
			writer.close();

			System.out.println("\nDecrypted file successfully created in Project Directory!! (out2.txt)");

		}
		sc.close();
	}
}
