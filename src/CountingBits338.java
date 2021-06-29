import java.util.Arrays;

/**
 * tags: #DP
 */
public class CountingBits338 {
    public static void main(String[] args) {
        CountingBits338 cb = new CountingBits338();
        System.out.println(Arrays.toString(cb.countBits(2)));
        System.out.println(Arrays.toString(cb.countBits(5)));
        System.out.println(Arrays.toString(cb.countBits_DP(5)));
    }

    /*
    这题是统计每个数字转成二进制有多少个1，十进制转成二进制可以用短除法，即不断除以2，
    然后每次的余数合起来就是二进制数。对于10，10/2=5，
    因此10转成二进制包含的1的个数 = 5转成二进制包含1的个数 + (10%2)。
    后面的计算可以用到前面的结果，典型的dp
     */
    public int[] countBits_DP(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            bits[i] = bits[i / 2];
            if (i % 2 == 1) bits[i]++;
        }
        return bits;
    }

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i < result.length; i++) {
            countOnes(i, result);
        }
        return result;
    }

    private void countOnes(int i, int[] result) {
        int count = 0;
        int temp = i;
        while (temp != 0) {
            count = (temp % 2) == 1 ? count + 1 : count;
            temp = temp / 2;
            if (result[temp] != 0) {
                count += result[temp];
                break;
            }
        }
        result[i] = count;
    }
}
