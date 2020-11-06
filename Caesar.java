


import java.util.Scanner;


public class Caesar {

    
    String encrypt(String inp,int key)
    {
        String cipher = "";

        for(int i=0;i<inp.length();i++)
        {

            char ch = inp.charAt(i);
            if(ch>='a' && ch<='z')
            {
                ch = (char)(ch + key);
                if(ch>'z')
                    ch = (char)(ch-'z'+'a'-1);

            }
            else if(ch>='A' && ch<='Z')
            {
                ch = (char)(ch + key);
                if(ch>'Z')
                    ch = (char)(ch-'X'+'A'-1);
            }

            cipher = cipher +  ch;
               
        }
           
            
        
        
        return cipher;
    }
    
    String decrypt(String inp,int key)
    {
       String decipher = "";

       for(int i=0;i<inp.length();i++)
        {

            char ch = inp.charAt(i);
            if(ch>='a' && ch<='z')
            {
                ch = (char)(ch - key);
                if(ch<'a')
                    ch = (char)(ch+'z'-'a'+1);

            }
            else if(ch>='A' && ch<='Z')
            {
                ch = (char)(ch - key);
                if(ch<'A')
                    ch = (char)(ch+'Z'-'A'+1);
            }

            decipher = decipher +  ch;
               
        }


        return decipher;
    }
    
    
    public static void main(String[] args) {
        
        String inp = "";
        Scanner scan = new Scanner(System.in);
        int key = 0;
        int choice=0;
        String encrypted_text = "";
        
        Caesar cb = new Caesar();
        System.out.println("1. Read plaintext");
        System.out.println("2. Read Key");
        System.out.println("3. Encrypt");
        System.out.println("4. Decrypt\n");
        System.out.println("5. Exit\n");
        
        do
        {
        System.out.println("\nEnter Choice: ");
        choice = scan.nextInt();

        switch(choice)
        {
            case 1: System.out.println("\nEnter Plain Text:");
            inp = scan.next();

            break;
            
            case 2:System.out.println("\nEnter Key:");
            key = scan.nextInt();
            break;
            
            case 3:
                encrypted_text = cb.encrypt(inp,key);
            System.out.println("\nEncypted Text: "+encrypted_text);
            break;
            
            case 4:System.out.println("\nDecryption: "+cb.decrypt(encrypted_text,key));
            break;
            
            case 5: System.out.println("\n Thanks for using");
            default: System.out.println("\n Enter a valid choice");
                
                
        }
        
        
        }while(choice!=5);
        

    }
    
}
