/**
 * Copyright © Ashiq Islam & Gianna Storione 2018
 * 
 * PLAYFAIR CIPHER SOLVER
 * 
 * Rule 1: If both letters are the same (or only one letter is left), add an "X" after the first letter. Encrypt the new pair and 
 * continue. Some variants of Playfair use "Q" instead of "X", but any letter, itself uncommon as a repeated pair, will do.
 * 
 * Rule 2: If the letters appear on the same row of your table, replace them with the letters to their immediate right respectively 
 * (wrapping around to the left side of the row if a letter in the original pair was on the right side of the row).
 * 
 * Rule 3: If the letters appear on the same column of your table, replace them with the letters immediately below respectively 
 * (wrapping around to the top side of the column if a letter in the original pair was on the bottom side of the column).
 * 
 * Rule 4: If the letters are not on the same row or column, replace them with the letters on the same row respectively 
 * but at the other pair of corners of the rectangle defined by the original pair. The order is important – the 
 * first letter of the encrypted pair is the one that lies on the same row as the first letter of the plaintext pair.
 * 
 * Decryption: Use the inverse of the last 3 rules.
 * 
 * @author Ashiq Islam
 * @author Gianna Storione
 *
 */

public class Playfair 
{
	private String key;
	private String keyword;
	private String message;
	private String encryptedText;
	private String decryptedText;
	final static String ALPHABET = "ABCDEFGHIKLMNOPQRSTUVWXYZ";

	public Playfair(String s)
	{
		keyword = s.toUpperCase();
		keyword = keyword.replaceAll("[^a-zA-Z]","");
		encryptedText = "";
		decryptedText = "";
		message = "";
		key = "";
	}

	public String RemoveDuplicates(String kw)
	{
		for(int i = 0; i < kw.length(); i++)
		{
			for(int j = i + 1; j < kw.length(); j++)
			{
				if(kw.charAt(i) == kw.charAt(j))
				{
					kw = kw.substring(0,j)+kw.substring(j+1);    
				}
			}
		} 
		return kw;
	}

	public String insertKey(String kw)
	{
		for(int i = 0;i < 25; i++)
		{
			if(kw.indexOf(ALPHABET.charAt(i))==-1)
			{
				kw += ALPHABET.charAt(i);
			}
		}
		return kw;
	}

	public void generateMatrix()
	{
		int i = 0;
		for(int row = 0; row < 5; row++)
		{
			for(int col = 0; col < 5; col++)
			{
				System.out.print(key.charAt(i)+"   ");
				i++;
			}
			System.out.print("\n");
		}
	}

	public void generateKey()
	{
		keyword = keyword.replaceAll("J", "");
		
		keyword = RemoveDuplicates(keyword); 

		System.out.println("\nKEYWORD: " + keyword + "\n");

		key = insertKey(keyword);
		generateMatrix();
	}

