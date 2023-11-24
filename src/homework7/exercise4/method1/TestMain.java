package homework7.exercise4.method1;

public class TestMain {
    public static void main(String[] args) {
        Line line1 = new Line(1, 1, 10, 1);
        Line line2 = new Line(1, 2, 10, 2);
        System.out.println(line1.doIntersect(line2));

        Line line3 = new Line(10, 1, 0, 10);
        Line line4 = new Line(0, 0, 10, 10);
        System.out.println(line3.doIntersect(line4));

        Line line5 = new Line(-5, -5, 0, 0);
        Line line6 = new Line(1, 1, 10, 10);
        System.out.println(line5.doIntersect(line6));

        Line line7 = new Line(3, 4, 7, 6);
        Line line8 = new Line(1, 2, 8, 5);
        System.out.println(line7.doIntersect(line8));

        Line line9 = new Line(-2, 0, 2, 0);
        Line line10 = new Line(-1, -1, 1, 1);
        System.out.println(line9.doIntersect(line10));
    }
}

