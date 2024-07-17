public class Main {
    public static void main(String[] args) {
        String[] words = {"red", "blue", "yellow", "green", "blue", "orange", "yellow", "green", "blue", "orange", "yellow", "purple", "pink", "red"};
        WordArray wordArray = new WordArray(words);

        System.out.println("Уникальные слова: ");
        System.out.println(wordArray.getFormattedUniqueWords());

        System.out.println("Подсчет слов: ");
        System.out.println(wordArray.getFormattedWordCounts());
    }
}
