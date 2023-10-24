package homework4.practice2.lessona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GfG {

    public static void main(String args[]) throws IOException {
// 		 Scanner sc = new Scanner(System.in);
// 		 int t=sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t > 0) {
            MyStack obj = new MyStack();
            int Q = Integer.parseInt(read.readLine());
            int k = 0;
            String str[] = read.readLine().trim().split(" ");
            while (Q > 0) {
                int QueryType = 0;
                QueryType = Integer.parseInt(str[k++]);
                if (QueryType == 1) {
                    int a = Integer.parseInt(str[k++]);

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
