package homework4.exercise5;

public class Main {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();

        String text1 = "abcdefghikihgfedcba";
        System.out.println(palindrome.isPalindrome(text1));

        String text2 = "gdfgsdfuogh";
        System.out.println(palindrome.isPalindrome(text2));
    }
}
