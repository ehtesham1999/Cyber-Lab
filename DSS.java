
package DSS;

/**
 *
 * @author ehtesham
 */


import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.Signature;
import java.util.Scanner;
import java.io.ObjectOutputStream;

public class DSS {
   public static void main(String args[]) throws Exception {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the message to be signed:");
      String msg = sc.nextLine();
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
      keyPairGen.initialize(512);
      KeyPair pair = keyPairGen.generateKeyPair();
      DSAPrivateKey privKey = (DSAPrivateKey)pair.getPrivate();
      DSAPublicKey pubKey = (DSAPublicKey) pair.getPublic();
      System.out.println("Private Key:\n"+privKey.getX());
      System.out.println("Public Key:\n "+ pubKey.getY());
      Signature sign = Signature.getInstance("SHA1withDSA");
      sign.initSign(privKey);
      byte[] bytes = msg.getBytes();
      sign.update(bytes);
      byte[] signature = sign.sign();
      System.out.println("Digital signature for given text: "+ bytesToHex(signature));

      //verification using public key
      sign = Signature.getInstance("SHA1withDSA");
      sign.initVerify(pubKey);
      sign.update(bytes);
      if(sign.verify(signature))
        System.out.println("Signature has been verified.");
      else
        System.out.println("Signature verification failed.");
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
}
