package homework7.exercise1.method1;

public class TestMain {
    public static void main(String[] args) {
        List<Integer> unSortingArray = new UnsortingArray<>();
        testList(unSortingArray);
        System.out.println();

        List<Integer> sortingArray = new SortingArray<>();
        testList(sortingArray);
        System.out.println();

        List<Integer> unSortingLinked = new UnsortingLinked<>();
        testList(unSortingLinked);
        System.out.println();

        List<Integer> sortingLinked = new SortingLinked<>();
        testList(sortingLinked);
        System.out.println();
    }

    private static void testList(List<Integer> list) {
        list.add(10);
        list.add(5);
        list.add(20);
        list.add(15);
        String[] name = list.getClass().getName().split("\\.");
        System.out.println(name[name.length - 1] + list);

        int searchValue = 20;
        int index = list.findByValue(searchValue);
        if (index != -1)
            System.out.println(searchValue + " found at index " + index);
        else
            System.out.println(searchValue + " not found in the array.");
    }

}
