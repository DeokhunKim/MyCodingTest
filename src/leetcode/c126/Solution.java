package leetcode.c126;

import java.util.*;

public class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        // create graph
        Map<String, List<String>> graph = new HashMap<>();
        putInGraphDifferSingleLetter(wordList, graph, beginWord);
        for (String a : wordList) {
            putInGraphDifferSingleLetter(wordList, graph, a);
        }

        // BFS
        Set<String> visit = new HashSet<>();
        Map<String, List<String>> reverseRoad = new HashMap<>();
        visit.add(beginWord);
        List<String> queue = new ArrayList<>();
        queue.add(beginWord);
        boolean isFind = false;
        while (true) {
            List<String> nextQueue = new ArrayList<>();
            Set<String> visitThisTime = new HashSet<>();
            for (String originStr : queue) {
                List<String> changeStrList = graph.get(originStr);
                for (String changeStr : changeStrList) {
                    if (visit.add(changeStr)) {
                        List<String> l = new ArrayList<>();
                        l.add(originStr);
                        reverseRoad.put(changeStr, l);
                        nextQueue.add(changeStr);
                        visitThisTime.add(changeStr);
                    } else if (visitThisTime.contains(changeStr)) {
                        reverseRoad.get(changeStr).add(originStr);
                    } else {
                        //not thing..
                    }
                }
            }

            for (String s : nextQueue) {
                if (s.equals(endWord)) {
                    isFind = true;
                    break;
                }
            }

            if (isFind) {
                break;
            }
            if (nextQueue.isEmpty()) {
                break;
            }
            queue = nextQueue;
        }

        // store result
        Stack<String> stack = new Stack<>();
        storeResult(stack, reverseRoad, endWord, beginWord, result);



        return result;
    }

    private void storeResult(Stack<String> stack, Map<String, List<String>> reverseRoad, String word, String beginWord,
                             List<List<String>> result) {
        stack.push(word);

        List<String> strings = reverseRoad.get(word);
        if (strings == null) {
            return;
        }

        for (String string : strings) {
            if (string.equals(beginWord)) {
                stack.push(string);
                List<String> list = new ArrayList<>(stack);
                Collections.reverse(list);
                result.add(list);
                stack.pop();
                return;
            }

            storeResult(stack, reverseRoad, string, beginWord, result);
            stack.pop();
        }

    }

    private void putInGraphDifferSingleLetter(List<String> wordList, Map<String, List<String>> graph, String a) {
        List<String> list = new ArrayList<>();
        for (String b : wordList) {
            if(a.equals(b)) continue;
            if (isDifferSingleLetter(a, b)) {
                list.add(b);
            }
        }
        graph.put(a, list);
    }

    private boolean isDifferSingleLetter(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }

        if (diff == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] a = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] b = {"hot","dot","dog","lot","log"};

        List<String> wordList = Arrays.stream(b).toList();


        List<List<String>> ladders = new Solution().findLadders(beginWord, endWord, wordList);
        System.out.println("ladders = " + ladders.toString());

    }
}
