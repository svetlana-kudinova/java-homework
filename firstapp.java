public class FirstApp {


    public static void main(String[] args) {
        printThreeWords();
        checkSumSign(5, 5);
        printColor(0);
        CompareNumbers(6, 8);
    }
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    public static void checkSumSign(int a, int b) {
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    public static void printColor(int c) {
        if (c < 0) {
            System.out.println("Красный");
    } 
        else if (c > 0 && c < 100) {
            System.out.println("Желтый");
    } 
        else if (c > 100) {
            System.out.println("Зеленый");
}
        else {
            System.out.println("Ошибка вычислений");
    }
    }
    public static void CompareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }



    }
    
}
