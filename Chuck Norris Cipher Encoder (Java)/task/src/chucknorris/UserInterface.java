package chucknorris;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private final Encoder encoder;
    private final Decoder decoder;
    private final Validator validator;

    public UserInterface() {
        scanner = new Scanner(System.in);
        encoder = new Encoder();
        decoder = new Decoder();
        validator = new Validator();
    }

    public void start() {
        System.out.println("Please input operation (encode/decode/exit):");
        while (true) {
            String operation = scanner.nextLine().trim();

            switch (operation) {
                case "encode":
                    handleEncoding();
                    break;
                case "decode":
                    handleDecoding();
                    break;
                case "exit":
                    handleExit();
                    return;
                default:
                    System.out.println("There is no '" + operation + "' operation");
                    break;
            }
            System.out.println("\nPlease input operation (encode/decode/exit):");
        }
    }

    private void handleEncoding() {
        System.out.println("Input string:");
        String input = scanner.nextLine();
        System.out.println("Encoded string:" + "\n" + encoder.encode(input));
    }

    private void handleDecoding() {
        System.out.println("Input encoded string:");
        String encodedInput = scanner.nextLine();
        if (validator.isValid(encodedInput)) {
            System.out.print("Decoded string:" + "\n" + decoder.decode(encodedInput));
        } else {
            System.out.println("Encoded string is not valid.\n");
        }
    }

    private void handleExit() {
        System.out.println("Bye!");
        scanner.close();
    }
}


