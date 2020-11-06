
import java.util.*; 
/**
 *
 * @author ehtesham
 */


public class Deskeygen { 
	// DES ALGORITHM - REQUIRED MATRICES

// PERMUTATION PC1
static int[][] pc1 =    {   {57,49,41,33,25,17,9},
							{1,58,50,42,34,26,18},
							{10,2,59,51,43,35,27},
							{19,11,3,60,52,44,36},
							{63,55,47,39,31,23,15},
							{7,62,54,46,38,30,22},
							{14,6,61,53,45,37,29},
							{21,13,5,28,20,12,4}
						};

						
// PERMUTATION PC2
static int[][] pc2 =    {   {14,17,11,24,1,5},
							{3,28,15,6,21,10},
							{23,19,12,4,26,8},
							{16,7,27,20,13,2},
							{41,52,31,37,47,55},
							{30,40,51,45,33,48},
							{44,49,39,56,34,53},
							{46,42,50,36,29,32}
						};
 

						


// LEFT SHIFTS						
static int[] shifts = {1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1}; 

static String ASCIItoHEX(String ascii) 
{  
	StringBuilder hex = new StringBuilder();  

	for (int i = 0; i < ascii.length(); i++) { 

		char ch = ascii.charAt(i); 
		int in = (int)ch; 
		String part = Integer.toHexString(in);  
		hex.append (part);   
	}  
	return hex.toString();  
}
 private static String hexToASCII(String hex) 
	{  
		StringBuilder ascii = new StringBuilder(); 

		for (int i = 0; i < hex.length(); i += 2) { 

			String part = hex.substring(i, i + 2);  
			char ch = (char)Integer.parseInt(part, 16);  
			ascii.append(ch); 
		} 
		return ascii.toString();  
    }
static String hextoBin(String input) 
{ 
	int n = input.length() * 4; 
	input = Long.toBinaryString( 
		Long.parseUnsignedLong(input, 16)); 
	while (input.length() < n) 
		input = "0" + input; 
	return input; 
} 
static String binToHex(String input) 
{ 
	int n = (int)input.length() / 4; 
	input = Long.toHexString( 
		Long.parseUnsignedLong(input, 2)); 
	while (input.length() < n) 
		input = "0" + input; 
	return input; 
} 
static String permutation(int[][] table, String input) 
{ 
	int[] sequence = new int[table.length*table[0].length];
	int t=0;
	for(int[] row:table)
		for(int val:row)
			sequence[t++]=val;
	return permutation(sequence,input);
} 

static String permutation(int[] sequence,String input) {
	String output = ""; 
	input = hextoBin(input); 
	for (int i = 0; i < sequence.length; i++) 
		output += input.charAt(sequence[i] - 1); 
	output = binToHex(output); 
	return output; 
}

static String leftCircularShift(String input, int numBits) 
{ 
	int n = input.length() * 4; 
	int perm[] = new int[n]; 
	for (int i = 0; i < n - 1; i++) 
		perm[i] = (i + 2); 
	perm[n - 1] = 1; 
	while (numBits-- > 0) 
		input = permutation(perm, input); 
	return input; 
} 

static String[] getKeys(String key) 
{ 
	String keys[] = new String[16]; 
	// first key permutation 
	key = permutation(pc1, key); 
	for (int i = 0; i < 16; i++) { 
		key = leftCircularShift( 
				key.substring(0, 7), shifts[i]) 
			+ leftCircularShift(key.substring(7, 14), 
								shifts[i]); 
		// second key permutation 
		keys[i] = permutation(pc2, key); 
	} 
	return keys; 
} 


static void encrypt(String key) 
{ 
	int i; 
	// get round keys 
	String keys[] = getKeys(key); 

	System.out.println("ENCRYPTION KEYS:");
	for(i=0;i<keys.length;i++)
		System.out.println("Key "+i+"  :  "+keys[i].toUpperCase());

	System.out.println();
}



	public static void main(String args[]) 
	{ 
		Scanner scanner = new Scanner(System.in);
		
		String key = "AABB09182736CCDD";
		// String text = "123456ABCD132536"; 
		// String key = "AABB09182736CCDD"; 

		System.out.println("Keygen:\n"); 
		encrypt(key); 
		
	} 
} 
