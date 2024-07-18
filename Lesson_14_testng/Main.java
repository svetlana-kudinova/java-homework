public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("0! =  " + Factorial.compute(0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("1! =  " + Factorial.compute(1));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("5! =  " + Factorial.compute(5));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("-1! =  " + Factorial.compute(-1));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}