	public void Encrypt(String str)
	{
		String char1;
		String char2;
		int position1;
		int position2;
		int tempMod;
		String tempIndex;
		String char1Temp;
		String char2Temp;

		message = str.toUpperCase();
		message = message.replaceAll("[^a-zA-Z]","");

		for(int i = 0; i < message.length()-1; i++)
		{
			if(message.charAt(i) == message.charAt(i+1))
			{
				message = message.substring(0,i+1)+"X"+message.substring(i+1);
			}    
		} 
		//System.out.println(message);

		if(message.length()%2 == 1)
		{
			message += "X";
		}

		for(int i = 0; i < message.length(); i += 2)
		{
			char1 = String.valueOf(message.charAt(i));  
			char2 = String.valueOf(message.charAt(i+1));
			position1 = -1;
			position2 = -1;

			for(int j = 0; j < 25 ; j++)
			{ 

				tempIndex = String.valueOf(key.charAt(j));
				char1Temp = char1;
				char2Temp = char2;

				if(char1Temp.equalsIgnoreCase(tempIndex))
				{
					position1 = j;
				}else if(char2Temp.equalsIgnoreCase(tempIndex))
				{
					position2 = j;
				}
			}
			if((position1)%5 == (position2)%5)
			{   
				if(position1/5 == 4)
				{
					tempMod = position1 % 5;
					encryptedText += String.valueOf( key.charAt( tempMod ));
					encryptedText += String.valueOf( key.charAt( position2+5 ));
				}
				else if(position2/5 == 4)
				{
					tempMod = position2 % 5;
					encryptedText += String.valueOf( key.charAt( position1+5 ));
					encryptedText += String.valueOf( key.charAt( tempMod ));
				}
				else
				{
					encryptedText += String.valueOf( key.charAt( position1+5 ));
					encryptedText += String.valueOf( key.charAt( position2+5 ));
				}
			}
			else if(position1/5 == position2/5)
			{
				if(position1%5 == 4)
				{
					encryptedText += String.valueOf( key.charAt( position1-4 ));
					encryptedText += String.valueOf( key.charAt( position2+1 ));
				}
				else if(position2%5 == 4)
				{
					encryptedText += String.valueOf( key.charAt( position1+1 ));
					encryptedText += String.valueOf( key.charAt( position2-4 ));
				}
				else
				{
					encryptedText += String.valueOf( key.charAt( position1+1 ));
					encryptedText += String.valueOf( key.charAt( position2+1 ));
				}
			}
			else
			{                               
				tempMod = position2 % 5 - position1 % 5;
				encryptedText += String.valueOf( key.charAt( position1+tempMod ));
				tempMod = -tempMod;
				encryptedText += String.valueOf( key.charAt( position2+tempMod ));
			}
		}
	}

	public void Decrypt(String str)
	{
		String char1;
		String char2;
		int position1 = -1;
		int position2 = -1;
		int tempMod;
		String tempIndex;

		encryptedText = str;
		encryptedText = encryptedText.replaceAll("\\s","");
		encryptedText = encryptedText.replaceAll("[^a-zA-Z]","");

		for(int i = 0; i < encryptedText.length(); i += 2)
		{

			if(encryptedText.length()%2 == 1)
			{
				encryptedText += "X";
			}

			char1 = String.valueOf(encryptedText.charAt(i));
			char2 = String.valueOf(encryptedText.charAt(i+1));


			for(int j = 0; j < 25; j++){

				tempIndex = String.valueOf(key.charAt(j));


				if(char1.equalsIgnoreCase(tempIndex))
				{
					position1 = j;
				}
				else if(char2.equalsIgnoreCase(tempIndex))
				{
					position2 = j;
				}
			}

			if((position1)%5 == (position2)%5)
			{  
				if(position1/5 == 0){
					tempMod = position1 % 5;
					decryptedText += String.valueOf( key.charAt( tempMod+20 ));
					decryptedText += String.valueOf( key.charAt( position2-5 ));
				}
				else if(position2/5 == 0){
					tempMod = position2 % 5;
					decryptedText += String.valueOf( key.charAt( position1-5 ));
					decryptedText += String.valueOf( key.charAt( tempMod+20 ));
				}
				else
				{
					decryptedText += String.valueOf( key.charAt( position1-5 ));
					decryptedText += String.valueOf( key.charAt( position2-5 ));
				}
			}
			else if(position1/5 == position2/5)
			{
				if(position1%5 == 0)
				{
					decryptedText += String.valueOf( key.charAt( position1+4 ));
					decryptedText += String.valueOf( key.charAt( position2-1 ));
				}else if(position2%5 == 0)
				{
					decryptedText += String.valueOf( key.charAt( position1-1 ));
					decryptedText += String.valueOf( key.charAt( position2+4 ));
				}else
				{
					decryptedText += String.valueOf( key.charAt( position1-1 ));
					decryptedText += String.valueOf( key.charAt( position2-1 ));
				}
			}
			else
			{                                  
				tempMod = position2 % 5 - position1 % 5;
				decryptedText += String.valueOf( key.charAt( position1+tempMod ));
				tempMod = -tempMod;
				decryptedText += String.valueOf( key.charAt( position2+tempMod ));
			}
		}
	}

	public String getEncryption()
	{
		return encryptedText;
	}

	public String getDecryption()
	{
		return decryptedText;
	}
} 