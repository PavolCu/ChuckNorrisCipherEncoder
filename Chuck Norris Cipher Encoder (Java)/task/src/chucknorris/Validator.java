package chucknorris;

public class Validator {
    public static boolean isValid(String encoded) {
        String[] parts = encoded.split(" ");
        if (parts.length % 2 != 0) return false;

        for (int i = 0; i < parts.length; i++) {
            if (i % 2 == 0 && !("0".equals(parts[i]) || "00".equals(parts[i]))) return false;
            if (!parts[i].matches("[0 ]+")) return false;
        }

        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < parts.length; i += 2) {
            binary.append(parts[i].equals("0") ? parts[i + 1].replace('0', '1') : parts[i + 1]);
        }

        return binary.length() % 7 == 0;
    }
}