public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Петров", "+79013524154");
        phoneBook.add("Сидоров", "+79026541232");
        phoneBook.add("Васютин", "+79039632514");
        phoneBook.add("Ковалев", "+79018745265");
        phoneBook.add("Бирилов", "+79029874585");
        phoneBook.add("Петров", "+79039632514");
        phoneBook.add("Сидоров", "+79013524154");

        System.out.println("1. " + phoneBook.getFormattedNumbers("Петров"));
        System.out.println("2. " + phoneBook.getFormattedNumbers("Сидоров"));
        System.out.println("3. " + phoneBook.getFormattedNumbers("Васютин"));
        System.out.println("4. " + phoneBook.getFormattedNumbers("Ковалев"));
        System.out.println("5. " + phoneBook.getFormattedNumbers("Бирилов"));
        System.out.println("6. " + phoneBook.getFormattedNumbers("Иванов"));
    }
}