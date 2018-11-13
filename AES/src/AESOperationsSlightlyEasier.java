/**
 * Implement all of the methods in this class.
 * In this version, although all values are bytes, arrays of ints are used instead of bytes.
 *
 * Why is this slightly easier?  The version using byte values may involve casting that you'll need to think through.
 * Also, the mixColumns step will be easier to detect whether you need to modulo reduce the polynomials with int
 * values (i.e., if a result requires more than 8 bits, modulo reduce with the appropriate XOR). 
 * 
 *
 * @author Ashiq Islam & Gianna Storione
 */

public class AESOperationsSlightlyEasier {
	
	final static int[] sbox = {
            0x63, 0x7C, 0x77, 0x7B, 0xF2, 0x6B, 0x6F, 0xC5, 0x30, 0x01, 0x67, 0x2B, 0xFE, 0xD7, 0xAB, 0x76,
            0xCA, 0x82, 0xC9, 0x7D, 0xFA, 0x59, 0x47, 0xF0, 0xAD, 0xD4, 0xA2, 0xAF, 0x9C, 0xA4, 0x72, 0xC0,
            0xB7, 0xFD, 0x93, 0x26, 0x36, 0x3F, 0xF7, 0xCC, 0x34, 0xA5, 0xE5, 0xF1, 0x71, 0xD8, 0x31, 0x15,
            0x04, 0xC7, 0x23, 0xC3, 0x18, 0x96, 0x05, 0x9A, 0x07, 0x12, 0x80, 0xE2, 0xEB, 0x27, 0xB2, 0x75,
            0x09, 0x83, 0x2C, 0x1A, 0x1B, 0x6E, 0x5A, 0xA0, 0x52, 0x3B, 0xD6, 0xB3, 0x29, 0xE3, 0x2F, 0x84,
            0x53, 0xD1, 0x00, 0xED, 0x20, 0xFC, 0xB1, 0x5B, 0x6A, 0xCB, 0xBE, 0x39, 0x4A, 0x4C, 0x58, 0xCF,
            0xD0, 0xEF, 0xAA, 0xFB, 0x43, 0x4D, 0x33, 0x85, 0x45, 0xF9, 0x02, 0x7F, 0x50, 0x3C, 0x9F, 0xA8,
            0x51, 0xA3, 0x40, 0x8F, 0x92, 0x9D, 0x38, 0xF5, 0xBC, 0xB6, 0xDA, 0x21, 0x10, 0xFF, 0xF3, 0xD2,
            0xCD, 0x0C, 0x13, 0xEC, 0x5F, 0x97, 0x44, 0x17, 0xC4, 0xA7, 0x7E, 0x3D, 0x64, 0x5D, 0x19, 0x73,
            0x60, 0x81, 0x4F, 0xDC, 0x22, 0x2A, 0x90, 0x88, 0x46, 0xEE, 0xB8, 0x14, 0xDE, 0x5E, 0x0B, 0xDB,
            0xE0, 0x32, 0x3A, 0x0A, 0x49, 0x06, 0x24, 0x5C, 0xC2, 0xD3, 0xAC, 0x62, 0x91, 0x95, 0xE4, 0x79,
            0xE7, 0xC8, 0x37, 0x6D, 0x8D, 0xD5, 0x4E, 0xA9, 0x6C, 0x56, 0xF4, 0xEA, 0x65, 0x7A, 0xAE, 0x08,
            0xBA, 0x78, 0x25, 0x2E, 0x1C, 0xA6, 0xB4, 0xC6, 0xE8, 0xDD, 0x74, 0x1F, 0x4B, 0xBD, 0x8B, 0x8A,
            0x70, 0x3E, 0xB5, 0x66, 0x48, 0x03, 0xF6, 0x0E, 0x61, 0x35, 0x57, 0xB9, 0x86, 0xC1, 0x1D, 0x9E,
            0xE1, 0xF8, 0x98, 0x11, 0x69, 0xD9, 0x8E, 0x94, 0x9B, 0x1E, 0x87, 0xE9, 0xCE, 0x55, 0x28, 0xDF,
            0x8C, 0xA1, 0x89, 0x0D, 0xBF, 0xE6, 0x42, 0x68, 0x41, 0x99, 0x2D, 0x0F, 0xB0, 0x54, 0xBB, 0x16};
		
