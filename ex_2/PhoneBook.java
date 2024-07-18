import java.util.*;

public class PhoneBook {
    private final Map<String, String> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        phoneBook.put(phoneNumber, surname);
    }

    public List<String> getNumbers(String surname) {
        List<String> numbers = new ArrayList<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getValue().equals(surname)) {
                numbers.add(entry.getKey());
            }
        }
        return numbers;
    }

    public String getFormattedNumbers(String surname) {
        List<String> numbers = getNumbers(surname);
        if (numbers.isEmpty()) {
            return "Нет номеров для фамилии: " + surname;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Номера телефонов для ").append(surname).append(": ");
        boolean firstNumber = true;
        for (String number : numbers) {
            if (!firstNumber) {
                sb.append(", ");
            }
            firstNumber = false;
            sb.append(number);
        }
        return sb.toString();
    }
}