import java.util.Arrays;
public class FirstApp {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign(5, 5);
        printColor(0);
        CompareNumbers(6, 8);
        SumNum(7, 5);
        PosNum(-6);
        NegNum(-6);
        LineNum("В траве сидел кузнечик ", 5);
        LeapYear(2012);
        ArrayRep();
        Array100();
        StatArray();
        SqArray(8);
        System.out.println(Arrays.toString(EndArray(8, 4)));
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
        if (c <= 0) {
            System.out.println("Красный");
    } 
        else if (c > 0 && c <= 100) {
            System.out.println("Желтый");
    } 
        else if (c > 100) {
            System.out.println("Зеленый");
    }
    }
    public static void CompareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        } 
        else {
            System.out.println("a < b");
        }
    }
    public static void SumNum(int d, int e) {
        if (d + e >= 10 && d + e < 20) {
             System.out.println("true");
            } 
        else {
             System.out.println("false");

    }
    
}
    public static void PosNum(int f) {
        if (f >= 0) {
         System.out.println("Положительное");
        } 
        else {
         System.out.println("Отрицательное");
        }
    }
    public static void NegNum(int g) {
        if (g < 0) {
         System.out.println("true");
        } 
        else {
         System.out.println("false");
        }
    }
    public static void LineNum(String h, int i) {
        for (int j = 0; j < i; j++) {
         System.out.println(h);

    }
    }
    public static void LeapYear(int k){
        if (!(k % 4 == 0) || ((k % 100 == 0) && !(k % 400 == 0))){
            System.out.println("false");
        }
        else {
         System.out.println("true");
        }
}
    public static void ArrayRep() {
        int[] l = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int m = 0; m < l.length; m++) {
            if (l[m] == 1) {
            l[m] = 0;
        } 
            else if (l[m] == 0) {
            l[m] = 1;
        }
    }
    System.out.println(Arrays.toString(l));

    }
    public static void Array100() {
        int[] n = new int[100];
        for (int o = 0; o < n.length; o++) {
            n[o] = o + 1;
        }
        System.out.println(Arrays.toString(n));
    }
    public static void StatArray() {
        int[] p = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int r = 0; r < p.length; r++) {
            if (p[r] < 6) {
                p[r] = p[r] * 2;
            }
        }
        System.out.println(Arrays.toString(p));
    }
    public static void SqArray(int t) {
        int[][] s = new int[t][t];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (i == j) {
                    s[i][j] = 1;
                }
                s[i][t - 1 - i] = 1;
            }
        }
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length; j++) {
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[] EndArray(int len, int initialValue) {
        int[] q = new int[len];
        for (int i = 0; i < q.length; i++) {
            q[i] = initialValue;
        }
        return q;
        
    }

}







