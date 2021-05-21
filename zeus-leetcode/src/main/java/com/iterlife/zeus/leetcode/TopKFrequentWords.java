package com.iterlife.zeus.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @desc:https://leetcode-cn.com/problems/top-k-frequent-words/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/5/20 22:07
 **/
public class TopKFrequentWords {
    public static void main(String[] args) {
        //String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        for (int i = 1; i <= words.length; ++i) {
            System.out.println("k=" + i + ":" + new TopKFrequentWordsSolution().topKFrequent(words, i) + "\n\n");
        }

    }
}


class TopKFrequentWordsSolution {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> wordCounter = new HashMap();
        Arrays.asList(words).forEach(word -> {
            wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
        });

        PriorityQueue<Word> priorityQueue = new PriorityQueue<Word>(k, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                int t = o1.counter - o2.counter;
                return t != 0 ? t : o2.word.compareTo(o1.word);
            }
        });
        wordCounter.forEach((word, counter) -> {
            Word aWord = new Word(word, counter);
            priorityQueue.add(aWord);
        });

        //   System.out.println("Queue result:" + priorityQueue.toString());
        List<Word> wordList = new ArrayList<>();
        int t = priorityQueue.size() - k;
        while (!priorityQueue.isEmpty()) {
            Word word = priorityQueue.poll();
            if (t-- > 0) {
                continue;
            }
            wordList.add(word);
        }
        System.out.println("List result:" + wordList.toString());
        return wordList.stream().sorted(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                int t = o2.counter - o1.counter;
                return t != 0 ? t : o1.word.compareTo(o2.word);
            }
        }).map(Word::getWord).collect(Collectors.toList());

    }

    class Word {


        private String word;
        private int counter;

        public Word(String word,
                    int counter) {
            this.word = word;
            this.counter = counter;
        }

        public String getWord() {
            return word;
        }

        @Override
        public String toString() {
            return "Word{" +
                    "word='" + word + '\'' +
                    ", counter=" + counter +
                    '}';
        }
    }
}
