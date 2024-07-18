import java.util.*;

public class WordArray {
    private final String[] words;

    public WordArray(String[] words) {
        this.words = words;
    }

    private Set<String> getUniqueWords() {
        return new LinkedHashSet<>(Arrays.asList(words));
    }

    private Map<String, Integer> getWordCount() {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

    public String getFormattedUniqueWords() {
        Set<String> uniqueWords = getUniqueWords();
        StringBuilder sb = new StringBuilder();
        for (String word : uniqueWords) {
            sb.append(word).append("\n");
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public String getFormattedWordCounts() {
        Map<String, Integer> wordCount = getWordCount();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}