package homework3.exercise5.exercise2x;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<>();

        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");

        System.out.println("Danh sách ban đầu: " + myList);

        System.out.println("Kích thước danh sách: " + myList.size());

        System.out.println("Danh sách rỗng? " + myList.isEmpty());

        System.out.println("Có phần tử 'B' trong danh sách? " + myList.isContain("B"));
        System.out.println("Có phần tử 'E' trong danh sách? " + myList.isContain("E"));

        System.out.println("Phần tử tại vị trí 2: " + myList.get(2));

        myList.set(1, "X");
        System.out.println("Danh sách sau khi thay đổi:" + myList);

        myList.remove("C");
        System.out.println("Danh sách sau khi xóa:" + myList);

        myList.clear();
        System.out.println("Danh sách sau khi xóa toàn bộ:" + myList);
    }
}

