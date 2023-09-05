package chucknorris;

public class Decoder {
    public static String decode(String s) {
        String[] parts = s.split(" ");
        StringBuilder binary = new StringBuilder();

        for (int i = 0; i < parts.length; i += 2) {
            binary.append(parts[i].equals("0") ? parts[i + 1].replace('0', '1') : parts[i + 1]);
        }

        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 7) {
            int charCode = Integer.parseInt(binary.substring(i, i + 7), 2);
            decoded.append((char) charCode);
        }

        return decoded.toString();
    }
}
