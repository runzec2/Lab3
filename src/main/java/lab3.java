
    import java.io.IOException;
    import java.net.URL;
    import java.util.Scanner;
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
public class lab3 {

    public static String urlToString(final String url) {
    Scanner urlScanner;
    try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
    return "";
        }
    String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
    return contents;

    }

    public static int countWords(String s){

        int wordCount = 0;

        boolean word = false;
        int endOfLine = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            // if the char is a letter, word = true.
            if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
                word = true;
                // if char isn't a letter and there have been letters before,
                // counter goes up.
            } else if (!Character.isLetter(s.charAt(i)) && word) {
                wordCount++;
                word = false;
                // last word of String; if it doesn't end with a non letter, it
                // wouldn't count without this.
            } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }

    public static int countWord (String word, String doc) {

        int count  = 0;
        int word_length = word.length();
        int current_index = 0;
        int end_doc = doc.length();
        while ((current_index + word_length) < end_doc) {
            String current_word = doc.substring(current_index,current_index + word_length);
            current_word = current_word.toLowerCase();
            if (current_word.equals(word)) {
                count ++;
            }
            current_index++;
        }


        return count;

    }

    public static void main (String[]args) {
        String web  = urlToString("http://erdani.com/tdpl/hamlet.txt");
        int numOfWords =countWords(web);
        System.out.println(numOfWords);
        int count = countWord("prince", web);
        System.out.println(count);

    }
}
