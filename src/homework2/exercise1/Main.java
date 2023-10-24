package homework2.exercise1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Arrays;
import java.util.Random;

public class Main {
//    public static void main(String[] args) {
////        //INPUT SYSTEM
////        Scanner sc = new Scanner(System.in);
////        int[] array = new int[sc.nextInt()];
////        for (int i = 0; i < array.length; i++) {
////            array[i] = sc.nextInt();
////        }
//
//        //INPUT RANDOM
//        int n = 1_000;
//        int[] array = new int[n];
//        Random rd = new Random();
//        for (int i = 0; i < array.length; i++) {
//            array[i] = rd.nextInt(1_000_000);
//        }
//        System.out.println(Arrays.toString(array));
//
//        int[] arraySort = Arrays.copyOf(array, array.length);
//        ISort bubbleISort = new BubbleSort();
//        bubbleISort.sort(arraySort);
//        System.out.println(Arrays.toString(arraySort));
//        System.out.println(bubbleISort.timeRun());
//
//        arraySort = Arrays.copyOf(array, array.length);
//        ISort insertionISort = new InsertionSort();
//        insertionISort.sort(arraySort);
//        System.out.println(Arrays.toString(arraySort));
//        System.out.println(insertionISort.timeRun());
//
//        arraySort = Arrays.copyOf(array, array.length);
//        ISort selectionISort = new SelectionSort();
//        selectionISort.sort(arraySort);
//        System.out.println(Arrays.toString(arraySort));
//        System.out.println(selectionISort.timeRun());
//
//        arraySort = Arrays.copyOf(array, array.length);
//        ISort quickISort = new QuickSort();
//        quickISort.sort(arraySort);
//        System.out.println(Arrays.toString(arraySort));
//        System.out.println(quickISort.timeRun());
//
//        arraySort = Arrays.copyOf(array, array.length);
//        ISort mergeISort = new MergeSort();
//        mergeISort.sort(arraySort);
//        System.out.println(Arrays.toString(arraySort));
//        System.out.println(mergeISort.timeRun());
//    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Controllers controllers = new Controllers();
        jFrame.add(controllers);
        jFrame.pack();

//        jFrame.addComponentListener(new ComponentAdapter() {
//            @Override
//            public void componentResized(ComponentEvent e) {
//                if ((jFrame.getExtendedState() & JFrame.MAXIMIZED_BOTH) == JFrame.MAXIMIZED_BOTH) {
//                    Toolkit toolkit = Toolkit.getDefaultToolkit();
//                    controllers.screenSize = toolkit.getScreenSize();
//                    controllers.isFullScreen = true;
//                } else {
//                    controllers.screenSize = new Dimension(controllers.maxWidth, controllers.maxHeight);
//                    controllers.isFullScreen = false;
//                }
//            }
//        });

        jFrame.setVisible(true);
    }
}
