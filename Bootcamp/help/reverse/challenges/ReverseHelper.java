package help.reverse.challenges;
import java.lang.StringBuilder;
import java.nio.charset.StandardCharsets;

public class ReverseHelper {
    static void main() {
        System.out.println(bam("ERNYYL"));
    }

    public static String bam(String s) {
        String out = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'm') {
                c = (char) (c + '\r');
            } else if (c >= 'A' && c <= 'M') {
                c = (char) (c + '\r');
            } else if (c >= 'n' && c <= 'z') {
                c = (char) (c - '\r');
            } else if (c >= 'N' && c <= 'Z') {
                c = (char) (c - '\r');
            }
            out = out + c;
        }
        return out;
    }

    public static String getR() {
        String r = "";
        boolean upper = true;
        for (int i = 0; i < 26; i++) {
            r = upper ? r + "[A-Z_]" : r + "[a-z_]";
            upper = !upper;
        }
        return r;
    }

    public static String toHexString(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            String hex = String.format("%02x", b);
            result.append(hex);
        }
        return result.toString();
    }

    public static String hexToAscii(String hex) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < hex.length(); i += 2) {
            /* 2 bytes = 1 hex character */
            String hexPart = hex.substring(i, i + 2);
            /* Convert hex to decimal */
            int decimal = Integer.parseInt(hexPart, 16);
            char character = (char) decimal;
            result.append(character);
        }
        return result.toString();
    }

    public static byte[] hexToBytes(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            String part = hex.substring(i, i + 2);
            data[i / 2] = (byte) Integer.parseInt(part, 16);
        }
        return data;
    }

    public static String xorDecode(String hex, int key){
        hex = hex.replaceAll("\\s+", "");

        byte[] bytes = new byte[hex.length() / 2];
        //System.out.print("Decoded bytes: ");
        for (int i = 0; i < hex.length(); i += 2) {
            String part = hex.substring(i, i + 2);
            int val = Integer.parseInt(part, 16);
            byte decodedByte = (byte) (val ^ key);
            bytes[i / 2] = decodedByte;
            //System.out.print(decodedByte + " ");
        }
        System.out.println();

        return new String(bytes, StandardCharsets.US_ASCII);
    }

    public static String xorEncode(String plain, int key) {
        StringBuilder sb = new StringBuilder();
        for (char c : plain.toCharArray()) {
            sb.append(String.format("%02x", ((int) c) ^ key));
        }
        return sb.toString();
    }
}
