package array;

/**
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int length = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                nums[length] = nums[i];
            } else {
                nums[length++] = nums[i];
            }
        }
        return length;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int[] arr1 = {1,1,2};
        int[] arr2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(arr1));
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(arr2));
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(arr2));
    }
}
