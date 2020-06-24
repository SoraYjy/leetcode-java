package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yujingyi on 2020-06-19.
 */
public class MinimumIncrementToMakeArrayUnique {
    /**
     * 通过 map 记录出现次数, 从 0 开始遍历这个 map 的 key 来获取值
     * @param A
     * @return
     */
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; ++i) {
            Integer num = map.get(A[i]);
            num = num == null ? 0 : num;
            map.put(A[i], ++num);
        }

        int count = 0, visit = 0, cursor = 0;
        while (visit < map.size()) {
            Integer num = map.get(cursor);
            if (num == null || num == 0) {
                ++cursor;
                continue;
            }
            if (num == 1) {
                ++visit;
                ++cursor;
                continue;
            }
            count += num - 1;
            ++cursor;
            Integer newNum = map.get(cursor);
            newNum = newNum == null ? 0 : newNum;
            map.put(cursor, newNum + num - 1);
            ++visit;
        }
        return count;
    }
}
