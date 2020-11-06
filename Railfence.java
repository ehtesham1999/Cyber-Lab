
import java.util.Scanner;

public class Railfence {
    
    
    
    static String encrypt(String plaintext,int key)
    {
        String cipher_text = "";
        System.out.println("plaintext :"+plaintext);
        char[][] mat = new char [key][plaintext.length()];

        for(int i=0;i<key;i++)
        {
            for (int j=0; j<plaintext.length();j++ ) {
                mat[i][j] = '*';
                
            }
        }

        boolean dir = false;
        int row = 0;
        for(int i=0;i<plaintext.length();i++)
        {
            if(row==0 || row==key-1)
                dir = !dir;

            mat[row][i] = plaintext.charAt(i);

            if(dir)
                row++;
            else
                row--;
        }   

        for(int i=0;i<key;i++)
        {
            for (int j=0; j<plaintext.length();j++ ) {
                System.out.print(mat[i][j]+" ");
                
            }System.out.println();
        }   


        for(int i=0;i<key;i++)
        {
            for (int j=0; j<plaintext.length();j++ ){
                if(mat[i][j]!='*'){
                    cipher_text = cipher_text + mat[i][j];
                    }
            }     

       }   
        
       System.out.println("Encrypted: "+cipher_text);
       return cipher_text;
    }
    
    
    
    
    static void decrypt(String cipher,int key){
    
        String plaintext = "";
        char[][] mat = new char [key][cipher.length()];
     
        String result = "";
        
        for(int i=0;i<key;i++)
        {
            for (int j=0; j<cipher.length();j++ ) {
                mat[i][j] = '#';   
                
            }
        }  


        boolean dir = false;
        int row = 0;
        for(int i=0;i<cipher.length();i++)
        {
            if(row==0 || row==key-1)
                dir = !dir;

            mat[row][i] = '*';

            if(dir)
                row++;
            else
                row--;
        }  
        int k=0;
        for(int i=0;i<key;i++)
        {
            for (int j=0; j<cipher.length();j++ ) {
                if(mat[i][j]=='*')
                {
                    mat[i][j] = cipher.charAt(k++);
                }   
                
            }
        }   

        System.out.println("Decryption : ");

        for(int i=0;i<key;i++)
        {
            for (int j=0; j<cipher.length();j++ ) {
                System.out.print(mat[i][j]+" ");
                
            }System.out.println();
        }   


        dir = false;
        row = 0;

        for(int i=0;i<cipher.length();i++)
        {
            if(row==0 || row==key-1)
                dir = !dir;

            result = result + mat[row][i];

            if(dir)
                row++;
            else
                row--;
        }  




        System.out.println("Decrypted text  : "+result);
        
        
    }
  
    
    
    public static void main(String[] args) {
        
        
        int choice;
        
        Scanner scan = new Scanner(System.in);
        Scanner reader = new Scanner(System.in);
        
        scan.useDelimiter("\n");
            
        String plaintext = "";
        String cipher_text = "";
       
        int key = 0 ;
        
        do{
            System.out.println("\n1. Enter plain text");
            System.out.println("2. Enter key text");
            
            System.out.println("3. Encrypt");
            System.out.println("4. Decrypt");
            System.out.println("5. Exit");
            System.out.println("\nEnter choice: ");
            choice = reader.nextInt();
            
            switch(choice)
            {
                
                case 1:
                    System.out.println("Enter plaintext: ");
                    plaintext = scan.next();
                    plaintext = plaintext.substring(0,plaintext.length()-1);
                    System.out.println("len: "+plaintext.length());
                    
                    break;
                    
                case 2:
                    System.out.println("Enter Key: ");
                    key = reader.nextInt();
                    break;
                    
                case 3:
                    cipher_text = Railfence.encrypt(plaintext,key);
                    break;
                    
                case 4:
                    Railfence.decrypt(cipher_text,key);
                    break;
                  
                
                default:
                    System.out.println("\nExiting");
                    choice = 6;
            }

        
        
        }while(choice!=6);
        
   
        
    }
    
}
