import java.util.*;
import java.math.*;

public class Diffie {

	static int gcd(int a , int b)
	{
		if(a==0)
			return b;
		else
			return gcd(b%a,a);
	}


	static long power(long a , long b , long p)
	{
		return ((long)(Math.pow(a,b))%p);
	}





    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        long xa,xb;
        long p,g;
        p = 7;
        g = 17;
        long ya = 0,yb = 0;
        System.out.println(" P : "+p);
        System.out.println(" G : "+g);
        
        System.out.println("Enter Xa(<p): ");
        xa = scan.nextInt();

        ya = power(g,xa,p);
        System.out.println(" Ya : "+ya);
        


        System.out.println("Enter Xb(<p): ");
        xb = scan.nextInt();
        
        yb = power(g,xb,p);
        System.out.println(" Yb : "+yb);

        long ka,kb;

        ka = power(yb,xa,p);
        kb = power(ya,xb,p);
		System.out.println("key Ka : "+ka);
		System.out.println("key Kb : "+kb);
		        






        
    }
}