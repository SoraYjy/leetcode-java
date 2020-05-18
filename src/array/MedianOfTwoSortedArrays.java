package array;

/**
 * 4. Median of Two Sorted Arrays
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 */
public class MedianOfTwoSortedArrays {
    /**
     * 放入一个数组
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        boolean isEven = totalLength % 2 == 0;
        int medianPos = totalLength / 2;
        int[] arr = new int[medianPos + 2];
        int pos1 = 0, pos2 = 0;

        int cur;
        for (int i = 0; i <= medianPos; ++i) {
            if (pos1 == nums1.length) {
                cur = nums2[pos2++];
            } else if (pos2 == nums2.length) {
                cur = nums1[pos1++];
            } else if (nums1[pos1] <= nums2[pos2]) {
                cur = nums1[pos1++];
            } else {
                cur = nums2[pos2++];
            }
            arr[i] = cur;

        }

        return isEven ? (((double) arr[medianPos - 1] + (double) arr[medianPos]) / 2) : arr[medianPos];
    }

    public static void main(String[] args) {
        int[] nums1 = {}, nums2 = {2};
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}
