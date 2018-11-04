import java.io.*;
import java.util.Map;
import java.util.stream.Collectors;

public class TextEncrypter {
    static final String SOURCE_FILE_PATH = "/home/fspasovski/kriptografijaLabs/lab01/plainText.txt";
    static final String DESTINATION_FILE_PATH = "/home/fspasovski/kriptografijaLabs/lab01/encryptedText.txt";
    static final String KEY = "/home/fspasovski/kriptografijaLabs/lab01/key.txt";

    public static void main(String[] args) throws IOException {
        encrypt(SOURCE_FILE_PATH);
    }

    static void encrypt(String sourceFilePath) throws IOException {
        Map<Character, Character> alphabetMap = AlphabetPermutationGenerator.generate();
        File plainTextFile = new File(sourceFilePath);

        if (plainTextFile.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(plainTextFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(DESTINATION_FILE_PATH)));
            String row;
            while ((row = br.readLine()) != null) {
                row = row.replaceAll("[0-9„“:—?.,! ]", "")
                        .toLowerCase()
                        .codePoints()
                        .mapToObj(c -> alphabetMap.get((char) c).toString())
                        .collect(Collectors.joining());

                bw.write(row);

                //testing encryption and decryption
                System.out.println("Encrypted: ");
                System.out.println(row);
                System.out.println("Original: ");
                System.out.println(row.codePoints()
                        .mapToObj(c -> {
                            for(Map.Entry<Character, Character> me: alphabetMap.entrySet()){
                                if(me.getValue().equals((char)c))
                                    return me.getKey().toString();
                            }
                            return null;
                        }).collect(Collectors.joining()));
            }

            br.close();
            bw.close();

            bw = new BufferedWriter(new FileWriter(new File(KEY)));
            bw.write(alphabetMap.toString());
            bw.close();

        } else System.out.println("File does not exist");
    }
}
