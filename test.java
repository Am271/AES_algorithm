import java.math.BigInteger;
import java.io.*;
class Test {
    public static String toHex(String arg) {
        try {
            byte bytes[] = arg.getBytes("UTF-8");
            return String.format("%-32x", new BigInteger(1, bytes)).replace(' ', '0');
        }
        catch(UnsupportedEncodingException g) {
            return("Caught exception!" + g);
        }
}
    public static void main(String args[]) {
        //System.out.println(toHex(args[0]));
        byte[] bytes = new byte[32];
        try {
            bytes = args[0].getBytes("UTF-8");
        }
        catch(UnsupportedEncodingException x) {
            System.out.println("Exception caught!");
        }
        for(int i=0; i < bytes.length; i++) {
            System.out.print(String.format("%x ", bytes[i]));
        }
        System.out.println();
    }
}
