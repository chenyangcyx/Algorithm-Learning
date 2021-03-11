package CSNotes.BFS;

import java.util.*;

public class No127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() < 1 || !wordList.contains(endWord)) return 0;
        LinkedList<String> queue = new LinkedList<>();
        HashMap<String, Boolean> inque = new HashMap<>();
        queue.addLast(beginWord);
        inque.put(beginWord, true);
        int length = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            while (size-- > 0) {
                String t = queue.pollFirst();
//                if(t.equals(endWord)) return length-1;
                for (String str : wordList) {
                    if (!inque.getOrDefault(str, false) && diffNumOfTwoWord(t, str) == 1) {
                        if (str.equals(endWord)) return length;
                        queue.addLast(str);
                        inque.put(str, true);
                    }
                }
            }
//            System.out.println(queue.toString());
        }
        return 0;
    }

    private int diffNumOfTwoWord(String a, String b) {
        int diffNum = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffNum++;
                if (diffNum >= 2) return diffNum;
            }
        }
        return diffNum;
    }

    // CS-Note参考代码
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int N = wordList.size();
        int start = N - 1;
        int end = 0;
        while (end < N && !wordList.get(end).equals(endWord)) {
            end++;
        }
        if (end == N) {
            return 0;
        }
        List<Integer>[] graphic = buildGraphic(wordList);
        return getShortestPath(graphic, start, end);
    }

    private List<Integer>[] buildGraphic(List<String> wordList) {
        int N = wordList.size();
        List<Integer>[] graphic = new List[N];
        for (int i = 0; i < N; i++) {
            graphic[i] = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if (isConnect(wordList.get(i), wordList.get(j))) {
                    graphic[i].add(j);
                }
            }
        }
        return graphic;
    }

    private boolean isConnect(String s1, String s2) {
        int diffCnt = 0;
        for (int i = 0; i < s1.length() && diffCnt <= 1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCnt++;
            }
        }
        return diffCnt == 1;
    }

    private int getShortestPath(List<Integer>[] graphic, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[graphic.length];
        queue.add(start);
        marked[start] = true;
        int path = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int next : graphic[cur]) {
                    if (next == end) {
                        return path;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }
}
