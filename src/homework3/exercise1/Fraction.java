package homework3.exercise1;

public class Fraction {
    private float numerator;
    private float denominator;

    public Fraction(float numerator, float denominator) {
        if (denominator == 0)
            throw new ArithmeticException("The denominator cannot be 0");
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction c) {
        return add(this, c);
    }

    public Fraction minus(Fraction c) {
        return minus(this, c);
    }

    public Fraction multi(Fraction c) {
        return multi(this, c);
    }

    public Fraction divi(Fraction c) {
        return divi(this, c);
    }

    public Fraction normalize(Fraction c) {
        float gcd = gcd(c.numerator, c.denominator);
        c.numerator /= gcd;
        c.numerator /= gcd;
        return c;
    }

    public float getNumerator() {
        return numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + " / " + denominator;
    }

    //PRIVATE
    private Fraction add(Fraction frac1, Fraction frac2) {
        Fraction sumFac;

        if (frac1.denominator == frac2.denominator)
            normalize(
                    sumFac = new Fraction(
                            frac1.numerator + frac2.numerator,
                            frac1.denominator
                    )
            );
        else
            normalize(
                    sumFac = new Fraction(
                            frac1.numerator * frac2.denominator + frac2.numerator * frac1.denominator,
                            frac1.denominator * frac2.denominator
                    )
            );

        return sumFac;
    }

    private Fraction minus(Fraction frac1, Fraction frac2) {
        Fraction minusFac;

        if (frac1.denominator == frac2.denominator)
            normalize(
                    minusFac = new Fraction(
                            frac1.numerator - frac2.numerator,
                            frac1.denominator
                    )
            );
        else
            normalize(
                    minusFac = new Fraction(
                            frac1.numerator * frac2.denominator - frac2.numerator * frac1.denominator,
                            frac1.denominator * frac2.denominator
                    )
            );

        return minusFac;
    }

    private Fraction multi(Fraction frac1, Fraction frac2) {
        return normalize(
                new Fraction(
                frac1.numerator * frac2.numerator,
                frac1.denominator * frac2.denominator
                )
        );
    }

    private Fraction divi(Fraction frac1, Fraction frac2) {
        return normalize(
                new Fraction(
                frac1.numerator * frac2.denominator,
                frac2.numerator * frac1.denominator
                )
        );
    }

    private float lcm(float num1, float num2) {
        return (num1 / gcd(num1, num2)) * num2;
    }

    private float gcd(float num1, float num2) {
        if (num2 == 0)
            return num1;
        return gcd(num2, num1 % num2);
    }
}
