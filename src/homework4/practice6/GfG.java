package homework4.practice6;

import java.util.Scanner;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            MyQueue obj = new MyQueue();
            int Q = sc.nextInt();
            while (Q > 0) {
                int QueryType = 0;
                QueryType = sc.nextInt();
                if (QueryType == 1) {
                    int a = sc.nextInt();

                    obj.push(a);

                } else if (QueryType == 2) {
                    System.out.print(obj.pop() + " ");
                }
                Q--;
            }
            System.out.println("");
            t--;
        }
    }
}
