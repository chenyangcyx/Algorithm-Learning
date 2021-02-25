package CSNotes.Sort;

import java.util.*;

public class No451SortCharactersByFrequency {
    public String frequencySort1(String s) {
        // 获取字符串中每一个字符的出现频率
        Map<Character, Integer> char_frequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char_frequency.put(s.charAt(i), char_frequency.getOrDefault(s.charAt(i), 0) + 1);
        }
        // 将出现频率转换为对应的数组
        Map<Integer, List<Character>> frequency_char = new HashMap<>();
        for (char key : char_frequency.keySet()) {
            frequency_char.computeIfAbsent(char_frequency.get(key), k -> new ArrayList<>()).add(key);
        }
        // 将出现频率数值大小排序
        List<Integer> fre_list = new ArrayList<>(frequency_char.keySet());
        Collections.sort(fre_list, Collections.reverseOrder());
        // 按序输出频率最多的字母
        StringBuilder sb = new StringBuilder();
        for (int num : fre_list) {
            for (char ch : frequency_char.get(num)) {
                for (int i = 0; i < num; i++) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    // CS_Note参考代码
    public String frequencySort2(String s) {
        Map<Character, Integer> frequencyForNum = new HashMap<>();
        for (char c : s.toCharArray())
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);

        List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];
        for (char c : frequencyForNum.keySet()) {
            int f = frequencyForNum.get(c);
            if (frequencyBucket[f] == null) {
                frequencyBucket[f] = new ArrayList<>();
            }
            frequencyBucket[f].add(c);
        }
        StringBuilder str = new StringBuilder();
        for (int i = frequencyBucket.length - 1; i >= 0; i--) {
            if (frequencyBucket[i] == null) {
                continue;
            }
            for (char c : frequencyBucket[i]) {
                for (int j = 0; j < i; j++) {
                    str.append(c);
                }
            }
        }
        return str.toString();
    }
}
