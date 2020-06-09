package string;

/**
 * 151. Reverse Words in a String
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 *
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        boolean hasBlank = true;
        int start = -1;
        int blankCount = 0;
        StringBuilder wordBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; --i) {
            char c = s.charAt(i);
            if (c == ' ') {
                ++blankCount;
                if (hasBlank) {
                    continue;
                } else {
                    hasBlank = true;
                    if (wordBuilder.length() > 0) {
                        builder.append(wordBuilder.reverse());
                        wordBuilder = new StringBuilder();
                    }
                    builder.append(c);
                }
            } else {
                blankCount = 0;
                hasBlank = false;
                wordBuilder.append(c);

            }
        }
        if (wordBuilder.length() > 0) {
            builder.append(wordBuilder.reverse());
        }
        if (builder.length() == 0) {
            return builder.toString();
        }
        return blankCount > 0 ? builder.substring(0, builder.length() - 1) : builder.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        System.out.println(reverseWordsInAString.reverseWords(" "));
    }

}
