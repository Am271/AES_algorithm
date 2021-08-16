import java.io.*;

class AES {
    static String input(String type) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(isr);
        System.out.print("Enter " + type + ": ");
        String text = buf.readLine();
        return(text);
    }
    public static void main(String args[]) throws IOException {
        String plain_text, key_text;
        plain_text = input("plaintext");
        key_text = input("key");
    }
}
