package homework1.exercise1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        byte byteValue = sc.nextByte();
        System.out.println("Value of type byte: " + byteValue);

        System.out.print("Enter an integer: ");
        short shortValue = sc.nextShort();
        System.out.println("Value of type short: " + shortValue);

        System.out.print("Enter an integer: ");
        int intValue = sc.nextInt();
        System.out.println("Value of type integer: " + intValue);

        System.out.print("Enter an integer: ");
        long longValue = sc.nextLong();
        System.out.println("Value of type long: " + longValue);

        System.out.print("Enter a decimal number: ");
        float floatValue = sc.nextFloat();
        System.out.println("Value of type float: " + floatValue);

        System.out.print("Enter a decimal number: ");
        double doubleValue = sc.nextDouble();
        System.out.println("Value of type double: " + doubleValue);

        System.out.print("Enter a character type: ");
        char charValue = sc.next().charAt(0);
        System.out.println("Value of type char: " + charValue);

        System.out.print("Enter a true or false type: ");
        boolean boolValue = sc.nextBoolean();
        System.out.println("Value of type boolean: " + boolValue);

        sc.close();
    }
}
