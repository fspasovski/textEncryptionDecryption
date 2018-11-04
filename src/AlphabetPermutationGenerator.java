import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlphabetPermutationGenerator {
    public static final String ALPHABET = "абвгдѓежзѕијклљмнњопрстќуфхцчџш";

    public static void main(String[] args) {
        System.out.println(generate());
    }

    public static Map<Character, Character> generate() {
        Random random = new Random();
        TreeMap<Character, Character> permutationMap = new TreeMap<>(Comparator.comparingInt(ALPHABET::indexOf));
        List<Integer> indexList = IntStream.range(0, ALPHABET.length()).boxed().collect(Collectors.toList());

        IntStream.range(0, ALPHABET.length())
                .forEach(i -> {
                    int shuffledIndex = random.nextInt(indexList.size());
                    while(shuffledIndex == i && indexList.size() != 1) {
                        shuffledIndex = random.nextInt(indexList.size());
                    }

                    permutationMap.put(ALPHABET.charAt(i), ALPHABET.charAt(indexList.get(shuffledIndex)));
                    indexList.remove(shuffledIndex);
                });

        return permutationMap;
    }
}