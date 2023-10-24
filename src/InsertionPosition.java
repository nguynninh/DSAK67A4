public class InsertionPosition {

    public static int getInsertPosition(int[] a, int x) {
        for (int i = 0; i < a.length; i++)
            if (a[i] >= x) return i;
        return (x > a[a.length - 1]) ? a.length : -1;
    }


    public static void main(String[] args) {
        int[] a = {1, 1, 2, 4, 6, 7, 9, 10, 19};
        System.out.println(getInsertPosition(a, 0));
        System.out.println(getInsertPosition(a, 1));
        System.out.println(getInsertPosition(a, 2));
        System.out.println(getInsertPosition(a, 3));
        System.out.println(getInsertPosition(a, 4));
        System.out.println(getInsertPosition(a, 5));
        System.out.println(getInsertPosition(a, 18));
        System.out.println(getInsertPosition(a, 19));
        System.out.println(getInsertPosition(a, 20));
    }

}