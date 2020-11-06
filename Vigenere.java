

import java.util.Scanner;

public class Vigenere {
    
    static char[][] mat = new char [26][26];
   
    
    

static void constructMatrix()
{
    char ch = 'A';

    for(int i=0;i<26;i++)
    {
        
        for (int j=0; j<26;j++ ) {

            char curr = (char)(ch+j);
            if(curr>'Z')
            {
                curr = (char)(curr-'Z'+'A'-1);
            }
            mat[i][j] = curr;
            
        }
        ch = (char)(ch+1);
    }
    
}





static void printMatrix()
{
    
    System.out.println("\nVigener Table: \n");
    for(int i=0;i<26;i++)
    {
        for(int j=0;j<26;j++)
        {
            System.out.print(mat[i][j]+" ");
        }
        System.out.println("\n");
           
    }
}
    
static String makeKey(String given_key,int plain_text_len)
{
    
    String key = "";
    int times = plain_text_len/given_key.length();
    int extra = plain_text_len%given_key.length();
    for(int i=0;i<times;i++)
    {
        key = key + given_key;
    }
    for(int i=0;i<extra;i++)
    {
        key = key + given_key.charAt(i);
    }
    return key;
}
    
static String encrypt(String plaintext,String new_key)
{
    String encrypted_text = "";

    for(int i=0;i<plaintext.length();i++)
    {
        char ch;
        int r = new_key.charAt(i)-'A';
        int c = plaintext.charAt(i)-'A';
        ch = mat[r][c];
        encrypted_text = encrypted_text + ch;
    }
    
    System.out.println("Encrypted : "+encrypted_text);
    return encrypted_text;
}

static void decrypt(String ciphertext, String key)
{
    String plaintext = "";

    int row=0;
    int col=0;
    for(int i=0;i<ciphertext.length();i++)
    {
        row = key.charAt(i)-'A';
        char ch;
        ch = ciphertext.charAt(i);
        for(int j=0;j<26;j++)
        {
            if(ch==mat[row][j])
            {
                col = j;
                break;
            }
        }
        plaintext = plaintext + (char)(col+'A');
    }
    
    
    
    
    System.out.println("\n Decrypted text : "+ plaintext);
}


public static void main(String[] args) {
        
        
        int choice;
        
        Scanner scan = new Scanner(System.in);
        scan.setDelimiter("\n");
        Scanner reader = new Scanner(System.in);
        
        String plaintext = "";
        String cipher_text = "";
        String key = "";
        String new_key = "";
        
        do{
            System.out.println("\n1. Enter plain text");
            System.out.println("2. Enter key text");
            System.out.println("3. Show vigenere table");
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
                    break;
                    
                case 2:
                    System.out.println("Enter Key: ");
                    key = scan.next();
                    break;
                    
                case 3:
                    Vigenere.constructMatrix();
                    Vigenere.printMatrix();
                    break;
                    
                case 4:
                    new_key =  Vigenere.makeKey(key,plaintext.length());
                    System.out.println("Made key is : "+ new_key);
                    cipher_text = Vigenere.encrypt(plaintext,new_key);
                    break;
                  
                case 5:
                    Vigenere.decrypt(cipher_text, new_key);
                    break;
                default:
                    System.out.println("\nEnter valid choice");
                    choice = 9;
            }

        
        
        }while(choice!=6);
        
   
        
    }
    
}
