package homework2.exercise1;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Controllers extends JPanel implements Runnable {
    public final String nameProgram = "Sorting";
    public final String nameChart = "So sánh các thuật toán sắp xếp";
    public final String xAxis = "Số phần tử sắp xếp";
    private final String yAxis = "Thời gian sắp xếp";

    public final int maxWidth = 1000;
    public final int maxHeight = 720;
    public Dimension screenSize;
    public boolean isFullScreen;

    public Thread threadMain;

    public double FPS = 60;

    private XYSeries bubble;
    private XYSeries bubble2;
    private XYSeries insertion;
    private XYSeries selection;
    private XYSeries merge;
    private XYSeries quick;

    private int number = 0;

    public Controllers() {
        this.setName(nameProgram);
        screenSize = new Dimension(maxWidth, maxHeight);
        this.setPreferredSize(screenSize);

        loadData();

        startThread();
    }

    private void loadData() {
        bubble = new XYSeries("Bubble Sort");
        bubble2 = new XYSeries("Bubble Sort2");
        insertion = new XYSeries("Insertion Sort");
        selection = new XYSeries("Selection Sort");
        quick = new XYSeries("Quick Sort");
        merge = new XYSeries("Merge Sort");
    }

    public void startThread() {
        threadMain = new Thread(this);
        threadMain.start();
    }

    @Override
    public void run() {
        while (threadMain != null) {
            if (number == 10_000) break;
            update();
            repaint();
            try {
                Thread.sleep((long) (1000 / FPS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        int[] array = new int[number+=10];
        Random rd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(1_000_000);
        }

        int[] arraySort = Arrays.copyOf(array, array.length);
        ISort bubbleSort = new BubbleSort();
        bubbleSort.sort(arraySort);
        bubble.add(number, bubbleSort.timeRun());

        arraySort = Arrays.copyOf(array, array.length);
        ISort bubbleSort2 = new BubbleSort2();
        bubbleSort2.sort(arraySort);
        bubble2.add(number, bubbleSort2.timeRun());

        arraySort = Arrays.copyOf(array, array.length);
        ISort insertionSort = new InsertionSort();
        insertionSort.sort(arraySort);
        insertion.add(number, insertionSort.timeRun());

        arraySort = Arrays.copyOf(array, array.length);
        ISort selectionSort = new SelectionSort();
        selectionSort.sort(arraySort);
        selection.add(number, selectionSort.timeRun());

        arraySort = Arrays.copyOf(array, array.length);
        ISort mergeSort = new MergeSort();
        mergeSort.sort(arraySort);
        merge.add(number, mergeSort.timeRun());

        arraySort = Arrays.copyOf(array, array.length);
        ISort quickSort = new QuickSort();
        quickSort.sort(arraySort);
        quick.add(number, quickSort.timeRun());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(bubble);
        dataset.addSeries(bubble2);
        dataset.addSeries(insertion);
        dataset.addSeries(selection);
        dataset.addSeries(merge);
        dataset.addSeries(quick);


        JFreeChart chart = ChartFactory.createXYLineChart(
                nameChart,
                xAxis,
                yAxis,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
 
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(screenSize);
        add(chartPanel);
    }
}
