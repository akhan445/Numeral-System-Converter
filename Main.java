package converter;

import java.util.Scanner;

/**
 * The main method which converts a number into a different radix.
 * The program reads for 3 lines of input:
 *      1) Source Radix
 *      2) Number to be converted
 *      3) Target Radix
 * */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String radix = "^([1-9]|1[0-9]|2[0-9]|3[0-6])$";
        String validNum = "^([a-zA-Z0-9]+|([a-zA-Z0-9]+\\.[a-zA-Z0-9]+))$";
        int sourceBase = 0;
        int targetBase = 0;

        /* Check for a valid source radix */
        String srcInput = scanner.nextLine().trim();
        if (srcInput.matches(radix) && scanner.hasNextLine()) {
            sourceBase = Integer.parseInt(srcInput);
        } else {
            System.out.println("error- invalid radix (source)");
            return;
        }
        /* Check if user has input a valid number for conversion */
        String number = scanner.nextLine().trim();
        if (!number.matches(validNum) || !scanner.hasNextLine()) {
            System.out.println("error");
            return;
        }
        /* Check for valid target radix */
        String targetInput = scanner.nextLine().trim();
        if (targetInput.matches(radix)) {
            targetBase = Integer.parseInt(targetInput);
        } else {
            System.out.println("error- invalid radix (target)");
            return;
        }

        NumberConverter numConverter = new NumberConverter(number, sourceBase, targetBase);

        /* the provided number is a fraction */
        if (number.matches("^\\s*[a-zA-Z0-9]+\\.[a-zA-Z0-9]+\\s*$")) {
            numConverter.convertFractionNumber();
        } else {
            numConverter.convertNumber();                           // the provided number is a whole number
        }
        System.out.println(numConverter.getConvertedNumber());      // print the converted number
    }
}
