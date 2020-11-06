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

 


    }
}