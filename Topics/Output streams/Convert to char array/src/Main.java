import java.io.CharArrayWriter;
import java.io.IOException;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        // implement the method
        CharArrayWriter caw = new CharArrayWriter();

        for (String word : words) {
            caw.write(word, 0, word.length());
        }
        return caw.toCharArray();
    }
}

class LetterPrinter {
    public  void write(char letter) {
    }

    public void writeWords(String[] words) throws IOException {
        char[] letters = Converter.convert(words);
        for (char letter : letters) {
            this.write(letter);
        }
    }
}