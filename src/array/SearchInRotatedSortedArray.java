package array;

/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int length = nums.length;
        int low = 0, high = length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int curNum = nums[mid];
            if (curNum == target) {
                return mid;
            }

            boolean rotated = curNum <= nums[0];
            if (rotated) {
                if (curNum < target && target < nums[0]) {
                    low = mid + 1;
                } else if (curNum < target && target >= nums[0]) {
                    high = high - 1;
                } else {
                    high = high - 1;
                }
            } else {
                if (target < curNum && target >= nums[0]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }


//
//            boolean isPivot;
//            if (mid == (length - 1)) {
//                isPivot = nums[mid] < nums[0];
//            } else if (mid == 0) {
//                isPivot = nums[mid] > nums[mid + 1];
//            } else {
//                isPivot = nums[mid] > nums[mid + 1];
//            }
//
//            if (target > nums[mid] && !isPivot) {
//                low = mid + 1;
//            } else if (target > nums[mid] && isPivot) {
//                high = mid - 1;
//            } else if (target < nums[mid] && !isPivot) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {3,5,1};
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.search(arr, 3));
    }
}
