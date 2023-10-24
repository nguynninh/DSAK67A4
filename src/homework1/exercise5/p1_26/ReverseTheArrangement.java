package homework1.exercise5.p1_26;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseTheArrangement {
    private List<String> textLine;

    public ReverseTheArrangement() {
        this.textLine = new ArrayList<>();
    }

    public List<String> getTextLine(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()) {
                textLine.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return textLine;
    }

    public List<String> getTextLineReverse() {
        List<String> textLineNew = new ArrayList<>();
        for (int i = 0; i < textLine.size(); i++) {
            String s = "";
            for (int j = textLine.get(i).length() - 1; j >= 0; --j) {
                s += textLine.get(i).charAt(j);
            }
            textLineNew.add(s);
        }
        return textLineNew;
    }

    public void writeOutputFile(String url) {
        writeOutputFile(url, getTextLineReverse());
    }

    public void writeOutputFile(String url, List<String> textLine) {
        try {
            File file = new File(url);
            FileWriter writer = new FileWriter(file);

            for (String line : textLine) {
                writer.write(line + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String mergeLines(List<String> textLine) {
        String text = "";
        for (String s : textLine) {
            text += s + "\n";
        }
        return text;
    }
}
