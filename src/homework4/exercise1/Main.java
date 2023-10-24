package homework4.exercise1;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();

        String hoten = "nguyenvanninh";

        for (int i = 0; i < hoten.length(); i++) {
            if (i % 2 == 0)
                s.push(hoten.charAt(i));
            if (i % 3 == 0)
                s.pop();
        }

        s.forEach(i -> System.out.print(i + " "));
    }
}

/**
 * Cac buoc hoat dong
 * 0. i = 0; %2, %3 - n
 * 0. pust - n; s = {n}
 * 0. pop - n; s = {}
 * <p>
 * 1. i = 1; - g
 * 1. false
 * 1 false
 * <p>
 * 2. i = 2; %2 - u
 * 2. pust - u; s = {u}
 * 2. false
 * <p>
 * 3. i = 3; %3 - y
 * 3. false
 * 3. pop - u; s = {}
 * <p>
 * 4. i = 4; %2 - e
 * 4. pust - y, s = {e}
 * 4. false
 * <p>
 * 5. i = 5 - n
 * 5. false
 * 5. false
 * <p>
 * 6. i = 6; %2, %3 - v
 * 6. pust - v; s = {e, v}
 * 6. pop - v; s = {e};
 * <p>
 * 7. i = 7; %2 - a
 * 7. false
 * 7. false
 * <p>
 * 8. i = 8; %2 - n
 * 8. push - n; s = {e, n}
 * 8. false
 * <p>
 * 9. i = 9; %2, %3 - n
 * 9. false
 * 9. pop - n; s = {e}
 * <p>
 * 10. i = 10; %2, %3 - i
 * 10. push - i; s = {e, i}
 * 10. false
 * <p>
 * 11. i = 11; %2, %3 - n
 * 11. false
 * 11. false
 * <p>
 * 12. i = 12; %2, %3 - h
 * 12. pust - h; s = {e, i, h}
 * 12. pop - h; s = {e, i}
 */
/** Ket qua cuoi cung
 * s = {e, i}
 */

