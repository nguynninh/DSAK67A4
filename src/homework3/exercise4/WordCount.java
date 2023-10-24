package homework3.exercise4;

import java.util.List;

public class WordCount {
    private String word;
    private int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WordCount wordCount = (WordCount) o;
        return word.equals(wordCount.word);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    public static boolean isContain(List<WordCount> wordCounts, WordCount target) {
        return wordCounts.contains(target);
    }

    public static boolean isContainUsingIndexOf(List<WordCount> wordCounts, WordCount target) {
        return wordCounts.indexOf(target) != -1;
    }
}

