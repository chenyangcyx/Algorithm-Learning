package QuestionBank.No701_800;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No763PartitionLabels {
    public List<Integer> partitionLabels1(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> last_pos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            last_pos.put(s.charAt(i), i);
        }

        int pre = 0;
        int end = last_pos.get(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            int pos = last_pos.get(s.charAt(i));
            if (i < end) {
                end = Math.max(end, pos);
            } else if (i > end) {
                pre = i;
                end = pos;
            }
            if (i == end) {
                result.add(end - pre + 1);
            }
        }
        return result;
    }

    // LeetCode 官方题解
    public List<Integer> partitionLabels2(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

    public static void main(String[] args) {
        String s1 = "ababcbacadefegdehijhklij";
        String s2 = "caedbdedda";
        String s3 = "eaaaabaaec";

        No763PartitionLabels no763PartitionLabels = new No763PartitionLabels();

        System.out.println(no763PartitionLabels.partitionLabels1(s1));
        System.out.println(no763PartitionLabels.partitionLabels1(s2));
        System.out.println(no763PartitionLabels.partitionLabels1(s3));
    }
}
