import palindrome.Palindrome;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String s = "super!";
        int n = 343;
        boolean result = Palindrome.isPalindrome(n);
        if(result) {
            System.out.println("Palindrome: " + s);
        }
    }
}