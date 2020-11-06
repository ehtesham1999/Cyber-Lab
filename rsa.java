import java.util.*;
import java.math.*;

public class rsa {

	static int gcd(int a , int b)
	{
		if(a==0)
			return b;
		else
			return gcd(b%a,a);
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
        System.out.print("Enter P: ");
        p = reader.nextInt();
        System.out.print("Enter Q: ");
		q = reader.nextInt();

		n = p*q;
		phi = (p-1)*(q-1);

		System.out.println("N : "+n);
		System.out.println("Phi : "+phi);

		for(e=2;e<phi;e++)
		{
			if(gcd(e,phi)==1)
			{
				break;
			}
		}

		System.out.println("e: "+e);
		// d*e = i*phi+1
		// d = ((i*phi)+1)/e

		for(i=0;i<9;i++)
		{
			int x = (i*phi)+1;

			if(x%e==0)
			{
				d = x/e;
				break; 
			}
		}

		System.out.println("d: "+d);

		c = Math.pow(msg,e)%n;

		System.out.println("cipher C: "+c);

		N = BigInteger.valueOf(n);
		C = BigDecimal.valueOf(c).toBigInteger();

		msgback = (C.pow(d)).mod(N);

		System.out.println("Decrypted msg: "+msgback);






        
    }
}