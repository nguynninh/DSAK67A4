package homework1.exercise5.p1_27;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Caculator caculator = new Caculator();
        while (true) {
            System.out.println("You enter your math here: ");
            System.out.println(caculator.inputTransformation(sc.nextLine()));
            System.out.print("Bạn có muốn tính toán nữa không (y/n): ");
            if (sc.nextLine().contains("n")) break;
        }
    }
}
