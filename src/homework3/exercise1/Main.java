package homework3.exercise1;

public class Main {
    public static void main(String[] args) {
        Fraction fac1 = new Fraction(1, 2);
        Fraction fac2 = new Fraction(1, 3);

        System.out.printf("%s + %s = %s\n", fac1, fac2, fac1.add(fac2));
        System.out.printf("%s - %s = %s\n", fac1, fac2, fac1.minus(fac2));
        System.out.printf("%s x %s = %s\n", fac1, fac2, fac1.multi(fac2));
        System.out.printf("%s / %s = %s\n", fac1, fac2, fac1.divi(fac2));
    }
}
