package dutchNatlFlag;

import java.util.Arrays;

public class DutchNatlFlag {
    private static int[] rearrangeArray(int[] arr, int n) {
        int low = 0, high = n - 1, mid = 0, temp;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0 -> {
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                }
                case 1 -> mid++;
                case 2 -> {
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int n = arr.length;
        System.out.println("Sorted elements 0, 1, 2: " + Arrays.toString(rearrangeArray(arr, n)));
    }
}
