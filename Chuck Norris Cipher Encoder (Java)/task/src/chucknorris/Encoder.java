package chucknorris;

public class Encoder {
    public static String encode(String s) {
        StringBuilder binaryString = new StringBuilder();
        for (char c : s.toCharArray()) {
            String binary = String.format("%7s", Integer.toBinaryString(c)).replace(' ', '0');
            binaryString.append(binary);
        }

        return encodeBinary(binaryString.toString());
    }

    private static String encodeBinary(String binary) {
        StringBuilder encodedBinary = new StringBuilder();
        char lastChar = binary.charAt(0);
        int count = 1;

        for (int i = 1; i < binary.length(); i++) {
            if (binary.charAt(i) == lastChar) {
                count++;
            } else {
                encodedBinary.append(lastChar == '1' ? "0 " : "00 ");
                encodedBinary.append("0".repeat(count)).append(" ");
                lastChar = binary.charAt(i);
                count = 1;
            }
        }

        // Check if last sequence is 1 or 0, and append accordingly
        if (lastChar == '1') {
            encodedBinary.append("0 ");
        } else {
            encodedBinary.append("00 ");
        }
        encodedBinary.append("0".repeat(count));

        return encodedBinary.toString();
    }
}
