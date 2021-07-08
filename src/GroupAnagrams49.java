import java.util.*;

/**
 * tags: #HashMap, #sorting
 */
public class GroupAnagrams49 {
    public static void main(String[] args) {

    }

    /*
    https://leetcode.com/problems/group-anagrams/discuss/19176/Share-my-short-JAVA-solution
     */
    public List<List<String>> groupAnagrams_CharArray(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            //char type 0~127 is enough for constraint 0 <= strs[i].length <= 100
            //char array to String is really fast, thanks @legendaryengineer
            //You should use other data type when length of string is longer.
            //E.g. Use byte (-128 to 127), short (-32,768 to 32,767),
            //int. -2,147,483,648 to 2,147,483,647
            char[] chars = new char[26];
            for (char c : s.toCharArray()) chars[c - 'a']++;
            String key = String.valueOf(chars);
            List<String> group = map.getOrDefault(key, new ArrayList<>());
            group.add(s);
            map.put(key, group);
        }

        return new ArrayList<>(map.values());
    }

    /*
    https://leetcode.com/problems/group-anagrams/discuss/19176/Share-my-short-JAVA-solution
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> group = map.getOrDefault(key, new ArrayList<>());
            group.add(s);
            map.put(key, group);
        }

        return new ArrayList<>(map.values());
    }
}
