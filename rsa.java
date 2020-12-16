import java.math.*;
import java.util.*;


class rsa {

   static int gcd(int a , int b)
   {
      if(a==0)
         return b;
      else
         return gcd(b%a,a);
   }

   static int randprime()
   {
      // create a BigInteger object
      BigInteger bi;

      // create and assign value to bitLength
      int bitLength = 4;

      // create a random object
      Random rnd = new Random();

      // assign probablePrime result to bi using bitLength and rnd
      // static method is called using class name
      bi = BigInteger.probablePrime(bitLength, rnd);
      return bi.intValue();


   }

   static int modInverse(int a, int modm)
    {
        a = a % modm;
        for (int x = 1; x < modm; x++)
            if ((a * x) % modm == 1)
                return x;
        return 1;
    }





    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);


         int p,q,n=0,phi,d=0,e=0,i;
         int msg=0;
         double c=0;
         BigInteger msgback;
         BigInteger N;
         BigInteger C;
         System.out.print("Enter msg: ");
         msg = reader.nextInt(); 
         // System.out.print("Enter P: ");
         // p = reader.nextInt();
         // System.out.print("Enter Q: ");
         // q = reader.nextInt();

         p = randprime();
         q = randprime();

         System.out.println("Random prime P = "+p);
         System.out.println("Random prime Q = "+q);


         n = p*q;
         phi = (p-1)*(q-1);

         System.out.println("N : "+n);
         System.out.println("Phi : "+phi);

         for(e=7;e<phi;e++)
         {
            if(gcd(e,phi)==1)
            {
               break;
            }
         }

         System.out.println("e: "+e);
         d = modInverse(e,phi);

         System.out.println("d: "+d);

         c = Math.pow(msg,e)%n;

         System.out.println("cipher C: "+c);

         N = BigInteger.valueOf(n);
         C = BigDecimal.valueOf(c).toBigInteger();

         msgback = (C.pow(d)).mod(N);

         System.out.println("Decrypted msg: "+msgback);


    }
}
