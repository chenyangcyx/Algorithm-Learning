package QuestionBank.No101_200;

import java.util.*;

public class No127WordLadder {
    int len = 0;
    // LeetCode 参考代码1
    Map<String, Integer> wordId = new HashMap<String, Integer>();
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
    int nodeNum = 0;

    public static void main(String[] args) {
        No127WordLadder no127WordLadder = new No127WordLadder();

        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(no127WordLadder.ladderLength(beginWord1, endWord1, wordList1));

        String beginWord2 = "hit";
        String endWord2 = "cog";
        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println(no127WordLadder.ladderLength(beginWord2, endWord2, wordList2));

        String beginWord3 = "hot";
        String endWord3 = "dog";
        List<String> wordList3 = Arrays.asList("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot");
        System.out.println(no127WordLadder.ladderLength(beginWord3, endWord3, wordList3));

        String beginWord4 = "hit";
        String endWord4 = "cog";
        List<String> wordList4 = Arrays.asList("hot", "cog", "dot", "dog", "hit", "lot", "log");
        System.out.println(no127WordLadder.ladderLength(beginWord4, endWord4, wordList4));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 判断数据是否正确
        if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) {
            return 0;
        }
        // 建立单词连接图
        List<String> newWordList = new ArrayList<>(wordList);
        if (!newWordList.contains(beginWord)) {
            newWordList.add(beginWord);
        }
        len = newWordList.size();
        HashMap<String, Integer> word_no = new HashMap<>();
        int no = 0;
        for (String word : newWordList) {
            word_no.put(word, no);
            no++;
        }
        // 建立单词的连接图
        boolean[][] graph = new boolean[len][len];
        buildWordGraph(graph, newWordList);
        // 计算结果
        return calStepLength(newWordList, graph, beginWord, endWord, word_no);
    }

    private int calStepLength(List<String> wordList, boolean[][] graph, String startWord, String endWord, HashMap<String, Integer> word_no) {
        LinkedList<String> path = new LinkedList<>();
        path.addLast(startWord);
//        System.out.println(startWord);
        int stepLength = 1;
        boolean[] vis = new boolean[len];
        vis[word_no.get(startWord)] = true;
        while (!path.isEmpty()) {
            int path_size = path.size();
            stepLength++;
            while (path_size-- > 0) {
                String now_word = path.pollFirst();
                int word_index = wordList.indexOf(now_word);
                for (int i = 0; i < len; i++) {
                    if (vis[i]) {
                        continue;
                    }
                    if (graph[word_index][i]) {
                        if (wordList.get(i).equals(endWord)) {
                            return stepLength;
                        }
                        path.addLast(wordList.get(i));
                        vis[i] = true;
//                    System.out.println(wordList.get(i));
                    }
                }
            }
        }
        return 0;
    }

    private void buildWordGraph(boolean[][] graph, List<String> wordList) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    graph[i][j] = false;
                } else {
                    if (isConnect(wordList.get(i), wordList.get(j))) {
                        graph[i][j] = graph[j][i] = true;
                    }
                }
            }
        }
    }

    private boolean isConnect(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
            if (count >= 2) {
                return false;
            }
        }
        return count == 1;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        int[] dis = new int[nodeNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 0;

        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(beginId);
        while (!que.isEmpty()) {
            int x = que.poll();
            if (x == endId) {
                return dis[endId] / 2 + 1;
            }
            for (int it : edge.get(x)) {
                if (dis[it] == Integer.MAX_VALUE) {
                    dis[it] = dis[x] + 1;
                    que.offer(it);
                }
            }
        }
        return 0;
    }

    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }

    // LeetCode 参考代码2
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }

        int[] disBegin = new int[nodeNum];
        Arrays.fill(disBegin, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord);
        disBegin[beginId] = 0;
        Queue<Integer> queBegin = new LinkedList<Integer>();
        queBegin.offer(beginId);

        int[] disEnd = new int[nodeNum];
        Arrays.fill(disEnd, Integer.MAX_VALUE);
        int endId = wordId.get(endWord);
        disEnd[endId] = 0;
        Queue<Integer> queEnd = new LinkedList<Integer>();
        queEnd.offer(endId);

        while (!queBegin.isEmpty() && !queEnd.isEmpty()) {
            int queBeginSize = queBegin.size();
            for (int i = 0; i < queBeginSize; ++i) {
                int nodeBegin = queBegin.poll();
                if (disEnd[nodeBegin] != Integer.MAX_VALUE) {
                    return (disBegin[nodeBegin] + disEnd[nodeBegin]) / 2 + 1;
                }
                for (int it : edge.get(nodeBegin)) {
                    if (disBegin[it] == Integer.MAX_VALUE) {
                        disBegin[it] = disBegin[nodeBegin] + 1;
                        queBegin.offer(it);
                    }
                }
            }

            int queEndSize = queEnd.size();
            for (int i = 0; i < queEndSize; ++i) {
                int nodeEnd = queEnd.poll();
                if (disBegin[nodeEnd] != Integer.MAX_VALUE) {
                    return (disBegin[nodeEnd] + disEnd[nodeEnd]) / 2 + 1;
                }
                for (int it : edge.get(nodeEnd)) {
                    if (disEnd[it] == Integer.MAX_VALUE) {
                        disEnd[it] = disEnd[nodeEnd] + 1;
                        queEnd.offer(it);
                    }
                }
            }
        }
        return 0;
    }
}
