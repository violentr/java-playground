package help.reverse.challenges;
import java.lang.StringBuilder;

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
}
