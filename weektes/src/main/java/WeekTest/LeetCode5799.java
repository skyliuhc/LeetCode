package WeekTest;

public class LeetCode5799 {
    public long wonderfulSubstrings(String word) {
        int[] freq = new int[1 << 10];//2^10是用10位二进制数来表示所有字符串的奇偶性，第i位数字为0表示出现的次数为偶数，1为奇数
        freq[0] = 1;//初始状态，所有字符都没有出现，相当于是偶数
        int pre = 0;//前缀和 初始状态： [0,0,0...,0] 10个0   最大的范围[1,1,1...] 10个1
        long res = 0;//结果
        //遍历所有的字符
        for (char c : word.toCharArray()) {
            pre ^= (1 << (c - 'a'));//异或前缀和 0^1=1 0^0=0 1^1=0
            res += freq[pre];
            //枚举当前前缀和的每个比特 即 1<<i (i 属于 [0:9])
            for (int i = 0; i < 10; i++) {
                res += freq[pre ^ (1 << i)];
            }
            freq[pre]++;
        }
        return res;
    }
}
