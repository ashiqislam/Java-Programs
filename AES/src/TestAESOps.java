/**
* Start by implementing the AES related methods in any of the 3 provided Java files.  And then return here to test.
* @author Your names here
*/

public class TestAESOps {
	
	public static void main(String[] args) {
		// Write some code to test your various methods.
		// You might consider using homework problems as a source of test cases since you can compare
		// output to what you worked through by hand.
		
		// In Java, if you want to output an integer value in hexadecimal, you can use printf as follows:
		// int value = SOME INTEGER VALUE;
		// System.out.printf("%02x", value);
		// The % starts specifying formatting.  The 02 means use 2 places and pad 1 digit numbers with a leading 0.
		// The x means use hexadecimal.  printf doesn't put a new line character.  If you want to start a new line after,
		// System.out.printf("%02x\n", value);  
		// If you want to output multiple values with a single printf (assume they're called value1, value2, etc)
		// then in the String that is the first parameter, you'd have formatting requirements for each as follows:
		// System.out.printf("%02x %02x %02x %02x\n", value1, value2, value3, value4);
		
		
		int[][] matrix = new int[][] { 
			{ 0x08, 0x10, 0x35, 0xa6 }, 
			{ 0x32, 0xa1, 0x74, 0x40 },
			{ 0x64, 0x00, 0x25, 0x10 }, 
			{ 0x46, 0xe1, 0x35, 0x13 }};

		System.out.println("\nByte Substitution Step:");
		AESOperations.byteSubstitution(matrix);

		System.out.println("\nShift Rows Step:");
		AESOperations.shiftRows(matrix);
		
		
		/*int[][] mcTest = {
				{0x30, 0xca, 0x96, 0x24},
				{0x32, 0x92, 0x09, 0x23},
				{0x3f, 0xca, 0x43, 0x63},
				{0x7d, 0x5a, 0xf8, 0x96}};*/
		
		
		System.out.println("\nMixed Columns Step:");
		AESOperations.mixColumns(matrix);

		System.out.println("\nGenerate Key Step:");
		// Assuming key[] is entered column by column
		int[] keyTest = new int[] { 0x1a, 0x00, 0x50, 0x12, 0xbe, 0x10, 0x00, 0xc0, 0x01, 0x20, 0x40, 0x34, 0x07, 0x10, 0x00, 0x01};
		AESOperations.generateKeyMatrixFromKey(keyTest);
			
		
		int[][] keyMatrix = {
		{0x1a, 0xbe, 0x01, 0x07},
		{0x00, 0x10, 0x20, 0x10},
		{0x50, 0x00, 0x40, 0x00},
		{0x12, 0xc0, 0x34, 0x01}};
		System.out.println("\nKey Expansion Step:");
		AESOperations.keyExpansion(keyMatrix);

	}
}
