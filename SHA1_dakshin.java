import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class sha1_dakshin {
	private List<byte[]> inputDataList = new ArrayList<byte[]>();

	// Bitwise rotate a 32-bit number to the left
	private static int rol(int num, int cnt) {
		return (num << cnt) | (num >>> (32 - cnt));
	}

	public byte[] digest(byte[] x) {

		// Append padding bits and the length, as described in the SHA1 standard
		int[] blks = new int[(((x.length + 8) >> 6) + 1) * 16];
		int i;
		for(i = 0; i < x.length; i++) {
			blks[i >> 2] |= x[i] << (24 - (i % 4) * 8);
		}
		blks[i >> 2] |= 0x80 << (24 - (i % 4) * 8);
		blks[blks.length - 1] = x.length * 8;

		// calculate 160 bit SHA1 hash of the sequence of blocks

		int[] w = new int[80];

		// int a =  1732584193;
		// int b = -271733879;
		// int c = -1732584194;
		// int d =  271733878;
		// int e = -1009589776;

		int a = 0x67452301;
		int b = 0xEFCDAB89;
		int c = 0x98BADCFE;
		int d = 0x10325476;
		int e = 0xC3D2E1F0;

		for(i = 0; i < blks.length; i += 16) {
			int olda = a;
			int oldb = b;
			int oldc = c;
			int oldd = d;
			int olde = e;

			for(int j = 0; j < 80; j++) {
				w[j] = (j < 16) ? blks[i + j] :
					( rol(w[j-3] ^ w[j-8] ^ w[j-14] ^ w[j-16], 1) );

				int t = rol(a, 5) + e + w[j] +
						( (j < 20) ?  0x5A827999 + ((b & c) | ((~b) & d))
								: (j < 40) ?  0x6ED9EBA1 + (b ^ c ^ d)
										: (j < 60) ? -0x8F1BBCDC + ((b & c) | (b & d) | (c & d))
												: -0xCA62C1D6 + (b ^ c ^ d) );
				e = d;
				d = c;
				c = rol(b, 30);
				b = a;
				a = t;
			}

			a = a + olda;
			b = b + oldb;
			c = c + oldc;
			d = d + oldd;
			e = e + olde;
		}

		// Convert result to a byte array
		byte[] digest = new byte[20];
		fill(a, digest, 0);
		fill(b, digest, 4);
		fill(c, digest, 8);
		fill(d, digest, 12);
		fill(e, digest, 16);

		return digest;
	}

	private void fill(int value, byte[] arr, int off) {
		arr[off + 0] = (byte) ((value >> 24) & 0xff);
		arr[off + 1] = (byte) ((value >> 16) & 0xff);
		arr[off + 2] = (byte) ((value >> 8) & 0xff);
		arr[off + 3] = (byte) ((value >> 0) & 0xff);
	}
	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for (int j = 0; j < bytes.length; j++) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
	        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	public static void main(String[] args) {
		sha1_dakshin sha = new sha1_dakshin();
		System.out.println("Enter the string: ");
		Scanner scanner = new Scanner(System.in);
		String p = scanner.nextLine();
		byte[] digest = sha.digest(p.getBytes());
		System.out.println("The SHA1 hash is "+bytesToHex(digest));
	}
}
