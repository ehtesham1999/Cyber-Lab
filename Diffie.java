import java.util.*;
import java.math.*;

public class Diffie {

	
    static BigInteger power(BigInteger A , BigInteger b , BigInteger P)
    {
        
        return (A.pow(b.intValue())).mod(P);
        
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        BigInteger xa,xb;
        BigInteger p,g;
        // sample P value = 353 and sample G value = 3 
        // G is a primitive root of 353 
        // Xa<P and Xb<P
        p = BigInteger.valueOf(353);
        g = BigInteger.valueOf(3);
        BigInteger ya ,yb ;
        System.out.println(" P : "+p.intValue());
        System.out.println(" G : "+g.intValue());
        
        System.out.println("Enter Xa(<p): ");
        xa = BigInteger.valueOf(scan.nextInt());

        ya = power(g,xa,p);
        System.out.println(" Ya : "+ya.intValue());
        


        System.out.println("Enter Xb(<p): ");
        xb = BigInteger.valueOf(scan.nextInt());
        
        yb = power(g,xb,p);
        System.out.println(" Yb : "+yb.intValue());

        BigInteger ka,kb;

        ka = power(yb,xa,p);
        kb = power(ya,xb,p);
		System.out.println("key Ka : "+ka.intValue());
		System.out.println("key Kb : "+kb.intValue());
		        

    }
}
