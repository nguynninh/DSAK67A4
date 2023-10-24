package homework1.exercise5.p1_26;

public class Main {
    public static void main(String[] args) {
        ReverseTheArrangement rv = new ReverseTheArrangement();
        System.out.println(rv.mergeLines(rv.getTextLine("D:\\DSAk67a4\\src\\homework1\\exercise5\\p1_26\\ReverseTheArrangement.java")));
        System.out.println(rv.mergeLines(rv.getTextLineReverse()));
        rv.writeOutputFile("ReverseTheArrangement2.java");
    }
}
