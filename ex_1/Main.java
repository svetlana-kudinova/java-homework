public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        String[] words = new String[]{"красный", "синий", "желтый", "зеленый", "синий", "оранжевый", "желтый", "зеленый", "синий", "оранжевый", "желтый", "фиолетовый", "розовый", "красный"};
        WordArray wordArray = new WordArray(words);
        System.out.println("Уникальные слова: ");
        System.out.println(wordArray.getFormattedUniqueWords());
        System.out.println("Подсчет слов: ");
        System.out.println(wordArray.getFormattedWordCounts());
    }
}