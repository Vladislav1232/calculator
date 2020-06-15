public class Calculator {

    public int calculate(int firstNumber, int secondNumber,
                         String operator) {
        int result = 0;

        switch (operator) {
            case "+":
                result = addition(firstNumber, secondNumber);
                break;
            case "-":
                result = subtraction(firstNumber, secondNumber);
                break;
            case "*":
                result = multiplication(firstNumber, secondNumber);
                break;
            case "/":
                result = division(firstNumber, secondNumber);
                break;
        }

        return result;
    }

    private int addition(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    private int subtraction(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    private int multiplication(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    private int division(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }
}
