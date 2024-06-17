class CustomException extends Exception {
    CustomException(String message) {
        super(message);
    }
}

class MyArrayDataException extends CustomException {

    MyArrayDataException(int row, int col) {
        super(String.format("Неверные данные находятся в ячейке [%d, %d]", row, col));
    }
}

class MyArraySizeException extends CustomException {

    MyArraySizeException() {
        super("Размерность массива должна быть [4 x 4]");
    }
}

class Converter {
    static int strConverter(String[][] strArray)
            throws MyArraySizeException, MyArrayDataException {

        int sum = 0;

        if (4 != strArray.length) throw new MyArraySizeException();
        for (int i = 0; i < strArray.length; i++) {
            if (4 != strArray[i].length) throw new MyArraySizeException();
            for (int j = 0; j < strArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(strArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return sum;
    }
}

public class Lesson12 {

    public static void main(String[] args) {


        String[][] matrix = {
                {"8", "9", "2", "3"},
                {"6", "5", "5", "7"},
                {"2", "0", "9", "6"},
                {"1", "9", "4", "6"}
        };

        try {
            System.out.println("Сумма всех элементов массива равна " + Converter.strConverter(matrix));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }

    }
}
