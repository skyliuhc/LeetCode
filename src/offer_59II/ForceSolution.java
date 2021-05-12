package offer_59II;

/**
 * @author skyliuhc
 * @create 2021/5/5
 */
public class ForceSolution {


    class MaxQueue {
        int[] q = new int[20000];
        int begin = 0, end = 0;

        public MaxQueue() {

        }

        public int max_value() {
            int ans = -1;
            for (int i = begin; i != end; ++i) {
                ans = Math.max(ans, q[i]);
            }
            return ans;
        }

        public void push_back(int value) {
            q[end++] = value;
        }

        public int pop_front() {
            if (begin == end) {
                return -1;
            }
            return q[begin++];
        }
    }


}
