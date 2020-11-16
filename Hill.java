import java.util.Scanner;


public class Hill_practise {
    static int [][] keymatrix = new int[3][3];
    static int [][] inverse = new int [3][3];
    
    
    static String cipher_text = "";
    static String decipher_text = "";


    public static int determinant(int key[][]) {
        int det = 0;
        for (int i = 0; i < 3; i++) {
            det = det + (key[0][i] * (key[1][(i + 1) % 3] * key[2][(i + 2) % 3]
                    - key[1][(i + 2) % 3] * key[2][(i + 1) % 3]));
        }
        det %= 26;
        return det;
    }
    
    static void display(int A[][]) 
    { 
           
            for (int i = 0; i < 3; i++) 
            { 
                    for (int j = 0; j < 3; j++) 
                            System.out.print(A[i][j]+ " "); 
                    System.out.println(); 
            } 
    } 
    
    
    static void constructMatrix(String key)
    {
        
        
        key = key.substring(0,9);
        key = key.toUpperCase();

        System.out.println(key);
        int k = 0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
                keymatrix[i][j] = key.charAt(k++)-'A';
        }
        display(keymatrix);
        

    }

    
    static void constructInverseMatrix(int matrix[][])
    {
        
        
        //int inverse[][] = new int[3][3];
        int det = determinant(matrix);
        if (det % 2 == 0 || det % 13 == 0) {
            System.out.println("The given key matrix is not invertible");
            return;
        }
        int inv_det = -1;
        for (int inv = 1; inv < 27; ++inv) {
            if ((inv * det) % 26 == 1) {
                inv_det = inv;
            }
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                inverse[i][j] = ((((matrix[(j + 1) % 3][(i + 1) % 3] * matrix[(j + 2) % 3][(i + 2) % 3]) 
                        - (matrix[(j + 1) % 3][(i + 2) % 3] * matrix[(j + 2) % 3][(i + 1) % 3]))) * inv_det) % 26;
                inverse[i][j] %= 26;
                if (inverse[i][j] < 0) {
                    inverse[i][j] += 26;
                }
            }
        }
        System.out.println();
        System.out.println("Inverse matrix: ");

        display(inverse);
        

    }
    
    static void doEncrypt(String curr_text)
    {
        int [][] plainmatrix = new int[10][10];

        
        for(int i=0;i<3;i++)
        {
            plainmatrix[i][0] = curr_text.charAt(i)-'A';
        }

        System.out.println("plainmatrix: ");
        for(int i=0;i<3;i++)
        {
            System.out.print(plainmatrix[i][0]+" ");
        }



        int res = 0;
        System.out.println();
        for(int i=0;i<3;i++)
        {
            res = 0;
            for(int j=0;j<3;j++)
            {
                res = res + keymatrix[i][j]*plainmatrix[j][0];
            }
            cipher_text = cipher_text + (char)((res%26)+'A');
        }


        System.out.println("cipher text : "+cipher_text);
        
    }
    
    static void encrypt(String plaintext)
    {
        
        int rem = plaintext.length()%3;
        rem = 3-rem;

        for(int i=0;i<rem;i++)
        {
            plaintext = plaintext +  " "; 
        }
        //System.out.println(plaintext+" "+plaintext.length());

        int blocks = (int)(plaintext.length()/3);
        System.out.println("Encrypting blocks : ");
        for(int i=0;i<blocks;i+=3)
        {
            doEncrypt(plaintext.substring(i,i+3));
            //System.out.println(plaintext.substring(i,i+3));
        }

    }


    static void doDecrypt(String curr_text)
    {
        int [][] plainmatrix = new int[10][10];

        
        for(int i=0;i<3;i++)
        {
            plainmatrix[i][0] = curr_text.charAt(i)-'A';
        }

        System.out.println("plainmatrix: ");
        for(int i=0;i<3;i++)
        {
            System.out.print(plainmatrix[i][0]+" ");
        }



        int res = 0;
        System.out.println();
        for(int i=0;i<3;i++)
        {
            res = 0;
            for(int j=0;j<3;j++)
            {
                res = res + inverse[i][j]*plainmatrix[j][0];
            }
            decipher_text = decipher_text + (char)((res%26)+'A');
        }


        System.out.println("Decipher text : "+decipher_text);
        
        
    }
    
    static void decrypt(String cipher)
    {
        
        // int rem = cipher.length()%3;
        // rem = 3-rem;

        // for(int i=0;i<rem;i++)
        // {
        //     cipher = cipher +  " "; 
        // }
        
        int blocks = (int)(cipher.length()/3);
        System.out.println("Decrypting blocks : ");
        for(int i=0;i<blocks;i+=3)
        {
            doDecrypt(cipher.substring(i,i+3));
            //System.out.println(plaintext.substring(i,i+3));
        }



    }
   
    
    public static void main(String[] args) {
        
        
        int choice;
        
        Scanner scan = new Scanner(System.in);
        Scanner reader = new Scanner(System.in);
        scan.useDelimiter("\n");
        String plaintext = "";
        String key = "";
        String new_key = "";
        
        
        do{
            System.out.println("\n1. Enter plain text");
            System.out.println("2. Enter key text");
            System.out.println("3. Create Matrix");
            System.out.println("4. Encrypt");
            System.out.println("5. Decrypt");
            System.out.println("6. Exit");
            System.out.println("\nEnter choice: ");
            choice = reader.nextInt();
        
            
            switch(choice)
            {
                
                case 1:
                    System.out.println("Enter plaintext: ");
                    plaintext = scan.next();
                    plaintext = plaintext.toUpperCase();
                    //plaintext = plaintext.replaceAll("\\s", ""); 
                    // System.out.println(plaintext+" ");
                    // System.out.print(plaintext.length());
                    
                    break;
                    
                case 2:
                    System.out.println("Enter Key: ");
                    key = scan.next();
                    key = key.replaceAll("\\s", ""); 
                    break;
                    
                case 3:
                    Hill_practise.constructMatrix(key);
                    break;
                    
                case 4:
                    
                    Hill_practise.encrypt(plaintext);
                    System.out.println("\nEncrypted text: "+cipher_text);
                    break;

                case 5:

                    Hill_practise.constructInverseMatrix(keymatrix);
                    Hill_practise.decrypt(cipher_text);
                    System.out.println("\nDecrypted text: "+decipher_text);
                    break;
            }
        }while(choice!=6);
        
    }
    
}
