package homework1.exercise3;

public class ComplexNumbers {
    private double real;
    private double imag;

    public ComplexNumbers() {
    }

    public ComplexNumbers(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public ComplexNumbers(String numberStr) {
        String[] numbers = numberStr.trim()
                .replace(",", ".")
                .replace("i", "")
                .split("\\+");
        this.real = Double.parseDouble(numbers[0]);
        this.imag = Double.parseDouble(numbers[1]);
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public ComplexNumbers add(ComplexNumbers numbers1, ComplexNumbers numbers2) {
        double real = numbers1.getReal() + numbers2.getReal();
        double imag = numbers1.getImag() + numbers2.getImag();
        return new ComplexNumbers(real, imag);
    }

    public ComplexNumbers add(ComplexNumbers... numbers) {
        ComplexNumbers sumNumbers = new ComplexNumbers();
        for (int i = 0; i < numbers.length; i++) {
            sumNumbers = add(sumNumbers, numbers[i]);
        }
        return sumNumbers;
    }

    public ComplexNumbers subtraction(ComplexNumbers numbers1, ComplexNumbers numbers2) {
        double real = numbers1.getReal() - numbers2.getReal();
        double imag = numbers1.getImag() - numbers2.getImag();
        return new ComplexNumbers(real, imag);
    }

    public ComplexNumbers subtraction(ComplexNumbers... numbers) {
        ComplexNumbers subNumbers = new ComplexNumbers();
        for (int i = 0; i < numbers.length; i++) {
            subNumbers = subtraction(subNumbers, numbers[i]);
        }
        return subNumbers;
    }

    public ComplexNumbers multiply(ComplexNumbers number1, ComplexNumbers number2) {
        double real = (number1.getReal() * number2.getReal()) - (number1.getImag() * number2.getImag());
        double imag = (number1.getReal() * number2.getImag()) + (number1.getImag() * number2.getReal());
        return new ComplexNumbers(real, imag);
    }

    public ComplexNumbers multiply(ComplexNumbers... numbers) {
        ComplexNumbers sumNumbers = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            sumNumbers = multiply(sumNumbers, numbers[i]);
        }
        return sumNumbers;
    }

    public ComplexNumbers division(ComplexNumbers numbers1, ComplexNumbers numbers2) {
        double denominator = Math.pow(numbers2.getReal(), 2) + Math.pow(numbers2.getImag(), 2);
        double real = (numbers1.getReal() + numbers2.getReal()) + (numbers1.getImag() + numbers2.getImag()) / denominator;
        double imag = (numbers1.getImag() * numbers2.getReal()) - (numbers1.getReal() * numbers1.getReal()) / denominator;
        return new ComplexNumbers(real, imag);
    }

    public ComplexNumbers division(ComplexNumbers... numbers) {
        ComplexNumbers divNumbers = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            divNumbers = division(divNumbers, numbers[i]);
        }
        return divNumbers;
    }

    @Override
    public String toString() {
        if (real == 0 && imag == 0) return "0";
        if (real == 0) return imag + "i";
        if (imag == 0) return real + "";
        if (imag > 0) return real + " + " + imag + "i";
        else return real + " - " + (-imag) + "i";
    }
}
