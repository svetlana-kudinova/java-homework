
public class Solution3 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int number : array)
            if (number % 2 == 0)
                System.out.println(number);
    }
}