package leetcode.c916;

import java.util.*;

public class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < words2.length; i++) {
            char[] tempStr = words2[i].toCharArray();
            Arrays.sort(tempStr);
            set.add(String.valueOf(tempStr));
        }

        char[][] waitWord = new char[set.size()][];
        Iterator<String> iterator = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            waitWord[i] = iterator.next().toCharArray();
        }
        int[] waitIndex = new int[set.size()];
        Arrays.fill(waitIndex, 0);


        for(int wordIdx = 0; wordIdx < words1.length; wordIdx++) {
            char[] sortedWord = words1[wordIdx].toCharArray();
            Arrays.sort(sortedWord);
            Arrays.fill(waitIndex, 0);

            for (int i = 0; i < sortedWord.length; i++) {
                for (int j = 0; j < waitIndex.length; j++) {
                    if (waitIndex[j] == -1) {
                        continue;
                    }
                    if (waitWord[j][waitIndex[j]] == sortedWord[i]) {
                        waitIndex[j] = waitIndex[j] + 1 != waitWord[j].length ? waitIndex[j] + 1 : -1 ;
                    }
                }
            }

            boolean b = true;
            for (int i = 0; i < waitIndex.length; i++) {
                if (waitIndex[i] != -1) {
                    b = false;
                    break;
                }
            }

            if (b) {
                result.add(words1[wordIdx]);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"qhqhj","hq","hjo","jhqh","qq","qj","hhqq","qo","ho","oh","q","qo","h","ohqj","hqjo","qhhjo","j","qohjq","qq","jhhoq","qh","johq","q","joqh","q","oq","qjqh","ohqhj","h","j","jqqh","q","hq","hoq","q","hoqqj","qqhjh","hhjq","hqq","h","hq","qjo","hq","qo","hqqj","ohqhq","hhoqq","hhq","qhj","qh","hqq","hh","hh","h","h","qhohq","hqjoq","johhq","qjohh","hhqj","q","hojh","jqh","qqh","oqqh","joq","hoqhq","joh","qqj","qho","qhho","jqo","qqj","jhoq","oqhhj","hq","hqo","hqjo","qohj","o","oqh","qqjhh","oj","q","h","jq","jq","hqhoq","jqho","jhq","o","joqh","h","hho","johq","oj","jqqo","oqjq","hq","o","hqq","h","qhqjh","qhqh","hqjh","hq","qhh","hoqqj","jqqhh","qo","q","qh","jo","h","jh","qqhh","jqoqh","hjq","qjhqh","hjq","h","qh","qjho","oqh","jqoh","qjq","hh","hjoqh","qhh","qhqo","qo","q","hj","qq","hhoq","qq","oqh","j","jo","hq","qhohq","hqh","jqqhh","qhjh","hqqj","qjhoq","h","hqoqj","jh","qqhoj","hhj","qqjh","jhqqh","h","h","j","hjqq","o","qq","h","ojqqh","qq","qhq","ojqqh","ohj","oqqj","johq","oqhhj","h","q","hhoqq","o","jqh","qoh","hqhjq","q","ojhqh","qo","jhhqo","qqj","qo","hjqho","qjh","qq","jqq","qho","hhjq","qoj","h","oj","hhq","h","hqohj","jho","qq","q","hqq","hjqoq","hhoqj","qhj","hq","h","h","qhq","hq","hqqoh","o","h","qoh","jhqh","h","ohqhj","hh","qjhq","hhj","qoh","jqqoh","oh","hqj","oq","oh","q","hjq","q","qhoj","q","oh","hjq","h","jq","hq","hqjq","hhj","qjq","qjoq","ojq","jqho","hjq","qojhh","h","hqqj","hho","h","h","o","jho","o","qojh","qho","qo","hqj","hqqhj","oq","qhjq","oqhjq","q","ohh","qoqjh","hq","qj","hjhoq","hjho","jh","q","qojh","qh","h","h","h","jhhqo","q","hq","jq","q","qqoh","jhqq","h","jo","h","hqq","hq","hqjq","hh","hjhoq","q","q","qhhj","h","oq","johh","hjqqo","jq","jqhh","ho","hq","ohhq","qohhq","h","oqj","hqjqo","jhh","q","jhqqh","hhq","hj","qjhoq","ho","qj","qhhjq","qhjh","o","oj","o","q","oq","jhhqq","h","hhqo","qoq","joqhh","oh","qohqj","jhhqo","ohhj","qqoj","oqh","qo","hohq","qoj","hqohj","qjohh","qh","jhq","qhqjo","hoq","hqj","hq","oqhq","oq","j","hqq","hq","h","oqhh","jqhh","q","jhhqq","ho","hqqoh","oh","hoq","h","qhq","qhoq","hh","hhjq","hqq","qh","jho","hh","hqq","jh","hqj","q","o","jq","hhoqq","qqj","hqqjh","j","hj","qqjho","hqjq","ohhq","qhq","oqjqh","hqo","oh","qhoqj","q","hjho","hqqjo","jqo","jhqqh","joqh","johh","qhqh","jq","oqqhj","ohqhj","j","qjq","oqh","qqjo","hhoj","hqh","hqoqh","qoh","hohq","hoq","qqj","jqho","qhh","ojhhq","johq","oh","qo","ho","qh","qqjo","qhhjq","hqj","hhq","qohqj","jqhho","hq","hh","h","ho","qh","q","o","qqjoh","qo","qq","o","hqhqj","oqqhj","qhhq","ohj","hqoqj","hoqjh","hohq","h","j","hh","q","jqhqo","hjoqq","h","qjh","hqohj","ojhhq","hoq","hqo","oqqh","q","hq","qoj","qj","jqh","j","q","q","qhjqh","ojh","hqjoh","jhqo","h","ho","o","hqh","q","qqj","hoqqh","jh","hj","ohqh","jhhq","jqqho","o","hjhoq","oqj","jqqho","hqhj","o","oq","jhoh","qhoh","qhq","qoh","q","hjohq","oh","oq","oq","qhjho","h","qj","qh","ojhq","ohq","qhhq","qhjq","qoq","oqqjh","qqhhj","qhqjo","hq","jqh","qqh","hqhj","j","jh","qoh","qqh","h","qohjh","qjqo","qho","h","qo","ho","q","ojhqq","hhjo","h","qqhjo","oqhq","oqj","qh","j","hq","hqo","j","jqq","hj","hq","hohqq","q","hh","j","jqqoh","qoqh","hoq","qhjoq","hqhq","hoj","o","hjoqh","q","q","qjohq","o","oqjh","oh","oqh","ojq","hqoh","j","jhqh","q","hj","ojh","qq","hjq","qhh","hjqoh","ohjhq","qhjqh","qoh","hh","o","hq","h","hhjq","qjh","hqj","hho","qhho","hqh","oh","jh","qjh","hq","qh","oh","jq","q","hqhoj","j","qho","jo","h","qh","oh","hoqq","hqh","qjh","jhq","hq","qjh","ho","hoqj","hhqjo","hq","hoqj","qjhh","qh","hoqjh","hjqhq","hqqjh","hj","hhqo","qh","h","j","hhqoq","qhqo","ho","qqoh","q","hj","hq","qqj","j","johq","ohjq","oj","qhq","qqjho","hjq","qh","j","jqo","h"};


        List<String> strings = new Solution().wordSubsets(words1, words2);
        System.out.println("strings.toString() = " + strings.toString());
    }
}
