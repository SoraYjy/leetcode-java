package other;

/**
 * Created by yujingyi on 2020-04-25.
 */
public class ContainerWithMostWater {
    /**
     * 硬遍历 O(n2)
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int length = height.length, max = 0;
//        int[][] areaArr = new int[length][length];
        for (int i = 0; i < length; ++i) {
            for (int j = i; j < length; ++j) {
//                areaArr[i][j] = calArea(height, i, j);
                int area = calArea(height, i, j);
                max = max > area ? max : area;
            }
        }

        return max;
    }

    private int calArea(int[] height, int i, int j) {
        return (j - i) * (height[i] > height[j] ? height[j] : height[i]);
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(containerWithMostWater.maxArea(height));
    }
}
