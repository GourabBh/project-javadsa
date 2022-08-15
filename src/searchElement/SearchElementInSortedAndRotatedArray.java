package searchElement;

public class SearchElementInSortedAndRotatedArray {
    private static int findPivot(int[] arr, int low, int high) {
        if(high < low) {
            return -1;
        }
        if(high == low) {
            return low;
        }
        int mid = low + (high - low) / 2;
        if(mid < high && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if(mid > low && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        }
        if(arr[low] >= arr[mid]) {
            return findPivot(arr, low, mid - 1);
        }
        return findPivot(arr, mid + 1, high);
    }

    private static int findElement(int[] arr, int n, int key) {
        int pivotEl = findPivot(arr, 0, n - 1);
        if(pivotEl == -1) {
            return BinarySearch.binarySearch(arr, 0, n - 1, key);
        }
        if(arr[pivotEl] == key) {
            return pivotEl;
        }
        if(arr[0] <= key) {
            return BinarySearch.binarySearch(arr, 0, pivotEl - 1, key);
        }
        return BinarySearch.binarySearch(arr, pivotEl + 1, n - 1, key);
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        int n = arr.length;
        int key = 1;
        System.out.println("Element found at index: " + findElement(arr, n, key));
    }
}