	final static int[][] mcTable = {
			{02, 03, 01, 01},
			{01, 02, 03, 01},
			{01, 01, 02, 03},
			{03, 01, 01, 02}};
		
	/**
	 * Computes the byte substitution step of an AES round.
	 *
	 * @param state The current state matrix. This method modifies this matrix by
	 *              replacing each byte with the corresponding output from the AES
	 *              s-box.
	 */
	public static void byteSubstitution(int[][] state) {
		// HINT 1: I'd recommend simply hardcoding the S-box as a 1 dimensional array of
		// bytes as a field within this class.
		// If you use this hint, then you'd convert the 2D S-box to a simple array, by
		// starting with the first row, followed by the 2nd, etc.
		// Just Google AES S-box to find it, such as on the wikipedia page. The input
		// byte is then simply used as an index into this array.
		//
		// HINT 2: You'll probably find the S-box elements specified in hexadecimal. You
		// don't need to convert from hexadecimal to decimal
		// in using HINT 1. If you weren't already aware, in Java you can specify
		// integer values with hex, by using 0x. For example, 0x2a
		// is how you'd specify the decimal value 42 in hexadecimal.
		//
		// HINT 3: Reminder, when you initialize an array in Java, you can do so by
		// specifying a list of elements within { }.
		// For example, consider the following:
		// byte[] someBytes = { 0x2a, 0x33, 0x41 };
		// In this example, someBytes is initialized to an array of length 3, with the
		// specific values specified in hexadecimal.
		// If you follow HINT 1, you'd have something like this as a field OUTSIDE THIS
		// METHOD for the entire S-box.

		for (int row = 0; row < state.length; row++) {

			for (int col = 0; col < state[row].length; col++) {
				state[row][col] = sbox[state[row][col]];
				System.out.printf("%02x ", state[row][col]);
				// System.out.println("Value at state[" + row + "][" + col + "] is " + state[row][col]);
			}
			System.out.println();
		}
	}

