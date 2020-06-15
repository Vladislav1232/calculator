import java.util.*;

public class Main {

    private static boolean roman;
    private static boolean arab;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Enter an expression, " + "or type \"/exit\":");

        while (true) {
            input = scanner.nextLine().toUpperCase().trim();
            if (input.equalsIgnoreCase("/exit")) {
                System.out.println("Bye!");
                break;
            }
            try {

                validateExpression(input);

                resetNumeralSystem();
                printResult(parseExpression(input));
            } catch (Exception ex) {
                System.out.println("Invalid expression: " + ex.getMessage());
            }
        }
    }

    private static void printResult(String[] expression) {
        Converter converter = new Converter();
        Calculator calculator = new Calculator();

        int firstNumber;
        int secondNumber;
        String operator;

        if (arab && roman) {
            throw new UnsupportedOperationException(
                    "The expression " + "must be in the same numeral system.");
        } else if (arab) {
            firstNumber = Integer.parseInt(expression[0]);
            secondNumber = Integer.parseInt(expression[1]);
            operator = expression[2];
            System.out.println(
                    calculator.calculate(firstNumber, secondNumber, operator));
        } else if (roman) {
            firstNumber = converter.romanToArabic(expression[0]);
            secondNumber = converter.romanToArabic(expression[1]);
            operator = expression[2];
            System.out.println(converter.arabicToRoman(
                    calculator.calculate(firstNumber, secondNumber, operator)));
        }
    }

    private static boolean validateExpression(String input) {
        if (!input.matches("^[\\dMDCLXVI]+\\s?[+\\-/*]\\s"
                + "?[\\dMDCLXVI]+$")) {
            throw new UnsupportedOperationException("The expression must be "
                    + "in the format: 2 + 2 or X + X");
        }
        return true;
    }

    private static String[] parseExpression(String input) {
        String[] tokens;
        StringBuilder expression = new StringBuilder();
        String operator = "";

        input = input.replaceAll(" ", "");
        tokens = input.split("");

        for (String token : tokens) {
            if (isArab(token)) {
                arab = true;
                expression.append(token);
            } else if (isRoman(token)) {
                roman = true;
                expression.append(token);
            } else if (isOperator(token)) {
                operator = token;
                expression.append(",");
            } else {
                throw new UnsupportedOperationException(
                        token + " invalid " + "token");
            }
        }

        expression.append(",");
        expression.append(operator);

        return expression.toString().split(",");
    }

    private static boolean isRoman(String input) {
        return input.matches("^[MDCLXVI]+$");
    }

    private static boolean isArab(String input) {
        return input.matches("^\\d+$");
    }

    private static boolean isOperator(String input) {
        return input.matches("^[+\\-/*]$");
    }

    private static void resetNumeralSystem() {
        arab = false;
        roman = false;
    }
}



