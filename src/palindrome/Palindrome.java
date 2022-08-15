package palindrome;

public class Palindrome {

    public static boolean isPalindrome(int n) {
        int rev = 0, dup = n, r;
        while(n > 0) {
            r = n % 10;
            rev = rev * 10 + r;
            n /= 10;
        }
        return rev == dup;
    }
}
