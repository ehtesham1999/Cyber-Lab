import java.util.Scanner;


public class Hill {
    static  int n;
    static final int N = 3; 
    static int [][] keymatrix = new int[10][10];
    static int [][] resultmatrix = new int[10][10];
    static int [][] deresultmatrix = new int[10][10];
    static int [][] inv = new int [N][N];
    
    
    static String cipher_text = "";
    static String decipher_text = "";
    
    static void display(int A[][]) 
    { 
           
            for (int i = 0; i < N; i++) 
            { 
                    for (int j = 0; j < N; j++) 
                            System.out.print(A[i][j]+ " "); 
                    System.out.println(); 
            } 
    } 
    
    
    static void constructMatrix(String key)
    {
        
        if(key.length()!=N*N)
            {System.out.println("Key length must be N*N of block size");
            return;
            }

        
        int k=0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                char curr = key.charAt(k++);
                keymatrix[i][j] = curr-'A';
            }
        }

        display(keymatrix);
        

    }
    
    static void doEncrypt(String curr_text)
    {
        int [][] plainmatrix = new int[10][10];

        for(int i=0;i<curr_text.length();i++)
        {
            plainmatrix[i][0] = curr_text.charAt(i)-'A';
        }
        System.out.println("Plain matrix");
        for(int i=0;i<curr_text.length();i++)
        {
            System.out.print(plainmatrix[i][0]+" ");
            
        }

        System.out.println(" Product matrix: ");
        int curr = 0 ;
        for(int i=0;i<N;i++)
        {
            
                curr = 0;
                for(int k=0;k<N;k++)
                {
                    curr = curr + plainmatrix[k][0]*keymatrix[i][k];
                }
                System.out.println(curr%26);
                cipher_text = cipher_text + (char)((curr)%26+'A');
            
        }

        System.out.println("cipher text : "+cipher_text);


    
        
    }
    static void encrypt(String plaintext)
    {
        int nofblocks = plaintext.length()/N;
        if(plaintext.length()%N>0)
            nofblocks+=1;

        doEncrypt(plaintext);


        // for(int i=0;i<nofblocks;i++)
        // {
        //     doEncrypt(plaintext.substring(N*i,N*i+N));
        // }


    }
    
    
    
        

    

    
    static void doDecrypt(String curr_text)
    {
        int [][] plainmatrix = new int[10][10];
        
        
        
    
    }
    
    
    
    
    
    
        
    
    
    
    
    
    public static void main(String[] args) {
        
        
        int choice;
        
        Scanner scan = new Scanner(System.in);
        //scan.useDelimiter("\n");
        String plaintext = "";
        String key = "";
        String new_key = "";
        
        
        do{
            System.out.println("\n1. Enter plain text");
            System.out.println("2. Enter key text");
            System.out.println("3. Create Matrix");
            System.out.println("4. Encrypt");
            System.out.println("6. Exit");
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
                    key = scan.next();
                    break;
                    
                case 3:
                    Hill.constructMatrix(key);
                    break;
                    
                case 4:
                    
                    Hill.encrypt(plaintext);
                    System.out.println("\nEncrypted text: "+cipher_text);
                    break;
                  
                
                
            }

        
        
        }while(choice!=6);
        
   
        
    }
    
}
