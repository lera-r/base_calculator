import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        calculator.startCalc();
    }

} // end class

class Calculator {

    private boolean newObjFlag = true;
    private float finalResult = 0;
    char EXIT_CHAR = 's';
    char CLEAN_CHAR = 'C';

    public void startCalc() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("Please enter %c if want to exit and ", EXIT_CHAR);
            System.out.printf("enter %c if want to clean values: \n",CLEAN_CHAR);
            String userStr = scanner.nextLine();

            if (userStr.length() == 1 && Character.toLowerCase(userStr.charAt(0)) == EXIT_CHAR) {
                System.out.printf("Program was finished. \n");
                break;

            } else if (userStr.length() == 1 && userStr.charAt(0) == CLEAN_CHAR) {
                System.out.printf("All values were cleaned. \n");
                newObjFlag = true;
            }
            else {
                calculation();
                System.out.printf("Result calculation: %.2f \n", finalResult);

            }
        }
    }

    private void calculation(){
        float firstValue;
        float secondValue;
        String operator;

        if (newObjFlag) {
            firstValue = checkValue("first");
            operator = checkOperator();
            secondValue = checkValue("second");
            newObjFlag = false;
        }
        else{
            firstValue = finalResult;
            operator = checkOperator();
            secondValue = checkValue("next");
        }

        switch (operator) {
            case "+" -> finalResult = firstValue + secondValue;
            case "-" -> finalResult = firstValue - secondValue;
            case "*" -> finalResult = firstValue * secondValue;
            case "/" -> finalResult = firstValue / secondValue;

        }
    }

    private float checkValue(String valuesNumber) {

        float number;

        while (true) {

            try {
                Scanner scanner = new Scanner(System.in);
                System.out.printf("Please enter the %s value:",valuesNumber);
                number = scanner.nextFloat();
                return number;
            } catch (Exception e) {
                System.out.printf("Please enter only numbers.\n");

            }

        }
    }

    private String checkOperator()
    {
        String operator;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Please enter operator (+,-,*,/): ");
            operator = scanner.next();

            if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                return operator;
            } else {
                System.out.printf("Please enter only one of the following operators (+,-,*,/).\n");

            }
        }
    }

} //end class

