package homework1.exercise5.p1_28;

import java.util.Random;

public class SentenceRepetitionWithTypos {
    private Random rd = new Random();
    private final String sentence = "I will never spam my friends again.";
    private final int numberRepetitions = 100;

    public SentenceRepetitionWithTypos() {
    }

    public void printSentenceRepetitionWithTypos() {
        for (int i = 0; i < numberRepetitions; i++) {
            System.out.println(i + 1 + ".\t" + sentenceCreation(sentence));
        }
    }

    private String sentenceCreation(String sentence) {
        StringBuilder builder = new StringBuilder(sentence);
        for (int i = 0; i < 8; i++) {
            int index = rd.nextInt(sentence.length());
            char newCharacters = (char) ('a' + rd.nextInt('z' - 'a' + 1));
            builder.setCharAt(index, newCharacters);
        }
        return builder.toString();
    }
}
