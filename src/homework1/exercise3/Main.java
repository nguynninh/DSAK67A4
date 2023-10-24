package homework1.exercise3;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ComplexNumbers num = new ComplexNumbers();

        ComplexNumbers complex1 = new ComplexNumbers("5 + 2i");
        ComplexNumbers complex2 = new ComplexNumbers("4 + 3i");

        System.out.println("Perform calculations with 2 complex numbers");
        System.out.println("Complex numbers: [" + complex1 + ", " + complex2 + "]");
        System.out.println("Sum: " + num.add(complex1, complex2));
        System.out.println("Subtraction: " + num.subtraction(complex1, complex2));
        System.out.println("Multiply: " + num.multiply(complex1, complex2));
        System.out.println("Division: " + num.division(complex1, complex2));
        System.out.println("\n");

        System.out.println("Perform calculations with complex numbers");
        Random rd = new Random();
        double maxValue = 100;
        double minValue = -100;
        int price = 5;

        ComplexNumbers[] numbers = new ComplexNumbers[price];
        for (int i = 0; i < price; i++) {
            numbers[i] = new ComplexNumbers(
                    rd.nextDouble(minValue, maxValue + 1),
                    rd.nextDouble(minValue, maxValue + 1)
            );
        }
        System.out.println("Complex numbers: " + Arrays.toString(numbers));
        System.out.println("Sum:" + num.add(numbers));
        System.out.println("Subtraction: " + num.subtraction(numbers));
        System.out.println("Multiply: " + num.multiply(numbers));
        System.out.println("Division: " + num.division(numbers));
    }
}
