
package cyberlab;
import java.util.*; 
import java.util.Scanner;

/**
 *
 * @author ehtesham
 */
public class RowColTransposition {
    
    static int size = 0 ;
    static int rows = 0;
    static HashMap<Integer, Integer> targets = new HashMap<Integer, Integer>();
    static ArrayList<Integer> keyArray = new ArrayList<Integer>(); 
    public static void printElements(ArrayList<Integer> alist) 
    { 
        for (int i = 0; i < alist.size(); i++) { 
            System.out.print(alist.get(i) + " "); 
        } 
    } 
    
   
    
    static String encrypt (String plaintext,int key){
        String cipher = "";
        int n = key;
        int r;
        
        while(n!=0)
        {
            
            r = n%10;
            n = n/10;
            keyArray.add(new Integer(r));
            size++;
            
        }
        rows = (int)Math.ceil((float)plaintext.length()/(float)size);
        System.out.println("\nNo. of rows = :"+rows);
        System.out.println("No. of cols = :"+size);
        
        System.out.println("\nKey: ");
        Collections.reverse(keyArray); 
        System.out.print("\nElements after reversing: "); 
        printElements(keyArray); 
        
        
        char[][] mat = new char [rows][size];
        
        
       
        int k = 0;
        int flag = 0;
        for(int i=0;i<rows;i++)
        {
            if(flag==1)
                break;
            for(int j=0;j<size;j++)
            {
                if(k<plaintext.length())
                    mat[i][j] = plaintext.charAt(k++);
                else
                    mat[i][j] = '-';
            }
                
        }
        
        
        
        
        
        // Add keys and values (Country, City)
        for(int i=0;i<size;i++)
        {
            targets.put(keyArray.get(i),new Integer(i));
        
        }
        
        System.out.println("Hashmap: +");
        System.out.println(targets);
        Collections.sort(keyArray); 
        
        
       System.out.println("\nMatrix generated: ");
         
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
                
        }
        
        //Encryption code
        
        for(int i=0;i<size;i++)
        {
            int curr =  keyArray.get(i);
            int req = targets.get(curr);
            for(int j=0;j<rows;j++)
            {
                cipher = cipher + mat[j][req]; 
            }
        }
        
        
        
        
        
        return cipher;
        
    }
    
    
    static String decrypt(String cipher)
    {
        String plaintext = "";
        
        System.out.println("\nNo. of rows = :"+rows);
        System.out.println("No. of cols = :"+size);
        char[][] mat = new char [rows][size];
        System.out.println("Cipher is : "+cipher);
        int k = 0;
        for(int i=0;i<size;i++)
        {
            int curr = keyArray.get(i);
            int column = targets.get(curr);
            
            for(int j=0;j<rows;j++)
            {
                if(cipher.charAt(k)=='-')
                    k++;
                else
                    mat[j][column] = cipher.charAt(k++);
            }
        }
        
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<size;j++)
            {
                plaintext = plaintext + mat[i][j]; 
            }
        }
        
        
        return plaintext;
        
    }
    
    
    
    
    public static void main(String[] args) {
        
        
        int choice;
        
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        String plaintext = "";
        String cipher_text = "";
        String decipher_text = "";
        int key = 0 ;
        
        do{
            System.out.println("\n1. Enter plain text");
            System.out.println("2. Enter key text");
            
            System.out.println("3. Encrypt");
            System.out.println("4. Decrypt");
            System.out.println("5. Exit");
            System.out.println("\nEnter choice: ");
            choice = scan.nextInt();
        
            
            switch(choice)
            {
                
                case 1:
                    System.out.println("Enter plaintext: ");
                    plaintext = scan.next();
                    break;
                    
                case 2:
                    System.out.println("Enter Key: ");
                    key = scan.nextInt();
                    
                    break;
                    
                case 3:
                    cipher_text = RowColTransposition.encrypt(plaintext,key);
                    System.out.println("\nCipher text : "+ cipher_text);
                    break;
                    
                case 4:
                    decipher_text = RowColTransposition.decrypt(cipher_text);
                    System.out.println("\nDecrypted text : "+ decipher_text);
                    break;
                  
                
                default:
                    System.out.println("\nExiting");
                    choice = 6;
            }

        
        
        }while(choice!=6);
        
   
        
    }
    
    
}
