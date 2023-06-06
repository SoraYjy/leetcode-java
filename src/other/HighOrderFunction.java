package other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author yujingyi
 * @date 2022/9/9
 */
public class HighOrderFunction {

  public int order (String express) {
    int currentVal = 0;
    // 计算列表
    LinkedList<Integer> result = new LinkedList<>();
    // 遍历栈
    Stack<Character> stack = new Stack();
    // 左括号数
    int left = 0;

    // 从右往左遍历
    int i = express.length();
    while (i >= 0) {
      --i;
      char cur;
      if (i >= 0 ) {
        cur = express.charAt(i);
      } else {
        cur = '-';
      }

      // 如果是右括号，则直接入栈
      if (cur == ')') {
        stack.push(cur);
        continue;
      }

      // 如果是左括号，那么栈顶的肯定不会是右括号，弹出栈顶
      if (cur == '(') {
        if (stack.peek() == ')') {
          stack.pop();
          continue;
        } else {
          ++left;
        }
      }

      // 如果是键头的末端，则跳过，在左端再操作
      if (cur == '>') {
        continue;
      }

      // 如果是键头，有两三情况：
      // 1. 如果栈为空，则将原始值 0 放入计算列表
      // 2. 如果栈顶是箭头，则说明两个箭头间没有被右括号分隔，那么遵循右结合的原则，直接计算 () -> ()，并不断弹出栈顶的箭头
      // 3. 如果栈顶是右括号，则说明有更优先级的计算顺序，先把当前值放入计算列表
      if (cur == '-') {
        if (stack.isEmpty()) {
          result.add(0);
          stack.push('-');
          continue;
        }

        if (stack.peek() == '-') {
          while (!stack.isEmpty() && stack.peek() == '-') {
            int last = result.removeLast();
            currentVal = arrow(currentVal, last);
            // 弹出栈顶的 -
            stack.pop();
            while (!stack.isEmpty() && stack.peek() == ')' && left > 0) {
              stack.pop();
              --left;
            }
          }
          continue;
        }

        if (stack.peek() == ')') {
          result.add(currentVal);
          currentVal = 0;
          stack.push('-');
          continue;
        }
      }
    }

    if (!stack.isEmpty()) {
      currentVal = arrow(currentVal, result.getFirst());
    }
    return currentVal;
  }

  private int arrow(int a, int b) {
    return a + 1 > b ? a + 1 : b;
  }

  public static void main(String[] args) {
    HighOrderFunction function = new HighOrderFunction();
//    System.out.println(function.order("()->()"));
//    System.out.println(function.order("()->(((()->())->()->())->())"));
    System.out.println(function.order("(((((((((())->(((())->(((())->())->((()->(()))->(((()))->(())))))))->((())->()))->(((()))))->(((((())->())->())->())->((())->(())))))->(((((())->())->(((((()))))->(())))->(((((()))->(()))->())))->(((((())->(()))->((())->(())))->(((())->(()->((()))))->(()))))))->(((((((())->(()))->((((())))))))->(((()->(())))->(((())->(()))->((()->(()->(())))->(()))))))))->(((((((((((((())->((())->((((())->())->(()))->()))))))))))->(((()))->((()->((())))->(()->(())))))))->(((((((()))->(()->((())))))->(((((()->((()))))->((())->()))->(())))))->((((((())->(()->((((((())->(()))))->(((()->(())))->(())))->())))))))))"));
  }

}
