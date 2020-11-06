import java.util.Scanner;

public class EvenOdd {

	static int gcd(int a , int b)
	{
		if(a==0)
			return b;
		else
			return gcd(b%a,a);
	}

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        System.out.print("Enter a number yess: ");
        int num1 = reader.nextInt();
	int num2 = reader.nextInt();

        System.out.println("GCD : "+gcd(num1,num2));
    }
}