import java.util.Scanner;
public class Solution1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int a = console.nextInt();
        int b = console.nextInt();
            if (a > b) {
                System.out.println(a + " > " + b);
            }
            else if (a < b) {
                System.out.println(a + " < " + b);
            }
            else {
                System.out.println(a + " = " + b);
            }
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        }
}