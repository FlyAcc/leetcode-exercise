package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * tags: #HashTable, #XOR
 */
public class SingleNumber136 {
    public static void main(String[] args) {
        SingleNumber136 sn = new SingleNumber136();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(sn.singleNumber(nums));
        System.out.println(sn.singleNumber_Xor(nums));
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int time = map.getOrDefault(num, 0);
            map.put(num, ++time);
        }

        for (int num : nums) {
            if (map.get(num) == 1) {
                return num;
            }
        }

        throw new IllegalArgumentException();
    }

    /*
     true if and only if its arguments differ(one is true, the other is false)
     a⊕0=a
     a⊕a=0
     a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
     */
    public int singleNumber_Xor(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }

    /*
    2∗(a+b+c)−(a+a+b+b+c)=c
     */
    public int singleNumber_Math(int[] nums) {
        int sumOfSet = 0, sumOfNums = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            // hashset contain(): O(1); list: O(n)
            if (!set.contains(num)) {
                set.add(num);
                sumOfSet += num;
            }
            sumOfNums += num;
        }
        return 2 * sumOfSet - sumOfNums;
    }
}
