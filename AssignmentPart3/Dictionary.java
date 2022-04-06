/*

    Jason Gill
    21304092

*/


import java.io.*;
import java.util.*;

public class Dictionary {
	private ArrayList<String> words = new ArrayList<>();
    private int shortest = 0;
    private int longest = 0;

	public Dictionary(String filepath, int shortest, int longest) {
        this.shortest = shortest;
        this.longest = longest;

        try {
            File file = new File(filepath);
            Scanner dataSource = new Scanner(file);
            // go through each line, trim it, split on commas, and then call add method with for each word
            // the add method checks prevents duplicates, checks length & converts to uppercase
            while(dataSource.hasNextLine()) {
                String line = dataSource.nextLine();
                String[] tokens = line.trim().split(",");
                for(String token: tokens) {
                    add(token);
                }
            }
            dataSource.close();
        }
        catch(IOException e) {
        System.out.println("Error opening file.");
        }
	}

    public boolean add(String word) {
        word = word.toUpperCase().trim();
        int len = word.length();
        // check word is not already in dictionary, is at least of min length and not greater than max length & is not just an empty string
        if (!inDictionary(word) && len <= longest && len >= shortest && len > 0) {
            /* 
                binary search returns index the word would be at if it were in list.

                no need to use Collections.sort(). only this method adds words to list,
                and it adds them according to where they should be alphabetically, so list is
                therefore always ordered alphabetically.
            */
            int index = Collections.binarySearch(words, word);
            // index is returned in form (-(insertion point) – 1) so must adjust
            words.add(Math.abs(index) - 1, word);
            return true;
        }
        return false;
    }

    public String nextWord() {
        return (words.size() > 0) ? words.get((int) (Math.random() * words.size())) : "";
    }

    public boolean inDictionary(String word) {
        return words.contains(word.trim().toUpperCase());
    }

    public String toString() {
        return words.toString();
    }

}
