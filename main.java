import java.io.*;

class AES {
    static String input(String type) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(isr);
        System.out.print("Enter " + type + ": ");
        String text = buf.readLine();
        return(text);
    }
    //slicing the given input into blocks of 128 binary bits 
    static void process_input(String inp){
        String a = "                ";
        inp = inp + a.substring(0,(16-(inp.length()%16)));
        int l = inp.length();
        for(int i = 0; i < l -16; i=i+16)
        {
            print_matrix(create_matrix(inp.substring(i,i+16)));
        }
    }
    //here the string input ha sto be 128 bits in binary 
    static int[][] create_matrix(String inp) {
        int text_matrix[][] = new int[4][4];
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                char ch = inp.charAt(i*4+j);
                text_matrix[i][j] = (int)ch;  
            }
        }
        return(text_matrix);
    }
    static void print_matrix(int arr[][]){
        for(int i = 0; i < 4; i++)
        {
            for(int j =0; j < 4; j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String args[]) throws IOException {
        String plain_text, key_text;
        plain_text = input("plaintext");
        // key_text = input("key");
        process_input(plain_text);
    }
}