	/**
	* Computes the shift rows step of an AES round.
	*
	* @param state The current state matrix. This method modifies this matrix to contain the result of the shift rows step.
	*/
	public static void shiftRows(int[][] state) {
		    int tempValue;
		    
		    // Row 0 does not change.
		    
		    // Row 1
	        tempValue = state[1][0];
	        state[1][0] = state[1][1];
	        state[1][1] = state[1][2];
	        state[1][2] = state[1][3];
	        state[1][3] = tempValue;
	        
	        // Row 2
	        tempValue = state[2][0];
	        state[2][0] = state[2][2];
	        state[2][2] = tempValue;
	        tempValue = state[2][1];
	        state[2][1] = state[2][3];
	        state[2][3] = tempValue;
	        
	        // Row 3
	        tempValue = state[3][0];
	        state[3][0] = state[3][3];
	        state[3][3] = state[3][2];
	        state[3][2] = state[3][1];
	        state[3][1] = tempValue;
	        
	        
		for (int row = 0; row < state.length; row++) {
			for (int col = 0; col < state[row].length; col++) {
				System.out.printf("%02x ", state[row][col]);
			}
			System.out.println();
		}
	}
	
	
	/**
	* Computes the mix columns step of an AES round.
	*
	* @param state The current state matrix. This method modifies this matrix to contain the result of the mix columns step.
	*/
	public static void mixColumns(int[][] state) {
		// HINT 1: See the notes or textbook for the matrix that you need to multiply by state.
		
		// HINT 2: This step is similar to a matrix multiplication, because, well it is.  However, the
		// byte values actually represent polynomials with coefficients computed mod 2, and with the result mod
		// AES's prime polynomial.  You might start by implementing a normal matrix multiplication (you'll likely
		// need a temporary 2D array for the result, but before this method finishes make sure you copy the result back into state).
		// After you implement a normal matrix multiplication, you'll need to change it according to hints 3, 4, and 5.
		
		// HINT 3: Since the elements you're adding are not actually integer values, but rather the integer values
		// are encoding the coefficients of a polynomial (mod 2), then addition should actually be done with en XOR.
		// Java's XOR operator is ^ so if you followed hint 2, then wherever you are adding, you actually want to XOR.
		
		// HINT 4: For the same reason as in HINT 2, multiplication is not actually a simple multiplication.
		//  HINT 4a: The one matrix has nothing but 1, 2, and 3 values.  If you multiply any value by 1, the result is the value (this is
		//        no different than if the numbers were integers).
		//  HINT 4b: If you need to multiply by 2, well the 2 is actually the polynomial: X.  You can multiply by 2 in one of
		//        two ways.  You can either left shift 1 position.  For example, if you what to compute state[i][j] left shifted
		//        one position, you would do this: state[i][j] << 1
		//        You can actually also just multiply by 2 (multiplying by 2 is equivalent to shifting the bit values one place to the left).
		//  HINT 4c: Wherever you are multiplying by 3, you definitely cannot actually multiply by 3.  You will get the wrong answer.
		//        The value 3 represents the polynomial: X + 1 (since 3 in binary is 11).  If you have to compute 3 * state[i][j], then
		//        this really means (X + 1) * state[i][j], which is equivalent to X * state[i][j] + 1 * state[i][j], equivalent to
		//        X * state[i][j] + state[i][j].  But from hint 4b, the multiplication by X is a left shift, and from hint 3, the addition 
		//        should be an XOR.
		
		// HINT 5: If any results are polynomials with degree 8 or higher, then you need to modulo reduce by AES's prime polynomial.
		//       In general computing f(x) mod p(x) may involve multiple rounds of shifting and XOR.  However, the multiplications you
		//       did earlier, represented by 2 and 3 (i.e., X and X + 1) will produce polynomials with degree no greater than 8.
		//       Why?  Well, since each element of the state is a byte, then with 8 bits, each position representing a power of X, the
		//       left most bit is the X to the power 7 term.  If that bit is a 1 and if you multiply by X or by X + 1, then you will end
		//       up with an X to the power 8 term (but the exponent won't be any higher than that).  So, at most a single XOR will be
		//       needed (and no shifting).  So, whenever you shift left, you'll need to first detect whether the left most bit is a 1, and
		//       if so, after shifting, you'll need to XOR with the value that represents AES's prime polynomial.
		//       CAUTION: You'll need to detect whether or not the left shift will produce an X to the 8 term before left-shifting.
		//       Since the state matrix has byte values, the left most bit is lost by the left shift (you only have 8 bits), 
		//       so you need to know what it was before the left shift.
		
		
		//AES Mixed Columns Matrix Multiplication (Mixed Columns Matrix Table * Shifted Matrix)
		
		// RULES:
		// No shift or XOR's when multiplying by 1
		// Shift other number by 1 when multiplying by 2
		// Shift other number by 1 when multiplying by 3 and X0R by original number
		
		//Temporary Array
		int mixed2DArray[][] = new int[4][4];
			
		// Start across rows of matrix A
		for (int i = 0; i < mcTable.length; i++) {
			// Work across columns of matrix B
			for (int j = 0; j < state[0].length; j++) {
				// Now complete the XOR's and multiplications while modulo reducing polynomials with degree 8 or higher
				// Remember that the highest 8 bit number is 11111111 (or 255 in Decimal notation)
				// AES Uses arithmetic in the finite field GF(2^8) with irreducible polynomial:
				// x^8 + x^4 + x^3 + x + 1 which is (100011011) or {11B}			
				for (int k = 0; k < mcTable[0].length; k++) {
					if (mcTable[i][k] == 2) { 
						mixed2DArray[i][j] ^= state[k][j] << 1;
						
					} else if (mcTable[i][k] == 3) { 
						mixed2DArray[i][j] ^= state[k][j] << 1 ^ state[k][j];	
						
					} else {
						mixed2DArray[i][j] ^= mcTable[i][k] * state[k][j]; 
					}
				}				
				if (mixed2DArray[i][j] > 255) {
					mixed2DArray[i][j] = mixed2DArray[i][j] ^ 0x11b;
				}
			}
		}

		// System.out.println("Multiplying Mixed Columns Table and Shifted Row Matrix Equals: ");
		for (int row = 0; row < mixed2DArray.length; row++) {
			for (int col = 0; col < mixed2DArray[0].length; col++) {
				System.out.printf("%02x ", mixed2DArray[row][col]);
				// System.out.print(mixed2DArray[m][n] + " ");
			}
			System.out.println();
		}
		
		state = mixed2DArray;
	}
	
