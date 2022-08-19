package kadane;

public class Kadane {
    private static int findMaxSum(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0, n = arr.length, i;
        for(i = 0; i < n; i++) {
            maxEndingHere = maxEndingHere + arr[i];
            if(maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
            if(maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Max contiguous sum: " + findMaxSum(arr));
    }
}
