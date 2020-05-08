package utils;

/**
 * Created by yujingyi on 2020-05-07.
 */
public class Sort {
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start, right = end;
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] > pivot) {
                --right;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                ++left;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }
}