	/**
	* Returns a 2D array from the key.
	* @param key The key
	* @return 2D array with the key, 4 rows and 4 columns
	*/
	public static int[][] generateKeyMatrixFromKey(int[] key) {
		// HINT: the bytes of the key or filled into the key matrix down the columns (not across rows).
		
		int array2d[][] = new int[4][4];
		
		for(int i=0; i<4;i++) {
			   for(int j=0;j<4;j++) {
			       array2d[i][j] = key[(j*4) + i]; 
			       System.out.printf("%02x ", array2d[i][j]);
			   }
			   System.out.println();
		}
		
		//System.out.println(Arrays.deepToString(array2d)); //Check if the 2D array is being returned with respective to column order
		
		return array2d;
	}
	
	
	/**
	* Computes the expanded key matrix for AES.
	* @param keyMatrix The first 4 columns, i.e., the initial key matrix.
	* @return Returns a new matrix that corresponds to the expanded key matrix of AES.
	*/
	public static int[][] keyExpansion(int[][] keyMatrix) {
		// HINT: The expanded key matrix has 4 rows and 44 columns, so start by constructing a 2D array for the result that
		// is of the correct dimensions.  Then initialize the first 4 columns with the keyMatrix.  Then iterate over the columns
		// computing the rest per the AES key expansion rules.  Finally return the new 2D array.
		
		int xpMatrix[][] = new int[4][44];
		
		for(int i = 0; i < keyMatrix.length; i++) {
			for(int j = 0; j < keyMatrix[i].length; j++) {
				xpMatrix[i][j] = keyMatrix[i][j];
			}
		}
		
		for (int row = 0; row < xpMatrix.length; row++) {
			for (int col = 0; col < xpMatrix[0].length; col++) {
				if(col == 4 || col == 8 || col == 12 || col == 16 || col == 20 
					|| col == 24 || col == 28 || col == 32 || col == 36 || col == 40) {
					for(int i = 0; i < 4; i++) {
						if (i == 0) {
							xpMatrix[i][col] = sbox[xpMatrix[i][col-1]]; // Changes needed : C
						}else {
							xpMatrix[i][col] = sbox[xpMatrix[i][col-1]]; // C
						}
					}
				}else {
					if(col > 3) {
						for(int j = 0; j < 4; j++) {
							if(j == 0) {
								xpMatrix[j][col] = sbox[xpMatrix[j][col-4]]; // C
							}else {
								xpMatrix[j][col] = sbox[xpMatrix[j][col-4]]; // C
							}
						}		
					}	
				}
			}
		}
		
		
		for (int row = 0; row < xpMatrix.length; row++) {
			for (int col = 0; col < xpMatrix[0].length; col++) {
				System.out.printf("%02x ", xpMatrix[row][col]);
			}
			System.out.println();
		}
		
		keyMatrix = xpMatrix;
						
		return keyMatrix;
	}
		
}