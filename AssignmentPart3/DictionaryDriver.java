/*

    Jason Gill
    21304092

*/

public class DictionaryDriver {
    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Incorrect arguments - filepath, shortest, longest required");
            return;
        }

        Dictionary dictionary = new Dictionary(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));


        System.out.println("--- PRINTING LIST ---");
        System.out.println(dictionary);

        System.out.println();

        String word = "safe";
        System.out.printf("Trying to add '%s' to dictionary...\n", word);
        System.out.println(dictionary.add(word) ? "Word added successfully" : "Word not added (may not be allowed length or may already be in list)" );

        if (dictionary.inDictionary(word)) {
            System.out.printf("'%s' is in dictionary\n", word);
        } else {
            System.out.printf("'%s' is not in dictionary\n", word);
        }
        System.out.println();

        String expectedResult = "[ART, BUT, RAY, SEA, SUN]";
        if (dictionary.toString().equals(expectedResult)) {
            System.out.println("TEST: The list returned IS the same as if you used the Sample.csv from Sulis with min length 0 and max length 3.");
        } else {
            System.out.println("TEST: The list returned is NOT the same as if you used the Sample.csv from Sulis with min length 0 and max length 3.");
        }
        System.out.println();

        System.out.println("--- 5 RANDOMLY SELECTED WORDS FROM LIST ---");
        for (int i = 0; i < 5; i++) {
            System.out.println(dictionary.nextWord());
        }

    }
}
