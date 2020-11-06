import java.util.*;
import java.math.*;

public class inverse{


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
        reader.useDelimiter("\n");
    	 int[] A = {2,3,2}; 
		 int[] m = {3,5,7}; 
		 int[] Marr = new int[10]; 
		 int[] invMarr = new int[10]; 
		 int M=1;
		 int X=0;

        
        System.out.println("A : ");
		 for(int i=0;i<3;i++)
		 {
		 	System.out.println("A["+i+"] = "+A[i]);
		 }
        
		 System.out.println("m : ");
		 for(int i=0;i<3;i++)
		 {
		 	System.out.println("m["+i+"] = "+m[i]);
		 }
        


		 for(int i=0;i<3;i++)
		 {
		 	M = M*m[i];
		 }

		System.out.println("M: "+M);
		
         
		 for(int i=0;i<3;i++)
		 {
		 	Marr[i] = M/m[i];
		 }

		System.out.println("Marr: ");
		 for(int i=0;i<3;i++)
		 {
		 	System.out.println("Marr["+i+"] = "+Marr[i]);
		 }

		for(int i=0;i<3;i++)
		 {
		 	invMarr[i] = modInverse(Marr[i],m[i]);
		 }

		 System.out.println("Inv Marr: ");
		 for(int i=0;i<3;i++)
		 {
		 	System.out.println("Marr["+i+"] = "+invMarr[i]);
		 }

		// X = a1.M1.M−1 1 + a2.M2.M−1 2 + a3.M3.M−1 3 mod M 

		
		for(int i=0;i<3;i++)
		 {
		 	X = X + A[i]*Marr[i]*invMarr[i];
		 }

		 X = X%M;



		System.out.println("X :"+X);


    }
}