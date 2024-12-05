public class Factorial {

    public static long compute(double n) {
        if (n < 0 || n != Math.floor(n)) {
            throw new IllegalArgumentException("Число не должно быть отрицательным");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }


    public static void main(String[] args) {
        Factorial calculator = new Factorial();
        System.out.println("Факториал 6: " + calculator.compute(6));
    }
}