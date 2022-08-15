package searchElement;

public class BinarySearch {
    public static int binarySearch(int[] arr, int low, int high, int key) {
        if(low > high) {
            return -1;
        }
        if(low == high) {
            return low;
        }
        int mid = low + (high - low) / 2;
        if(arr[mid] == key) {
            return mid;
        }
        if(arr[mid] > key) {
            return binarySearch(arr, low, mid - 1, key);
        }
        return binarySearch(arr, mid + 1, high, key);
    }
}
