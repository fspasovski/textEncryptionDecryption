import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextDecrypter {
    static final String ENCRYPTED_TEXT = "/home/fspasovski/kriptografijaLabs/lab01/odPepi/encrypted.txt";

    public static void main(String[] args) throws IOException {
        start();
    }

    static void start() throws IOException {
        List<TextState> textStates = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File(ENCRYPTED_TEXT)));
        String encryptedText = br.readLine();
        textStates.add(new TextState(encryptedText, encryptedText, "", ""));
        System.out.println("Initial state: " + encryptedText);
        br.close();
        br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            if (textStates.size() > 0)
                encryptedText = textStates.get(textStates.size() - 1).getTextAfterChange();
            System.out.println("Replace text: ");
            String replaceText = br.readLine();
            if (replaceText.equals("stop")) {
                break;
            } else if (replaceText.equals("re")) {
                // return to the previous state
                if (textStates.size() > 1) {
                    textStates.remove(textStates.size() - 1);
                    encryptedText = textStates.get(textStates.size() - 1).getTextAfterChange();
                }
            } else {
                System.out.println("Replace with: ");
                String replaceWith = br.readLine();
                String beforeState = encryptedText;

                encryptedText = encryptedText.replaceAll(replaceText, replaceWith.toUpperCase());

                TextState ts = new TextState(beforeState, encryptedText, replaceText, replaceWith);
                textStates.add(ts);

                System.out.println(ts.toString());
            }
        }

        System.out.println("Printing text states ...");
        System.out.println(textStates);

    }
}
