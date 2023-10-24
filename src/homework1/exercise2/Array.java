package homework1.exercise2;

public class Array<T> {
    public boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public boolean isPerfectNumber(int number) {
        if (number <= 1) return false;
        int sum = 1;
        for (int i = 1; i < number / 2; i++) {
            if (number % i == 0) sum *= i;
        }
        return sum == number;
    }

    public void findAndPrintElements(T[] array, Condition condition) {
        for (T element : array) {
            if (condition.condition(element))
                System.out.print(element + " ");
        }
    }

    public void findAndPrintElements(int[] array) {
        for (int arr : array) {
            if (isPrime(arr))
                System.out.print(arr + " ");
        }
    }
}
